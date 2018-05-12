package com.sda.spring.demo.repository;

import com.sda.spring.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    public Book findByTitle(String title);
}
