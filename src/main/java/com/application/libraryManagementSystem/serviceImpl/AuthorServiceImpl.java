package com.application.libraryManagementSystem.serviceImpl;

import com.application.libraryManagementSystem.entity.Author;
import com.application.libraryManagementSystem.repository.AuthorRepository;
import com.application.libraryManagementSystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    @Override
    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author findAuthorById(Long authorId) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(()->new RuntimeException(String.format("Category of Id : %d Not found",authorId)));
        return author;
    }

    @Override
    public void createAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(Long authorId) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(()->new RuntimeException(String.format("Category of Id : %d Not found",authorId)));
        authorRepository.deleteById(author.getId());
    }
}
