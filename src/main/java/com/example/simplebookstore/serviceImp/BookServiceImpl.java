package com.example.simplebookstore.serviceImp;

import com.example.simplebookstore.dto.*;
import com.example.simplebookstore.model.Book;
import com.example.simplebookstore.repository.BookRepository;
import com.example.simplebookstore.service.BookService;
import com.example.simplebookstore.util.Validator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService {


    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public ResponseEntity<?> AddBook(BookRequest bookRequest) {
        if(!Validator.isValid(bookRequest)) {
            return CustomResponseHandler.responseBuilder("Failed to Save ", HttpStatus.BAD_REQUEST.value(), new BookResponse("Null or Empty field detected"));

        }
        else {
            Book book = new Book();
            book.setAuthor(bookRequest.getAuthor());
            book.setName(bookRequest.getName());
            book.setPrice(bookRequest.getPrice());
            book.setCategory(bookRequest.getCategory());
            book.setLanguage(bookRequest.getLanguage());
            book.setDelFlag(false);

            bookRepository.save(book);
            return CustomResponseHandler.responseBuilder("Book Saved Successfully", HttpStatus.CREATED.value(), book);
        }
    }



    @Override
    public ResponseEntity<?> viewAllBook() {
        List<AllBookResponse> bookResponse = new ArrayList<>();
        List<Book> bookList = bookRepository.findAllBook();

        for(Book book : bookList){
            AllBookResponse allBookResponse = new AllBookResponse();
            allBookResponse.setAuthor(book.getAuthor());
            allBookResponse.setName(book.getName());
            allBookResponse.setPrice(book.getPrice());
            allBookResponse.setLanguage(book.getLanguage());
            allBookResponse.setCategory(book.getCategory());

            bookResponse.add(allBookResponse);
        }

        return CustomResponseHandler.responseBuilder("Success", HttpStatus.OK.value(), bookResponse);
    }


    @Override
    public ResponseEntity<?> updateBook(UpdateRequest updateRequest) {
        Optional<Book> findBook = Optional.empty();
        if(updateRequest.getAuthor() == null && updateRequest.getCategory() == null && updateRequest.getName() ==null
                && updateRequest.getPrice() == null && updateRequest.getLanguage() == null) {

            BookResponse response = new BookResponse("At least one update request element must not be null");

            return CustomResponseHandler.responseBuilder("Null Update Request", HttpStatus.BAD_REQUEST.value(), response);
        }
        try{
            if(updateRequest.getId() != null && updateRequest.getId().intValue() != 0){
                findBook = bookRepository.findById(updateRequest.getId());
            }
        }
        catch (Exception e){
            BookResponse bookResponse = new BookResponse("Book Id does not exist");
            return CustomResponseHandler.responseBuilder("Record does not exist",HttpStatus.BAD_REQUEST.value(), bookResponse);
        }
        if(findBook.isPresent()) {
            if (updateRequest.getName() != null) {
                findBook.get().setName(updateRequest.getName());
            }
            if (updateRequest.getPrice() != null) {
                findBook.get().setPrice(updateRequest.getPrice());
            }
            if (updateRequest.getCategory() != null) {
                findBook.get().setCategory(updateRequest.getCategory());
            }
            if (updateRequest.getLanguage() != null) {
                findBook.get().setLanguage(updateRequest.getLanguage());
            }
            if (updateRequest.getAuthor() != null) {
                findBook.get().setAuthor(updateRequest.getAuthor());
            }
            try {
                bookRepository.save(findBook.get());
            }
            catch (Exception e){
                //log.info("Couldn't Save Update for Id "+ updateRequest.getId() +" because: "+ e.getCause());
                return CustomResponseHandler.responseBuilder("Failed to Update", HttpStatus.BAD_REQUEST.value(), new BookResponse("Failed to Update Book"));
            }
        }
        UpdateResponse updateResponse = getUpdateResponse(updateRequest);
        return CustomResponseHandler.responseBuilder("Successfully updated",HttpStatus.OK.value(), updateResponse);
    }

    @Override
    public ResponseEntity<?> deleteBook(DeleteRequest deleteRequest) {
        Optional<Book> optionalBook = bookRepository.findById(deleteRequest.getId());
        if(optionalBook.isPresent()){
            optionalBook.get().setDelFlag(true);
            bookRepository.save(optionalBook.get());
            return CustomResponseHandler.responseBuilder("Book with Id "+deleteRequest.getId()+" has been logically deleted",HttpStatus.OK.value(), new BookResponse("Successfully Deleted"));
        }
        else {
            return CustomResponseHandler.responseBuilder("Book does not exist",HttpStatus.NO_CONTENT.value(), new BookResponse("Record does not exist"));
        }
    }

    private static UpdateResponse getUpdateResponse(UpdateRequest updateRequest) {
        UpdateResponse updateResponse = new UpdateResponse();
        if (updateRequest.getName() != null) {
            updateResponse.setName(updateRequest.getName());
        }
        if (updateRequest.getPrice() != null) {
            updateResponse.setPrice(updateRequest.getPrice());
        }
        if (updateRequest.getCategory() != null) {
            updateResponse.setCategory(updateRequest.getCategory());
        }
        if (updateRequest.getLanguage() != null) {
            updateResponse.setLanguage(updateRequest.getLanguage());
        }
        if (updateRequest.getAuthor() != null) {
            updateResponse.setAuthor(updateRequest.getAuthor());
        }
        return updateResponse;
    }
}
