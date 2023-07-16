package com.project.library.service;

import com.project.library.model.BookStatusUpdateModel;

public interface BookStatusService {
    void insertNew(String bookId);
    void delete(String id);
    void updateStatus(BookStatusUpdateModel bookStatusUpdateModel);
}
