package com.ajax_systems.akka.dao;

import com.ajax_systems.akka.model.CsvReport;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;


public class CsvReportRepository {

    private final ConcurrentHashMap<Integer, CsvReport> writers = new ConcurrentHashMap<>();

    private final AmountSequence seqAmount = new AmountSequence();

    private final IdSequence seqId = new IdSequence();

    public Collection<CsvReport> find() {
        return writers.values();
    }

    public CsvReport findOne(Integer id) {
        return writers.get(id);
    }

    public CsvReport save(CsvReport writer) {
        Integer id = 0;
        CsvReport newWriter = new CsvReport();

        if(writer!=null) {
            id = seqId.get(writer);
            newWriter.writer(writer.getWriter())
                    .id(id)
                    .amount(seqAmount.get(writer))
                    .jsonUrl(writer.getJsonUrl())
                    .csvUrl(writer.getCsvUrl());
            writers.put(id, newWriter);
        }
        return newWriter;
    }

    public void update(Integer id, CsvReport writer) {
        writers.put(id, writer);
    }

    public void delete(Integer id) {
        writers.remove(id);
    }
}
