package com.sda.spring.demo.controller;

import com.sda.spring.demo.model.Author;
import com.sda.spring.demo.model.Book;
import com.sda.spring.demo.model.Category;
import com.sda.spring.demo.repository.AuthorRepository;
import com.sda.spring.demo.repository.BookRepository;
import com.sda.spring.demo.repository.CategoryRepository;
import com.sda.spring.demo.services.AuthorService;
import com.sda.spring.demo.services.BookService;
import com.sda.spring.demo.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class Controller {

    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/books", method = GET)
    public List<Book> showBooklist(){
        return bookService.getBooks();
    }
    @RequestMapping(value = "/authors", method = GET)
    public List<Author> showAuthorList(){
        return authorService.getAuthors();
    }
    @RequestMapping(value = "/categories", method = GET)
    public List<Category> showCategoryList(){
        return categoryService.getCategory();
    }
    @RequestMapping(value = "/category", method = POST)
    public Category addCategory(@RequestBody Category category){
        return categoryService.save(category);
    }
    @RequestMapping(value = "/author", method = POST)
    public Author addAuthor(@RequestBody Author author){
        return authorService.save(author);
    }
    @RequestMapping(value = "/book", method = POST)
    public Book addBook(@RequestBody Book book){
        return bookService.save(book);
    }
}
