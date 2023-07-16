package com.project.library.service.impl;

import com.project.library.entity.Book;
import com.project.library.model.BookRequestInsertModel;
import com.project.library.model.BookRequestUpdateModel;
import com.project.library.repository.BookDao;
import com.project.library.service.BookService;
import com.project.library.service.BookStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookDao bookDao;
    private final BookStatusService bookStatusService;

    @Override
    public void insertNew(BookRequestInsertModel bookRequestInsertModel) {
        Book latestBook = this.bookDao.fetchLatest();
        String id = this.generateId(latestBook);
        Book newBook = Book.builder()
                .id(id)
                .judul(bookRequestInsertModel.getJudul())
                .penerbit(bookRequestInsertModel.getPenerbit())
                .pengarang(bookRequestInsertModel.getPengarang())
                .tanggalTerbit(bookRequestInsertModel.getTanggalTerbit())
                .tebalBuku(bookRequestInsertModel.getTebalBuku())
                .build();
        this.bookDao.save(newBook);
        this.bookStatusService.insertNew(id);
    }

    private String generateId(Book latestBook) {
        if (latestBook != null) {
            String lastId = latestBook.getId().substring(1);
            int numericPart = Integer.parseInt(lastId) + 1;
            String newNumericPart = String.format("%04d", numericPart);
            return "A" + newNumericPart;
        } else {
            return "A0001";
        }
    }

    @Override
    public List<Book> fetchByStatus(String status) {
        return this.bookDao.fetchAllBookData(status);
    }

    @Override
    public void deleteById(String id) {
        this.bookDao.deleteBookById(id);
        this.bookStatusService.delete(id);
    }

    @Override
    public void updateData(BookRequestUpdateModel bookRequestUpdateModel) {
        Optional<Book> book = this.bookDao.fetchById(bookRequestUpdateModel.getId());
        if (book.isPresent()) {
            Book fetchedBook = book.get();
            fetchedBook.setJudul(bookRequestUpdateModel.getJudul());
            fetchedBook.setPenerbit(bookRequestUpdateModel.getPenerbit());
            fetchedBook.setPengarang(bookRequestUpdateModel.getPengarang());
            fetchedBook.setTanggalTerbit(bookRequestUpdateModel.getTanggalTerbit());
            fetchedBook.setTebalBuku(bookRequestUpdateModel.getTebalBuku());
            this.bookDao.save(fetchedBook);
        }
    }
}
