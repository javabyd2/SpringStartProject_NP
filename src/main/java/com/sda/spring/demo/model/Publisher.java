package com.sda.spring.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Publisher {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;

    @OneToMany(mappedBy = "publisher")
    private Set<Book> book;

    public Publisher() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBook(Set<Book> book) {
        this.book = book;
    }
}
