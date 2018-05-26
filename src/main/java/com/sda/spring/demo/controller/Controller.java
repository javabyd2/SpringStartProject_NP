package com.sda.spring.demo.controller;

import com.sda.spring.demo.dto.UserDTO;
import com.sda.spring.demo.dto.UserDetailsDTO;
import com.sda.spring.demo.model.*;
import com.sda.spring.demo.services.*;
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
    private PublisherService publisherService;

    @Autowired
    public Controller(BookService bookService, AuthorService authorService, CategoryService categoryService,
                      UserService userService, PublisherService publisherService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.userService = userService;
        this.publisherService = publisherService;
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
    @RequestMapping(value = "/publishers", method = GET)
    public List<Publisher> showPublisherList(){
        return publisherService.getPublisher();
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
    @RequestMapping(value = "/publisher", method = POST)
    public Publisher addPublisher(@RequestBody Publisher publisher){
        return publisherService.save(publisher);
    }
    @RequestMapping(value = "book/{id}", method = GET)
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBookById(id));
    }
    @RequestMapping(value = "author/{id}", method = GET)
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(authorService.getAuthorById(id));
    }
    @RequestMapping(value = "category/{id}", method = GET)
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getCategoryById(id));
    }
    @RequestMapping(value = "publisher/{id}", method = GET)
    public ResponseEntity<Publisher> getPublisherById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(publisherService.getPublisherById(id));
    }

    @RequestMapping(value = "/user", method = POST)
    public User addUser(@RequestBody User user){
        return userService.save(user);
    }
    @RequestMapping(value = "/users", method = GET)
    public List<UserDetailsDTO> showUserList(){
        return userService.getUsers();
    }

//    @RequestMapping(value = "user/{id}", method = GET)
//    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
//        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
//    }
    @RequestMapping(value = "user/{id}", method = GET)
    public UserDTO getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }
}
