package com.ajax_systems.akka.service.dto;

import java.io.Serializable;


/**
 * A DTO for the Csv entity.
 */
public class CsvDTO implements Serializable {

    private String writer;

    private String value;

    private int row;

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public String toString() {
        return "CsvDTO{" +
                "writer='" + writer + '\'' +
                ", value='" + value + '\'' +
                ", row=" + row +
                '}';
    }
}
