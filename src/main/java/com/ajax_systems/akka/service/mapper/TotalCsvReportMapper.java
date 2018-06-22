package com.ajax_systems.akka.service.mapper;

import com.ajax_systems.akka.model.CsvReport;
import com.ajax_systems.akka.service.dto.TotalCsvReportDTO;

import java.util.Collection;


/**
 * Mapper for the entity Collection<CsvReport> and its DTO TotalCsvReportDTO.
 */
public interface TotalCsvReportMapper extends EntityMapper<TotalCsvReportDTO, Collection<CsvReport>> {

    TotalCsvReportDTO toDto(Collection<CsvReport> entities);

    Collection<CsvReport> toEntity(TotalCsvReportDTO totalCsvReportDTO);
}
