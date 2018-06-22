package com.ajax_systems.akka.service.dto;

import java.io.Serializable;
import java.util.Collection;


/**
 * A DTO for the Collection<CsvReport> entity.
 */
public class TotalCsvReportDTO implements Serializable {

    private Long totalAmount;

    private Collection<CsvReportDTO> books;

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Collection<CsvReportDTO> getBooks() {
        return books;
    }

    public void setBooks(Collection<CsvReportDTO> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "TotalCsvReportDTO{" +
                "totalAmount=" + totalAmount +
                ", books=" + books +
                '}';
    }
}
