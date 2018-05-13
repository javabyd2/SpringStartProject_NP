package com.sda.spring.demo.exception;

public class AuthorNotFoundException extends RuntimeException {

    public AuthorNotFoundException(Long id) {
        super("Brak w bazie autora: " + id);
    }
}
