package com.application.libraryManagementSystem.service;

import com.application.libraryManagementSystem.entity.Book;

import java.util.List;

public interface BookService {
    public List<Book> findAllBooks();
    public Book findBookById(Long bookId);

    public void createBook(Book book);

    public void deleteBook(Long bookId);

//    public Book updatedBook(Long id,Book book);
}
