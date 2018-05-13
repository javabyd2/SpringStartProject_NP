package com.sda.spring.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;

@ControllerAdvice
public class ExceptionHandlerAdvice {


    @ExceptionHandler(BookNotFoundException.class) //moze byc 404 zamiast NOT_Found
    public ResponseEntity handleException(BookNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError(HttpStatus.NOT_FOUND,
                "Nie znaleziono rekordu", Arrays.asList("test", "test2")));
    }
    @ExceptionHandler(AuthorNotFoundException.class)
    public ResponseEntity handleAuthorException(){
        return ResponseEntity.status(404).body(new ApiError(HttpStatus.NOT_FOUND,
                "Nie znaleziono", Arrays.asList("bla", "bla")));
    }
    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity handleCategoryException(){
        return ResponseEntity.status(404).body(new ApiError(HttpStatus.NOT_FOUND,
                "Nie znaleziono", Arrays.asList("bla", "bla")));
    }
}
