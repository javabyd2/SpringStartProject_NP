package com.sda.spring.demo.exception;

public class PublisherNotFoundExcepton extends RuntimeException {
    public PublisherNotFoundExcepton(Long id) {
        super("Brak w bazie wydawcy: " + id);
    }
}
