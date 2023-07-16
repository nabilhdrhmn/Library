package com.project.library.repository;

import com.project.library.entity.BookStatus;

public interface BookStatusDao {
    BookStatus save(BookStatus bookStatus);
    void delete(String id);
    BookStatus fetchById(String id);
}
