package com.ajax_systems.akka.service.dto;

import java.io.Serializable;


/**
 * A DTO for the Book entity.
 */
public class BookDTO implements Serializable {

    private int id;

    private String title;

    private String author;

    private String about;

    private Double price;

    private Integer number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", about='" + about + '\'' +
                ", price=" + price +
                ", number=" + number +
                '}';
    }
}
