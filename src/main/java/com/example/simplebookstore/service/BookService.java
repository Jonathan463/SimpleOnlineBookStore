package com.example.simplebookstore.service;

import com.example.simplebookstore.dto.BookRequest;
import com.example.simplebookstore.dto.DeleteRequest;
import com.example.simplebookstore.dto.UpdateRequest;
import org.springframework.http.ResponseEntity;

public interface BookService {
    ResponseEntity<?> AddBook(BookRequest bookRequest);
    ResponseEntity<?> viewAllBook();
    ResponseEntity<?> updateBook(UpdateRequest updateRequest);
    ResponseEntity<?> deleteBook(DeleteRequest deleteRequest);
}
