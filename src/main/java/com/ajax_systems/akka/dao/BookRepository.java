package com.ajax_systems.akka.dao;

import com.ajax_systems.akka.model.Book;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


public class BookRepository {

    private final ConcurrentHashMap<Integer, Book> books = new ConcurrentHashMap<>();

    public List<Book> find() {
        return new ArrayList<>(books.values());
    }

    public Book findOne(Integer id) {
        return books.get(id);
    }

    public Book save(Book book) {
        Integer id = 0;
        Book newBook = new Book();

        if (book!=null) {
            id = book.hashCode();
            newBook.title(book.getTitle())
                    .author(book.getAuthor())
                    .about(book.getAbout())
                    .price(book.getPrice())
                    .number(book.getNumber());
        }
        books.put(id, newBook);
        return newBook;
    }

    public void update(Integer id, Book book) {
        books.put(id, book);
    }

    public void delete(Integer id) {
        books.remove(id);
    }
}
