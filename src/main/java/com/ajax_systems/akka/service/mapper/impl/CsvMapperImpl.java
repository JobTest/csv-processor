package com.ajax_systems.akka.service.mapper.impl;

import com.ajax_systems.akka.model.Csv;
import com.ajax_systems.akka.service.dto.CsvDTO;
import com.ajax_systems.akka.service.mapper.CsvMapper;
import com.ajax_systems.akka.web.util.CsvUtil;


public class CsvMapperImpl implements CsvMapper {

    public CsvDTO toDto(Csv entity) {
        if (entity == null) {
            return null;
        } else {
            CsvDTO csvDTO = new CsvDTO();
            csvDTO.setWriter(entity.getWriter());
            csvDTO.setValue(entity.getValue());
            csvDTO.setRow(entity.getRow());
            return csvDTO;
        }
    }

    public Csv toEntity(CsvDTO csvDTO) {
        if (csvDTO == null) {
            return null;
        } else {
            Csv csv = new Csv();
            csv.setWriter(csvDTO.getWriter());
            csv.setValue(csvDTO.getValue());
            csv.setRow(csvDTO.getRow());
            return csv;
        }
    }

    public Csv fromData(String data) {
        if (data == null) {
            return null;
        } else {
            String writer = CsvUtil.matchWriter(data);
            int row = data.length();
            Csv csv = new Csv();
            csv.setWriter(writer);
            csv.setValue(data);
            csv.setRow(row);
            return csv;
        }
    }
}
