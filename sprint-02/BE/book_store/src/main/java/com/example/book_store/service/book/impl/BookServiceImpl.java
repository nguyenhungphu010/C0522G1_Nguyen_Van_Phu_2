package com.example.book_store.service.book.impl;

import com.example.book_store.model.Book;
import com.example.book_store.repository.book.IBookRepository;
import com.example.book_store.service.book.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    private IBookRepository bookRepository;
    @Override
    public Page<Book> findAllBooks(Pageable pageable, String searchName, String searchAuthor) {
        return bookRepository.findBooksByAll(pageable, searchName, searchAuthor);
    }

    @Override
    public Page<Book> findAllBooksHomePage(Pageable pageable) {
        return null;
    }

    @Override
    public List<Book> findAllBooks() {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void saveBook(Book book) {

    }

    @Override
    public void updateBook(Book book) {

    }

    @Override
    public Optional<Book> findBookById(Integer id) {
        return bookRepository.findById(id);
    }
}
