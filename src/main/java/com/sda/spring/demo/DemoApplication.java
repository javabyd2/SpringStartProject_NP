package com.sda.spring.demo;

import com.sda.spring.demo.model.Author;
import com.sda.spring.demo.model.Book;
import com.sda.spring.demo.model.Category;
import com.sda.spring.demo.repository.AuthorRepository;
import com.sda.spring.demo.repository.BookRepository;
import com.sda.spring.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	public BookRepository bookRepository;
	@Autowired
	public AuthorRepository authorRepository;
	@Autowired
	public CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Author sKing = new Author("Stephen", "King");
		Set<Author> first = new HashSet<>();
		first.add(sKing);
		Category horror = new Category("horror");
		Book book = new Book("Misery", "4235452", first, horror);
		bookRepository.save(book);
		Author nesbo = new Author("Jo", "Nesbo");
		first.clear();
		first.add(nesbo);
		bookRepository.save(new Book("Pierwszy śnieg", "42423432", first, new Category("crime story")));
		first.clear();
		Author mus = new Author("Małgorzata", "Musierowicz");
		first.add(mus);
		Category mlodziez = new Category("Literatura młodzieżowa");
		bookRepository.save(new Book("Ciotka zgryzotka", "42432443", first, mlodziez));
	}
}
