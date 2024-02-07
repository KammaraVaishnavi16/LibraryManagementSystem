package com.application.libraryManagementSystem.service;

import com.application.libraryManagementSystem.entity.Author;
import com.application.libraryManagementSystem.entity.Publisher;

import java.util.List;

public interface PublisherService {
    public List<Publisher> findAllPublishers();
    public Publisher findPublisherById(Long publisherId);

    public void createPublisher(Publisher publisher);

    public void deletePublisher(Long publisherId);
}
