package com.sda.spring.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;
    private String ibsn;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(joinColumns =
    @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns =
            @JoinColumn(name = "author_id", referencedColumnName = "id"))
    private Set<Author> authors;
    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;

    public Book(String title, String ibsn, Set<Author> authors, Category category) {
        this.title = title;
        this.ibsn = ibsn;
        this.authors = authors;
        this.category = category;
    }

    public Book() {
    }

    public Category getCategory() {
        return category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIbsn() {
        return ibsn;
    }

    public void setIbsn(String ibsn) {
        this.ibsn = ibsn;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
