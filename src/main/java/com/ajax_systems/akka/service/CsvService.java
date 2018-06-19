package com.ajax_systems.akka.service;

import akka.stream.javadsl.Source;
import akka.util.ByteString;
import com.ajax_systems.akka.service.dto.BookDTO;
import com.ajax_systems.akka.service.dto.TotalCsvReportDTO;

import java.util.List;


public interface CsvService {

    /**
     *
     * @param data
     * @return
     */
    void doUpload(Source<ByteString, Object> data);

    /**
     *
     * @return
     */
    TotalCsvReportDTO findTotalBooks();

    List<BookDTO> findBookByWriter(String writer, String sort);
}
