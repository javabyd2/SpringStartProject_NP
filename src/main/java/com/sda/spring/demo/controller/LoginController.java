package com.sda.spring.demo.controller;

import com.sda.spring.demo.model.User;
import com.sda.spring.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping(value = "/login")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
    @GetMapping(value = "/register")
    public ModelAndView register(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("register");
        return modelAndView;
    }
    @PostMapping(value = "register")
    public ModelAndView storeUser(User user, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findByAddress(user.getAddress());
        if(userExists != null){
            bindingResult.rejectValue("address", "error.user", "Email jest już zajęty");
        }
        if(bindingResult.hasErrors()){
            modelAndView.setViewName("register");
        }else{
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "Witaj w klubie :)");
        }
        modelAndView.setViewName("register");
        return modelAndView;
    }
}
