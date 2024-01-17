package com.example.simplebookstore.controller;

import com.example.simplebookstore.dto.BookRequest;
import com.example.simplebookstore.dto.DeleteRequest;
import com.example.simplebookstore.dto.UpdateRequest;
import com.example.simplebookstore.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("v1")
public class BookController {
    private final BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;

    }

    @PostMapping("/addBook")
    public ResponseEntity<?> addBook(@Valid @RequestBody BookRequest bookRequest){
        return bookService.AddBook(bookRequest);
    }

    @GetMapping("/getAllBook")
    public ResponseEntity<?> getAllBook(){
        return bookService.viewAllBook();
    }

    @PostMapping("/updateBook")
    public ResponseEntity<?> updateBook(@RequestBody UpdateRequest updateRequest){
        return bookService.updateBook(updateRequest);
    }
    @PostMapping("/deleteBook")
    public ResponseEntity<?> deleteBook(@RequestBody DeleteRequest deleteRequest){
        return bookService.deleteBook(deleteRequest);
    }
}
