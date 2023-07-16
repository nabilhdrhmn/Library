package com.project.library.controller;

import com.project.library.entity.Book;
import com.project.library.model.BookRequestInsertModel;
import com.project.library.model.BookRequestUpdateModel;
import com.project.library.model.BookStatusUpdateModel;
import com.project.library.service.BookService;
import com.project.library.service.BookStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private final BookStatusService bookStatusService;

    @PostMapping(value = "/insert")
    public ResponseEntity<String> insertNew(@RequestBody BookRequestInsertModel bookRequestInsertModel) {
        this.bookService.insertNew(bookRequestInsertModel);
        return ResponseEntity.status(HttpStatus.OK).body("Data posted successfully");
    }

    @PutMapping(value = "/update")
    public ResponseEntity<String> update(@RequestBody BookRequestUpdateModel bookRequestUpdateModel) {
        this.bookService.updateData(bookRequestUpdateModel);
        return ResponseEntity.status(HttpStatus.OK).body("Data for id: " + bookRequestUpdateModel.getId() + " has been updated");
    }

    @PutMapping(value = "/status/update")
    public ResponseEntity<String> updateStatus(@RequestBody BookStatusUpdateModel bookStatusUpdateModel) {
        this.bookStatusService.updateStatus(bookStatusUpdateModel);
        return ResponseEntity.status(HttpStatus.OK).body("Data for id: " + bookStatusUpdateModel.getId() + " is borrowed by " + bookStatusUpdateModel.getPeminjam());
    }

    @GetMapping()
    public ResponseEntity<List<Book>> fetchAll(@RequestParam(name = "status", required = false) String status) {
        List<Book> books = this.bookService.fetchByStatus(status);
        return ResponseEntity.status(HttpStatus.OK).body(books);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id) {
        this.bookService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Book with id: " + id + " successfully delete");
    }
}
