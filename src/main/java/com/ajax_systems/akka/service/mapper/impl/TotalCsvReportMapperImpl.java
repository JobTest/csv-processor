package com.ajax_systems.akka.service.mapper.impl;

import com.ajax_systems.akka.model.CsvReport;
import com.ajax_systems.akka.service.dto.CsvReportDTO;
import com.ajax_systems.akka.service.dto.TotalCsvReportDTO;
import com.ajax_systems.akka.service.mapper.TotalCsvReportMapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;


public class TotalCsvReportMapperImpl implements TotalCsvReportMapper {

    public TotalCsvReportDTO toDto(Collection<CsvReport> entities) {
        if (entities == null) {
            return null;
        } else {
            final Long totalAmount = entities.stream()
                    .mapToLong(e -> e.getAmount())
                    .sum();
            Collection<CsvReportDTO> books = entities.stream()
                    .map(csvReport -> {
                        double percentage = (100 * (double) csvReport.getAmount()) / (double) totalAmount;
                        CsvReportDTO csvReportDTO = new CsvReportDTO();
                        csvReportDTO.setWriter(csvReport.getWriter());
                        csvReportDTO.setAmount(csvReport.getAmount());
                        csvReportDTO.setJsonUrl(csvReport.getJsonUrl());
                        csvReportDTO.setCsvUrl(csvReport.getCsvUrl());
                        csvReportDTO.setPercentage(percentage);
                        return csvReportDTO;
                    }).collect(Collectors.toList());

            TotalCsvReportDTO totalCsvReportDTO = new TotalCsvReportDTO();
            totalCsvReportDTO.setTotalAmount(totalAmount);
            totalCsvReportDTO.setBooks(books);
            return totalCsvReportDTO;
        }
    }

    public Collection<CsvReport> toEntity(TotalCsvReportDTO totalCsvReportDTO) {
        if (totalCsvReportDTO == null) {
            return null;
        } else {
            Collection<CsvReport> csvReports = new ArrayList<>();
            for (CsvReport csvReport: csvReports) {
                csvReports.add(csvReport);
            }
            return csvReports;
        }
    }
}
