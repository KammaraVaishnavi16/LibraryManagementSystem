package com.application.libraryManagementSystem.controller;

import com.application.libraryManagementSystem.entity.Book;
import com.application.libraryManagementSystem.entity.Publisher;
import com.application.libraryManagementSystem.service.AuthorService;
import com.application.libraryManagementSystem.service.BookService;
import com.application.libraryManagementSystem.service.CategoryService;
import com.application.libraryManagementSystem.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private PublisherService publisherService;
    @GetMapping("/books")
    public String findAllBooks(Model model){
        List<Book> books = bookService.findAllBooks();
        model.addAttribute("books",books);
        return "books";
    }
    @GetMapping("/book/{id}")
    public String findBookById(@PathVariable(name = "id") Long id, Model model){
        Book book = bookService.findBookById(id);
        model.addAttribute("book",book);
        return "list-book";
    }

    @GetMapping("remove-book/{id}")
    public String deleteBookById(@PathVariable Long id,Model model){
        bookService.deleteBook(id);
        model.addAttribute("books",bookService.findAllBooks());
        return "redirect:/books";
    }

    @GetMapping("/update-book/{id}")
    public String updateBook(@PathVariable Long id,Model model){
        Book book = bookService.findBookById(id);
        model.addAttribute("book",book);
        model.addAttribute("categories",categoryService.findAllCategories());
        model.addAttribute("publishers",publisherService.findAllPublishers());
        model.addAttribute("authors",authorService.findAllAuthors());
        return "update-book";
    }

    //Binding Result is and object, which will check for validation errors in UI
    @PostMapping("/save-update/{id}")
    public String saveUpdate(@PathVariable Long id,Book book, BindingResult result,Model model){
        if(result.hasErrors()){
            return "update-book";
        }
        bookService.createBook(book);
        model.addAttribute("books",bookService.findAllBooks());
        return "redirect:/books";
    }

    @GetMapping("/add-book")
    public String addBook(Book book,Model model){
        model.addAttribute("categories",categoryService.findAllCategories());
        model.addAttribute("publishers",publisherService.findAllPublishers());
        model.addAttribute("authors",authorService.findAllAuthors());
        return "add-book";
    }

    @PostMapping("/save-book")
    public String saveBook(Book book,BindingResult result,Model model){
        if(result.hasErrors()){
            return "add-book";
        }
        bookService.createBook(book);
        model.addAttribute("books",bookService.findAllBooks());
        return "redirect:/books";
    }
}
