package com.ajax_systems.akka.service;

import akka.Done;
import akka.NotUsed;
import akka.stream.*;
import akka.stream.javadsl.*;
import akka.util.ByteString;
import com.ajax_systems.akka.dao.BookRepository;
import com.ajax_systems.akka.dao.CsvReportRepository;
import com.ajax_systems.akka.model.Book;
import com.ajax_systems.akka.model.Csv;
import com.ajax_systems.akka.model.CsvReport;
import com.ajax_systems.akka.service.mapper.BookMapper;
import com.ajax_systems.akka.service.mapper.CsvMapper;
import com.ajax_systems.akka.service.mapper.impl.BookMapperImpl;
import com.ajax_systems.akka.service.mapper.impl.CsvMapperImpl;
import com.ajax_systems.akka.web.util.CsvUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.io.File;
import java.io.FileWriter;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletionStage;


public class ActorModelHelper {

    private static final Logger log = LoggerFactory.getLogger(ActorModelHelper.class);

    private static final int MAXIMUM_FRAME_LENGTH = 256;

    private CsvReportRepository csvReportRepository;

    private BookRepository bookRepository;

    private CsvMapper csvMapper;

    private BookMapper bookMapper;

    @Inject
    public ActorModelHelper(BookRepository bookRepository,
                            CsvMapperImpl dataCSVMapper,
                            CsvReportRepository csvReportRepository,
                            BookMapperImpl bookMapper) {
        this.csvReportRepository = csvReportRepository;
        this.bookRepository = bookRepository;
        this.csvMapper = dataCSVMapper;
        this.bookMapper = bookMapper;
    }

    private Flow<ByteString, String, NotUsed> dataFlow = Framing
            .delimiter(ByteString.fromString("\n"), MAXIMUM_FRAME_LENGTH, FramingTruncation.ALLOW)
            .map(byteString -> byteString.decodeString(ByteString.UTF_8()));

    private Flow<ByteString, Book, NotUsed> bookFlow = Framing
            .delimiter(ByteString.fromString("\n"), MAXIMUM_FRAME_LENGTH, FramingTruncation.ALLOW)
            .map(byteString -> {
                String line = byteString.decodeString(ByteString.UTF_8());
                String[] fields = line.split(",");

                String title = fields[1];
                Double price = Double.parseDouble(fields[2]);
                Integer number = Integer.parseInt(fields[3]);
                String author = fields[4];
                String about = fields[5];
                return new Book()
                        .title(title)
                        .author(author)
                        .about(about)
                        .price(price)
                        .number(number);
            });

    private Sink<Csv, CompletionStage<Done>> dataLogProcess = Sink.foreach(csv -> log.info("{}", csvMapper.toDto(csv)));

    private Sink<Book, CompletionStage<Done>> bookLogProcess = Sink.foreach(book -> log.info("{}", bookMapper.toDto(book)));

    private Sink<Csv, CompletionStage<Done>> reportRepositoryProcess = Sink.foreach(csv -> {
        if (csv.getWriter().equals("UNKNOWN")) return;

        String writer = csv.getWriter();
        String jsonUrl = getOutUrl() + writer + "." + CsvUtil.JSON_EXT;
        String csvUrl = getOutUrl() + writer + "." + CsvUtil.CSV_EXT;
        CsvReport csvReport = new CsvReport()
                .writer(writer)
                .jsonUrl(jsonUrl)
                .csvUrl(csvUrl);
        csvReportRepository.save(csvReport);
    });

    private Sink<Book, CompletionStage<Done>> bookRepositoryProcess = Sink.foreach(book -> bookRepository.save(book));

    private Sink<Csv, CompletionStage<Done>> fileProcess = Sink.foreach(csv -> {
        if (csv.getWriter().equals("UNKNOWN")) return;

        try (FileWriter fr = new FileWriter(new File(getOutPath(csv.getWriter())), true)) {
            fr.write(csv.getValue() + '\n');
        }
    });

    private Graph<ClosedShape, CompletionStage<Done>> doUploadGraph(final Source<Csv, Object> dataSource) {
        return GraphDSL.create(dataLogProcess, (builder, sink) -> {
            UniformFanOutShape<Csv, Csv> broadcast = builder.add(Broadcast.create(3));
            SourceShape<Csv> source = builder.add(dataSource);
            SinkShape<Csv> memoSink = builder.add(reportRepositoryProcess);
            SinkShape<Csv> fileSink = builder.add(fileProcess);

            builder.from(source).viaFanOut(broadcast).to(sink)
                    .from(broadcast).to(memoSink)
                    .from(broadcast).to(fileSink);

            return ClosedShape.getInstance();
        });
    }

    private Graph<ClosedShape, CompletionStage<Done>> doDownloadGraph(final Source<Book, CompletionStage<IOResult>> dataSource) {
        return GraphDSL.create(bookLogProcess, (builder, sink) -> {
            UniformFanOutShape<Book, Book> broadcast = builder.add(Broadcast.create(2));
            SourceShape<Book> source = builder.add(dataSource);
            SinkShape<Book> memoSink = builder.add(bookRepositoryProcess);

            builder.from(source).viaFanOut(broadcast).to(sink)
                    .from(broadcast).to(memoSink);

            return ClosedShape.getInstance();
        });
    }

    private String getOutPath(String writer) {
        return CsvUtil.config.getString("csv-processor.data-dir") + "/" + writer + "." + CsvUtil.CSV_EXT;
    }

    private String getOutUrl() {
        String host = CsvUtil.config.getString("server.host");
        Integer port = CsvUtil.config.getInt("server.port");
        return "http://" + host + ":" + port + "/books-by-writer/";
    }

    public Graph<ClosedShape, CompletionStage<Done>> getUploadGraph(Source<ByteString, Object> source) {
        Source<Csv, Object> csvSource = source
                .via(dataFlow)
                .map(csvMapper::fromData);
        return doUploadGraph(csvSource);
    }

    public Graph<ClosedShape, CompletionStage<Done>> getDownloadGraph(String source) {
        Source<Book, CompletionStage<IOResult>> bookSource = FileIO.fromFile(new File(getOutPath(source)))
                .via(bookFlow);
        return doDownloadGraph(bookSource);
    }

    public Collection<CsvReport> getReportCache() {
        return csvReportRepository.find();
    }

    public List<Book> getBookCache() {
        return bookRepository.find();
    }
}
