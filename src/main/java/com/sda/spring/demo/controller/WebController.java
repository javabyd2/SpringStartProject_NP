package com.sda.spring.demo.controller;

import com.sda.spring.demo.model.Role;
import com.sda.spring.demo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;

/**
 * Controller for HTML
 */
@Controller
public class WebController {

    private final AuthorService authorService;
    private final BookService bookService;
    private final RoleService roleService;
    private final UserService userService;
    private final CategoryService categoryService;

    @Autowired
    public WebController(AuthorService authorService, BookService bookService, RoleService roleService,
                         UserService userService, CategoryService categoryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.roleService = roleService;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @GetMapping(value = "index")
    public ModelAndView index(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }
    @GetMapping(value = "/web/authors")
    public ModelAndView authors(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("authorsList", authorService.getAuthors());
        modelAndView.setViewName("authors");
        return modelAndView;
    }
    @GetMapping(value = "/web/books")
    public ModelAndView books(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("booksList", bookService.getBooks());
        modelAndView.setViewName("books");
        return modelAndView;
    }
    @GetMapping(value = "/web/roles")
    public ModelAndView roles(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("rolesList", roleService.getCategory());
        modelAndView.setViewName("roles");
        return modelAndView;
    }
    @GetMapping(value = "/web/categories")
    public ModelAndView categories(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("categoriesList", categoryService.getCategory());
        modelAndView.setViewName("categories");
        return modelAndView;
    }
    @GetMapping(value = "/web/users")
    public ModelAndView users(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("usersList", userService.getUsers());
        modelAndView.setViewName("users");
        return modelAndView;
    }
    @PostMapping(value = "/web/addrole")
    public String addRole(@ModelAttribute("role")Role role, RedirectAttributes redirectAttributes){
        roleService.save(role);
        redirectAttributes.addFlashAttribute("message", "Dodano pomyślnie");
        return "redirect:/web/roleform";
    }
    @GetMapping(value = "/web/roleform")
    public ModelAndView roleForm(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("roleform");
        modelAndView.addObject("role", new Role());
        return modelAndView;
    }
}
