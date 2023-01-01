package com.example.book_store.service.book;

import com.example.book_store.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    Page<Book> findAllBooks(Pageable pageable, String searchName, String searchAuthor);

    Page<Book> findAllBooksHomePage(Pageable pageable);

    List<Book> findAllBooks();

    void deleteById(Integer id);

    void saveBook(Book book);

    void updateBook(Book book);

    Optional<Book> findBookById(Integer id);
}
