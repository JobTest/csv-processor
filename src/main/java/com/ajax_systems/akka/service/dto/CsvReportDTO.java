package com.ajax_systems.akka.service.dto;

import java.io.Serializable;


/**
 * A DTO for the CsvReport entity.
 */
public class CsvReportDTO implements Serializable {

    private int id;

    private String writer;

    private Long amount;

    private Double percentage;

    private String jsonUrl;

    private String csvUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public String getJsonUrl() {
        return jsonUrl;
    }

    public void setJsonUrl(String jsonUrl) {
        this.jsonUrl = jsonUrl;
    }

    public String getCsvUrl() {
        return csvUrl;
    }

    public void setCsvUrl(String csvUrl) {
        this.csvUrl = csvUrl;
    }

    @Override
    public String toString() {
        return "CsvReportDTO{" +
                "id=" + id +
                ", writer='" + writer + '\'' +
                ", amount=" + amount +
                ", percentage=" + percentage +
                ", jsonUrl='" + jsonUrl + '\'' +
                ", csvUrl='" + csvUrl + '\'' +
                '}';
    }
}
