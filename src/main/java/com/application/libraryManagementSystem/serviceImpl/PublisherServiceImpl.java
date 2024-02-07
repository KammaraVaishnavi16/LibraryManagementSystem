package com.application.libraryManagementSystem.serviceImpl;

import com.application.libraryManagementSystem.entity.Category;
import com.application.libraryManagementSystem.entity.Publisher;
import com.application.libraryManagementSystem.repository.PublisherRepository;
import com.application.libraryManagementSystem.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;
    @Override
    public List<Publisher> findAllPublishers() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher findPublisherById(Long publisherId) {
        Publisher publisher = publisherRepository.findById(publisherId)
                .orElseThrow(()->new RuntimeException(String.format("Category of Id : %d Not found",publisherId)));
        return publisher;

    }

    @Override
    public void createPublisher(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    @Override
    public void deletePublisher(Long publisherId) {
        Publisher publisher = publisherRepository.findById(publisherId)
                .orElseThrow(()->new RuntimeException(String.format("Category of Id : %d Not found",publisherId)));
        publisherRepository.deleteById(publisher.getId());
    }
}
