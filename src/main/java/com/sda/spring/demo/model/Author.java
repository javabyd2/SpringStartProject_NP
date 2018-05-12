package com.sda.spring.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;

    public Author() {
    }

    public Author(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
