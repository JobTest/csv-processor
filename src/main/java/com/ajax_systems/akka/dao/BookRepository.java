package com.ajax_systems.akka.dao;

import com.ajax_systems.akka.model.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListMap;


public class BookRepository {

    private final ConcurrentSkipListMap<Integer, Book> books = new ConcurrentSkipListMap<>();

    private final IdSequence seqId = new IdSequence();

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
            id = seqId.get(book);
            newBook.id(id)
                    .title(book.getTitle())
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
