package com.kavindu.testing.contollers;

import com.kavindu.testing.domain.dto.BookDto;
import com.kavindu.testing.domain.entities.BookEntity;
import com.kavindu.testing.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")

public class BookContoller {

    @Autowired
    private final BookService bookService;

    public BookContoller(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/create")
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookdto) {
        return new ResponseEntity<>(bookService.CreateBook(bookdto), HttpStatus.CREATED);
    }

    @GetMapping("/getBooks")
    public ResponseEntity<List<BookDto>> getBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }
}
