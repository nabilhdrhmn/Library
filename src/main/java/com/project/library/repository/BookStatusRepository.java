package com.project.library.repository;

import com.project.library.entity.BookStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookStatusRepository extends JpaRepository<BookStatus, String> {
    void deleteBookStatusByIdBuku(String id);
    BookStatus findByIdBuku(String id);
}
