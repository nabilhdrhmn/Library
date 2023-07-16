package com.project.library.repository.impl;

import com.project.library.entity.Book;
import com.project.library.repository.BookDao;
import com.project.library.repository.BookRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BookDaoImpl implements BookDao {
    private final BookRepository bookRepository;
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public void save(Book book) {
        this.bookRepository.save(book);
    }

    @Override
    public List<Book> fetchAllBookData(String status) {
        if (status != null) {
            TypedQuery<Book> query = entityManager.createQuery("select b from Book b inner join BookStatus bs on b.id = bs.idBuku where bs.status = :status", Book.class);
            query.setParameter("status", status);
            return query.getResultList();
        }
        return this.bookRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteBookById(String id) {
        this.bookRepository.deleteBookById(id);
    }

    @Override
    public Book fetchLatest() {
        return this.bookRepository.findTopByOrderByIdDesc();
    }

    @Override
    public Optional<Book> fetchById(String id) {
        return this.bookRepository.findById(id);
    }
}
