package com.ajax_systems.akka.service.mapper;


import com.ajax_systems.akka.model.Book;
import com.ajax_systems.akka.service.dto.BookDTO;

/**
 * Mapper for the entity Book and its DTO BookDTO.
 */
public interface BookMapper extends EntityMapper<BookDTO, Book> {

    BookDTO toDto(Book entity);

    Book toEntity(BookDTO bookDTO);
}
