package com.ajax_systems.akka.service.impl;

import akka.Done;
import akka.actor.ActorSystem;
import akka.stream.*;
import akka.stream.javadsl.*;
import akka.util.ByteString;
import com.ajax_systems.akka.model.Book;
import com.ajax_systems.akka.model.CsvReport;
import com.ajax_systems.akka.service.ActorModelHelper;
import com.ajax_systems.akka.service.dto.BookDTO;
import com.ajax_systems.akka.service.dto.TotalCsvReportDTO;
import com.ajax_systems.akka.service.mapper.BookMapper;
import com.ajax_systems.akka.service.mapper.TotalCsvReportMapper;
import com.ajax_systems.akka.service.mapper.impl.BookMapperImpl;
import com.ajax_systems.akka.service.CsvService;
import com.ajax_systems.akka.service.mapper.impl.TotalCsvReportMapperImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.inject.Inject;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;


public class CsvServiceImpl implements CsvService {

    private static final Logger log = LoggerFactory.getLogger(CsvServiceImpl.class);

    private ActorSystem system = ActorSystem.create("csv-processor");

    private BookMapper bookMapper;

    private TotalCsvReportMapper totalCsvReportMapper;

    private ActorModelHelper actorModelHelper;

    @Inject
    public CsvServiceImpl(BookMapperImpl bookMapper,
                          TotalCsvReportMapperImpl totalCsvReportMapper,
                          ActorModelHelper actorModelHelper) {
        this.bookMapper = bookMapper;
        this.totalCsvReportMapper = totalCsvReportMapper;
        this.actorModelHelper = actorModelHelper;
    }

    private void run(Graph<ClosedShape, CompletionStage<Done>> graph) {
        CompletionStage<Done> run = RunnableGraph.fromGraph(graph)
                .run(ActorMaterializer.create(system));

        while (!run.toCompletableFuture().isDone()) {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void doSort(final List<Book> books, String sort) {
        if (sort==null) return;

        sort = sort.toLowerCase();
        switch (sort) {
            case "number": {
                Collections.sort(books, Book.sortByNumber);
                break;
            }
            case "price": {
                Collections.sort(books, Book.sortByPrice);
                break;
            }
            default: {
                break;
            }
        }
    }

    @Override
    public void doUpload(Source<ByteString, Object> source) {
        log.debug("upload ByteString data");
        Graph<ClosedShape, CompletionStage<Done>> uploadGraph = actorModelHelper.getUploadGraph(source);
        run(uploadGraph);
    }

    @Override
    public TotalCsvReportDTO findTotalBooks() {
        log.debug("get TotalCsvReport");
        Collection<CsvReport> result = actorModelHelper.getReportCache();
        return totalCsvReportMapper.toDto(result);
    }

    @Override
    public List<BookDTO> findBookByWriter(String source, String sort) {
        log.debug("get Book by Writer={}", source);
        Graph<ClosedShape, CompletionStage<Done>> downloadGraph = actorModelHelper.getDownloadGraph(source);
        run(downloadGraph);

        List<Book> result = actorModelHelper.getBookCache();
        doSort(result, sort);
        return result.stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }
}
