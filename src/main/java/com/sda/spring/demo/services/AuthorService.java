package com.sda.spring.demo.services;

import com.sda.spring.demo.model.Author;
import com.sda.spring.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {


    private AuthorRepository authorRepository;

    @Autowired //wstrzykiwanie przez konstruktor
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAuthors(){
        return authorRepository.findAll();
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }

    public Optional<Author> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }
}
