package com.project.library.service.impl;

import com.project.library.entity.Book;
import com.project.library.entity.BookStatus;
import com.project.library.model.BookStatusUpdateModel;
import com.project.library.repository.BookStatusDao;
import com.project.library.service.BookStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookStatusServiceImpl implements BookStatusService {
    private final BookStatusDao bookStatusDao;
    @Override
    public void insertNew(String bookId) {
        BookStatus bookStatus = BookStatus.builder()
                .idBuku(bookId)
                .status("0")
                .build();
        this.bookStatusDao.save(bookStatus);
    }

    @Override
    public void delete(String id) {
        this.bookStatusDao.delete(id);
    }

    @Override
    public void updateStatus(BookStatusUpdateModel bookStatusUpdateModel) {
        BookStatus bookStatus = this.bookStatusDao.fetchById(bookStatusUpdateModel.getId());
        bookStatus.setStatus("1");
        bookStatus.setPeminjam(bookStatusUpdateModel.getPeminjam());
        bookStatus.setTanggalPinjam(bookStatusUpdateModel.getTanggalPinjam());
        bookStatus.setTanggalKembali(bookStatusUpdateModel.getTanggalKembali());
        this.bookStatusDao.save(bookStatus);
    }
}
