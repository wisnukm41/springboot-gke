package com.wisdev.quickstart.services;

import com.wisdev.quickstart.domain.entities.BookEntity;

public interface BookService {
    BookEntity createBook(String isbn, BookEntity book);
}
