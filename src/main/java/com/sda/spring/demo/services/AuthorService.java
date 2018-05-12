package com.sda.spring.demo.services;

import com.sda.spring.demo.model.Author;
import com.sda.spring.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAuthors(){
        return authorRepository.findAll();
    }
}
