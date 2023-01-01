package com.example.book_store.controller;

import com.example.book_store.model.Book;
import com.example.book_store.service.book.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/home")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping("/list")
    public ResponseEntity<Page<Book>> getAllBooks(@PageableDefault(size = 5) Pageable pageable,
                                                  @RequestParam(value = "name", defaultValue = "") String nameSearch,
                                                  @RequestParam(value = "author", defaultValue = "") String authorSearch) {
        Page<Book> bookPage = bookService.findAllBooks(pageable, nameSearch, authorSearch);
        if (bookPage.hasContent()) {
            return new ResponseEntity<>(bookPage, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Integer id) {
        Optional<Book> book = bookService.findBookById(id);
        if (book.isPresent()) {
            return new ResponseEntity<>(book.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
