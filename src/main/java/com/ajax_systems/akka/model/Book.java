package com.ajax_systems.akka.model;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;


/**
 * A Book.
 */
public class Book implements Serializable, Comparable<Book>  {

    private static final long serialVersionUID = 1L;

    private int id;

    private String title;

    private String author;

    private String about;

    private Double price;

    private Integer number;

    public int getId() {
        return id;
    }

    public Book id(int id) {
        this.id = id;
        return this;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public Book title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public Book author(String author) {
        this.author = author;
        return this;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAbout() {
        return about;
    }

    public Book about(String about) {
        this.about = about;
        return this;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Double getPrice() {
        return price;
    }

    public Book price(Double price) {
        this.price = price;
        return this;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public Book number(Integer number) {
        this.number = number;
        return this;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                Objects.equals(about, book.about);
    }

    @Override
    public int hashCode() {

        return Math.abs(Objects.hash(title, author, about));
    }

    @Override
    public int compareTo(Book b) {
        if (b.getId() < this.getId())
            return 1;
        if (b.getId() > this.getId())
            return -1;
        return 0;
    }

    public static Comparator<Book> sortByNumber = new Comparator<Book>() {
        @Override
        public int compare(Book b1, Book b2) {
            if (b2.getNumber() < b1.getNumber())
                return 1;
            if (b2.getNumber() > b1.getNumber())
                return -1;
            return 0;
        }
    };

    public static Comparator<Book> sortByPrice = new Comparator<Book>() {
        @Override
        public int compare(Book b1, Book b2) {
            if (b2.getPrice() < b1.getPrice())
                return 1;
            if (b2.getPrice() > b1.getPrice())
                return -1;
            return 0;
        }
    };
}
