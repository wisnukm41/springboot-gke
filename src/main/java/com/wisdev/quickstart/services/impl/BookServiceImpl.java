package com.wisdev.quickstart.services.impl;

import com.wisdev.quickstart.domain.entities.BookEntity;
import com.wisdev.quickstart.repositories.BookRepository;
import com.wisdev.quickstart.services.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    @Override
    public BookEntity createBook(String isbn, BookEntity book) {
        book.setIsbn(isbn);
        return bookRepository.save(book);
    }

    public BookServiceImpl(BookRepository bookRepository ) {
        this.bookRepository = bookRepository;
    }
}
