package com.kavindu.testing.service;

import com.kavindu.testing.domain.dto.BookDto;

import java.util.List;

public interface BookService {
    BookDto CreateBook(BookDto bookDto);
    BookDto UpdateBook(BookDto bookDto);
    BookDto DeleteBook(BookDto bookDto);
    List<BookDto> getAllBooks();
    BookDto getBookById(Long id);
}
