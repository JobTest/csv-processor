package com.ajax_systems.akka.model;

import java.io.Serializable;
import java.util.Objects;


/**
 * A CsvReport.
 */
public class CsvReport implements Serializable, Comparable<CsvReport> {

    private static final long serialVersionUID = 1L;

    private int id;

    private String writer;

    private Long amount;

    private String jsonUrl;

    private String csvUrl;

    public int getId() {
        return id;
    }

    public CsvReport id(int id) {
        this.id = id;
        return this;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWriter() {
        return writer;
    }

    public CsvReport writer(String writer) {
        this.writer = writer;
        return this;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Long getAmount() {
        return amount;
    }

    public CsvReport amount(Long amount) {
        this.amount = amount;
        return this;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getJsonUrl() {
        return jsonUrl;
    }

    public CsvReport jsonUrl(String jsonUrl) {
        this.jsonUrl = jsonUrl;
        return this;
    }

    public void setJsonUrl(String jsonUrl) {
        this.jsonUrl = jsonUrl;
    }

    public String getCsvUrl() {
        return csvUrl;
    }

    public CsvReport csvUrl(String csvUrl) {
        this.csvUrl = csvUrl;
        return this;
    }

    public void setCsvUrl(String csvUrl) {
        this.csvUrl = csvUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CsvReport report = (CsvReport) o;
        return Objects.equals(writer, report.writer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(writer);
    }

    @Override
    public int compareTo(CsvReport cr) {
        if (cr.getId() < this.getId())
            return 1;
        if (cr.getId() > this.getId())
            return -1;
        return 0;
    }
}
