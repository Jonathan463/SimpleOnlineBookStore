package com.example.simplebookstore.util;

import com.example.simplebookstore.dto.BookRequest;

public class Validator {
    public static boolean isValid(BookRequest bookRequest) {
        return bookRequest.getName() != null && !bookRequest.getName().trim().isEmpty()
                && bookRequest.getPrice() != null
                && bookRequest.getCategory() != null
                && bookRequest.getLanguage() != null
                && bookRequest.getAuthor() != null && !bookRequest.getAuthor().trim().isEmpty();
    }
}
