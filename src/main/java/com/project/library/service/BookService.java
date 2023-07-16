package com.project.library.service;

import com.project.library.entity.Book;
import com.project.library.model.BookRequestInsertModel;
import com.project.library.model.BookRequestUpdateModel;

import java.util.List;

public interface BookService {
    void insertNew(BookRequestInsertModel bookRequestInsertModel);
    List<Book> fetchByStatus(String status);
    void deleteById(String id);
    void updateData(BookRequestUpdateModel bookRequestUpdateModel);
}
