package com.ajax_systems.akka.service.mapper;


import com.ajax_systems.akka.model.Csv;
import com.ajax_systems.akka.service.dto.CsvDTO;

/**
 * Mapper for the entity Csv and its DTO CsvDTO.
 */
public interface CsvMapper extends EntityMapper<CsvDTO, Csv> {

    CsvDTO toDto(Csv entity);

    Csv toEntity(CsvDTO csvDTO);

    Csv fromData(String source);
}
