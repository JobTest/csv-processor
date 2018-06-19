package com.ajax_systems.akka.dao;

import com.ajax_systems.akka.model.CsvReport;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;


public class CsvReportRepository {

    private final ConcurrentHashMap<Integer, CsvReport> csvReports = new ConcurrentHashMap<>();

    private final ConcurrentHashMap<Integer, Long> bookAmount = new ConcurrentHashMap<>();

    public Collection<CsvReport> find() {
        return csvReports.values();
    }

    public CsvReport findOne(Integer id) {
        return csvReports.get(id);
    }

    public CsvReport save(CsvReport csvReport) {
        Integer id = 0;
        CsvReport newCsv = new CsvReport();

        if(csvReport!=null) {
            id = csvReport.hashCode();
            long amount = getRecount(id);
            newCsv.writer(csvReport.getWriter())
                    .amount(amount)
                    .jsonUrl(csvReport.getJsonUrl())
                    .csvUrl(csvReport.getCsvUrl());
            csvReports.put(id, newCsv);
        }
        return newCsv;
    }

    public void update(Integer id, CsvReport csv) {
        csvReports.put(id, csv);
    }

    public void delete(Integer id) {
        csvReports.remove(id);
    }

    private long getRecount(int id) {
        Long amount = bookAmount.get(id);
        amount = (amount!=null) ? amount + 1 : 1;
        bookAmount.put(id, amount);
        return amount;
    }
}
