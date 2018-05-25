package com.sda.spring.demo.services;

import com.sda.spring.demo.exception.PublisherNotFoundExcepton;
import com.sda.spring.demo.model.Publisher;
import com.sda.spring.demo.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    private PublisherRepository publisherRepository;

    @Autowired
    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public List<Publisher> getPublisher(){
        return publisherRepository.findAll();
    }

    public Publisher getPublisherById(Long id){
        return publisherRepository.findById(id).orElseThrow(()-> new PublisherNotFoundExcepton(id));
    }

    public Publisher save(Publisher publisher) {
        return publisherRepository.save(publisher);
    }
}
