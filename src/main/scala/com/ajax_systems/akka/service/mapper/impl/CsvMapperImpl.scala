package com.ajax_systems.akka.service.mapper.impl

import com.ajax_systems.akka.model.Csv
import com.ajax_systems.akka.service.dto.CsvDTO
import com.ajax_systems.akka.service.mapper.CsvMapper
import com.ajax_systems.akka.web.util.CsvUtil


class CsvMapperImpl extends CsvMapper {

    def toDto(entity: Csv) : CsvDTO = {
        if (entity == null) {
            return null
        } else {
          val csvDTO = new CsvDTO
            csvDTO.writer = entity.getWriter
            csvDTO.value = entity.getValue
            csvDTO.row = entity.getRow
            return csvDTO
        }
    }

    def toEntity(csvDTO: CsvDTO) : Csv = {
        if (csvDTO == null) {
            return null
        } else {
            val csv = new Csv
            csv.setWriter(csvDTO.writer)
            csv.setValue(csvDTO.value)
            csv.setRow(csvDTO.row)
            return csv
        }
    }

    def fromData(data: String) : Csv = {
        if (data == null) {
            return null
        } else {
            val writer = CsvUtil.matchWriter(data)
            val row = data.length()
            val csv = new Csv
            csv.setWriter(writer)
            csv.setValue(data)
            csv.setRow(row)
            return csv
        }
    }
}
