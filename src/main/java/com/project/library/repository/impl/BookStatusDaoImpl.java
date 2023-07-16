package com.project.library.repository.impl;

import com.project.library.entity.BookStatus;
import com.project.library.repository.BookStatusDao;
import com.project.library.repository.BookStatusRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BookStatusDaoImpl implements BookStatusDao {
    private final BookStatusRepository bookStatusRepository;

    @Override
    public BookStatus save(BookStatus bookStatus) {
        return this.bookStatusRepository.save(bookStatus);
    }

    @Override
    @Transactional
    public void delete(String id) {
        this.bookStatusRepository.deleteBookStatusByIdBuku(id);
    }

    @Override
    public BookStatus fetchById(String id) {
        return this.bookStatusRepository.findByIdBuku(id);
    }
}
