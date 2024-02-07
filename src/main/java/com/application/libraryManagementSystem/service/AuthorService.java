package com.application.libraryManagementSystem.service;

import com.application.libraryManagementSystem.entity.Author;


import java.util.List;

public interface AuthorService {
    public List<Author> findAllAuthors();
    public Author findAuthorById(Long authorId);

    public void createAuthor(Author author);

    public void deleteAuthor(Long authorId);
}
