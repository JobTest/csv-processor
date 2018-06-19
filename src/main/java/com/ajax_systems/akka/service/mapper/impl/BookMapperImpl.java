package com.ajax_systems.akka.service.mapper.impl;


import com.ajax_systems.akka.model.Book;
import com.ajax_systems.akka.service.dto.BookDTO;
import com.ajax_systems.akka.service.mapper.BookMapper;

public class BookMapperImpl implements BookMapper {

    public BookDTO toDto(Book entity) {
        if (entity == null) {
            return null;
        } else {
            BookDTO bookDTO = new BookDTO();
            bookDTO.setTitle(entity.getTitle());
            bookDTO.setAuthor(entity.getAuthor());
            bookDTO.setAbout(entity.getAbout());
            bookDTO.setPrice(entity.getPrice());
            bookDTO.setNumber(entity.getNumber());
            return bookDTO;
        }
    }

    public Book toEntity(BookDTO bookDTO) {
        if (bookDTO == null) {
            return null;
        } else {
            Book book = new Book();
            book.setTitle(bookDTO.getTitle());
            book.setAuthor(bookDTO.getAuthor());
            book.setAbout(bookDTO.getAbout());
            book.setPrice(bookDTO.getPrice());
            book.setNumber(bookDTO.getNumber());
            return book;
        }
    }
}
