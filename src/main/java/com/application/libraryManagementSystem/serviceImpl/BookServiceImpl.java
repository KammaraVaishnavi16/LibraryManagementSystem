package com.application.libraryManagementSystem.serviceImpl;

import com.application.libraryManagementSystem.entity.Book;
import com.application.libraryManagementSystem.repository.BookRepository;
import com.application.libraryManagementSystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books;
    }

    @Override
    public Book findBookById(Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(()->new RuntimeException(String.format("book with Id : %d Not Found",bookId)));

        return book;
    }

    @Override
    public void createBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(()->new RuntimeException(String.format("book with Id : %d Not Found",bookId)));
        bookRepository.deleteById(book.getId());
    }

//    @Override
//    public Book updatedBook(Long bookId, Book book) {
//        Book updateBook = bookRepository.findById(bookId)
//                .orElseThrow(()->new RuntimeException(String.format("book with Id : %d Not Found",bookId)));
//        updateBook.setBookName(book.getBookName());
//        updateBook.setIsbn(book.getIsbn());
//
//        return null;
//    }
}
