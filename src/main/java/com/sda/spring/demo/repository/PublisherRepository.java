package com.sda.spring.demo.repository;

import com.sda.spring.demo.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
