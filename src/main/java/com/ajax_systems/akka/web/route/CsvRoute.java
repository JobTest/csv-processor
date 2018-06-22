package com.ajax_systems.akka.web.route;

import akka.http.javadsl.marshallers.jackson.Jackson;
import akka.http.javadsl.model.StatusCodes;
import akka.http.javadsl.server.HttpApp;
import akka.http.javadsl.server.Route;
import akka.http.javadsl.unmarshalling.Unmarshaller;
import com.ajax_systems.akka.service.CsvService;
import com.ajax_systems.akka.service.dto.BookDTO;
import com.ajax_systems.akka.service.dto.TotalCsvReportDTO;
import com.ajax_systems.akka.service.impl.CsvServiceImpl;
import com.ajax_systems.akka.web.util.CsvUtil;

import javax.inject.Inject;
import java.util.Collection;
import java.util.function.Function;


public class CsvRoute extends HttpApp {

    private CsvService csvService;

    @Inject
    public CsvRoute(CsvServiceImpl csvService) {
        this.csvService = csvService;
    }

    public Route findTotalBooks() {
        TotalCsvReportDTO totalCsvReportDTO = csvService.findTotalBooks();
        return complete(StatusCodes.OK, totalCsvReportDTO, Jackson.marshaller());
    }

    public Function<String, Route> findBookByWriter = writer -> {
        Collection<BookDTO> books = csvService.findBookByWriter(writer, null);
        return (books == null) ? reject() : complete(StatusCodes.OK, books, Jackson.marshaller());
    };

    @Override
    public Route routes() {
        return route(
                path("", () ->
                        getFromResource("web/index.html")
                ),

                pathPrefix("books.json", () ->
                        pathEndOrSingleSlash(() -> route(
                                get(() -> findTotalBooks())
                        ))),

                pathPrefix("books", () ->
                        pathEndOrSingleSlash(() -> route(
                                post(() ->
                                        entity(Unmarshaller.entityToMultipartFormData(), data -> {
                                            csvService.doUpload(data.toEntity().getDataBytes());
                                            return findTotalBooks();
                                        }))
                        ))),

                pathPrefix("books-by-writer", () ->
                        path(data -> route(
                                get(() ->
                                {
                                    String[] split = data.split("\\.");
                                    if (split.length!=2)
                                        return complete(StatusCodes.BAD_REQUEST);

                                    String writer = split[0];
                                    String ext = split[1];

                                    if (ext.equals(CsvUtil.JSON_EXT)) {
                                        return findBookByWriter.apply(writer);
                                    }
                                    if (ext.equals(CsvUtil.CSV_EXT)) {
                                        return getFromFile(CsvUtil.config.getString("csv-processor.data-dir") + "/" + data);
                                    }
                                    return complete(StatusCodes.NOT_FOUND);
                                })
                        )))
        );
    }
}
