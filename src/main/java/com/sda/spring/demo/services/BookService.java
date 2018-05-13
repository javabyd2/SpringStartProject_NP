package com.sda.spring.demo.services;

import com.sda.spring.demo.model.Book;
import com.sda.spring.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks(){
        /*
         *  dodatkowa logika
         */
        return bookRepository.findAll();
    }

    public Book save(Book book) {
       return bookRepository.save(book);
    }
}
