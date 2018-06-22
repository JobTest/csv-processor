package com.ajax_systems.akka.service;

import akka.stream.javadsl.Source;
import akka.util.ByteString;
import com.ajax_systems.akka.service.dto.BookDTO;
import com.ajax_systems.akka.service.dto.TotalCsvReportDTO;

import java.util.List;


public interface CsvService {

    /**
     * Upload form-data from client side to server side use rest-api
     *
     * @param data
     */
    void doUpload(Source<ByteString, Object> data);

    /**
     * Download data from server side to client side use rest-api
     *
     * @param writer
     * @param sort
     * @return
     */
    List<BookDTO> findBookByWriter(String writer, String sort);

    /**
     * Get report full status
     *
     * @return
     */
    TotalCsvReportDTO findTotalBooks();
}
