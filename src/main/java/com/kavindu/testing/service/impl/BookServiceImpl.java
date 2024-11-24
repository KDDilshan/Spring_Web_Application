package com.kavindu.testing.service.impl;

import com.kavindu.testing.domain.dto.BookDto;
import com.kavindu.testing.domain.entities.BookEntity;
import com.kavindu.testing.mappers.Mapper;
import com.kavindu.testing.respositories.AuthorRepository;
import com.kavindu.testing.respositories.BookRepository;
import com.kavindu.testing.service.BookService;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private Mapper<BookEntity, BookDto>  bookMapper;
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public BookServiceImpl(Mapper<BookEntity, BookDto> bookMapper, BookRepository bookRepository,AuthorRepository authorRepository) {
        this.bookMapper = bookMapper;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public BookDto CreateBook(BookDto bookDto) {
        if(bookDto==null){
             throw new IllegalArgumentException("BookDto is null");
        }
        Long AuthorId = bookDto.getAuthorId();
        if(!authorRepository.existsById(AuthorId)){
            throw new IllegalArgumentException("Author does not exist");
        }
        BookEntity bookEntity=bookMapper.mapFrom(bookDto);
        BookEntity bookEntity1=bookRepository.save(bookEntity);
        return bookMapper.mapTo(bookEntity1);
    }

    @Override
    public BookDto UpdateBook(BookDto bookDto) {
            BookEntity existingBook=bookRepository.findById(bookDto.getId())
                    .orElseThrow(() -> new IllegalArgumentException("Book does not exist"));

            existingBook.setTitle(bookDto.getTitle());
            existingBook.setAuthorId(bookDto.getAuthorId());
            BookEntity bookEntity=bookRepository.save(existingBook);
            return bookMapper.mapTo(bookEntity);
        }

    @Override
    public BookDto DeleteBook(BookDto bookDto) {
        BookEntity bookEntity=bookRepository.findById(bookDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Book does not exist"));
        bookRepository.delete(bookEntity);
        return bookMapper.mapTo(bookEntity);
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<BookEntity> bookEntities =bookRepository.findAll();
        return bookEntities.stream()
                .map(bookMapper::mapTo)
                .collect(Collectors.toList());
    }

    @Override
    public BookDto getBookById(Long id) {
        return bookRepository.findById(id)
                .map(bookMapper::mapTo)
                .orElseThrow(()-> new IllegalArgumentException("Book not found"));
    }
}
