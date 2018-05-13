package com.sda.spring.demo.controller;

import com.sda.spring.demo.model.Author;
import com.sda.spring.demo.model.Book;
import com.sda.spring.demo.model.Category;
import com.sda.spring.demo.model.User;
import com.sda.spring.demo.services.AuthorService;
import com.sda.spring.demo.services.BookService;
import com.sda.spring.demo.services.CategoryService;
import com.sda.spring.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class Controller {


    private BookService bookService;
    private AuthorService authorService;
    private CategoryService categoryService;
    private UserService userService;

    @Autowired
    public Controller(BookService bookService, AuthorService authorService, CategoryService categoryService, UserService userService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    //krotsza atnotacja
    @GetMapping("/books")
    public List<Book> showBooklist(){
        return bookService.getBooks();
    }
    @GetMapping("/authors")
    public List<Author> showAuthorList(){
        return authorService.getAuthors();
    }
    //dluzsza adnotacja
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
    @RequestMapping(value = "book/{id}", method = GET)
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBookById(id));
    }
    @RequestMapping(value = "author/{id}", method = GET)
    public Optional<Author> getAuthorById(@PathVariable Long id){
        return authorService.getAuthorById(id);
    }
    @RequestMapping(value = "category/{id}", method = GET)
    public Optional<Category> getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }
    @RequestMapping(value = "/user", method = POST)
    public User addUser(@RequestBody User user){
        return userService.save(user);
    }
    @RequestMapping(value = "/users", method = GET)
    public List<User> showUserList(){
        return userService.getUsers();
    }
}
