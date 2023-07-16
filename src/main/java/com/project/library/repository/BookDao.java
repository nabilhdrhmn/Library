package com.project.library.repository;

import com.project.library.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookDao {
    void save(Book book);
    List<Book> fetchAllBookData(String status);
    void deleteBookById(String id);
    Book fetchLatest();

    Optional<Book> fetchById(String id);
}
