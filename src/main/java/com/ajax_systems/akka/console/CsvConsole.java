package com.ajax_systems.akka.console;

import com.ajax_systems.akka.service.CsvService;
import com.ajax_systems.akka.service.dto.BookDTO;
import com.ajax_systems.akka.service.impl.CsvServiceImpl;
import com.ajax_systems.akka.web.util.PrintUtil;

import javax.inject.Inject;
import java.io.UnsupportedEncodingException;
import java.util.List;


public class CsvConsole {

    private CsvService csvService;

    @Inject
    public CsvConsole(CsvServiceImpl csvService) {
        this.csvService = csvService;
    }

    public void startConsole(String writer, String sort) {
        writer = PrintUtil.matchWriter(writer.toLowerCase());
        if (writer.equals("UNKNOWN")) return;

        try {
            List<BookDTO> books = csvService.findBookByWriter(writer, sort);
            PrintUtil.print(books, sort);
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
    }
}
