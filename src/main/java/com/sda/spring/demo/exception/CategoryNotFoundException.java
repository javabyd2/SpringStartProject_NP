package com.sda.spring.demo.exception;

import com.sda.spring.demo.repository.CategoryRepository;

public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException(Long id){
        super("Brak w bazie kategorii: " + id);
    }
}
