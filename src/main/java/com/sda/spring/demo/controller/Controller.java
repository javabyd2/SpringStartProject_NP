package com.sda.spring.demo.controller;

import com.sda.spring.demo.model.Author;
import com.sda.spring.demo.model.Book;
import com.sda.spring.demo.model.Category;
import com.sda.spring.demo.model.Person;
import com.sda.spring.demo.repository.AuthorRepository;
import com.sda.spring.demo.repository.BookRepository;
import com.sda.spring.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class Controller {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(value = "/books", method = GET)
    public List<Book> showBooklist(){
        return bookRepository.findAll();
    }
    @RequestMapping(value = "/authors", method = GET)
    public List<Author> showAuthorList(){
        return authorRepository.findAll();
    }
    @RequestMapping(value = "/categories", method = GET)
    public List<Category> showCategoryList(){
        return categoryRepository.findAll();
    }
}
