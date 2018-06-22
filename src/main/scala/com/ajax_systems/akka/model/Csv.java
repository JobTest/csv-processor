package com.ajax_systems.akka.model;

import java.io.Serializable;
import java.util.Objects;


/**
 * A Csv.
 */
public class Csv implements Serializable {

    private static final long serialVersionUID = 1L;

    private String writer;

    private String value;

    private int row;

    public String getWriter() {
        return writer;
    }

    public Csv writer(String writer) {
        this.writer = writer;
        return this;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getValue() {
        return value;
    }

    public Csv value(String value) {
        this.value = value;
        return this;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getRow() {
        return row;
    }

    public Csv row(int row) {
        this.row = row;
        return this;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Csv csv = (Csv) o;
        return Objects.equals(writer, csv.writer) &&
                Objects.equals(value, csv.value);
    }

    @Override
    public int hashCode() {

        return Objects.hash(writer, value);
    }
}
