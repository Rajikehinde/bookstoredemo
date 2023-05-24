package com.library.bookstoredemo.controller;

import com.library.bookstoredemo.dto.BookStoreDto;
import com.library.bookstoredemo.entity.BookStore;
import com.library.bookstoredemo.service.BookStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookstore")
public class BookStoreController {
    @Autowired
    private BookStoreService bookStoreService;


    //Methods to call service class methods
    //method to create book
    @PostMapping("/createbook")
    public String createBook(@RequestBody BookStoreDto bookStoreDto){
        bookStoreService.createBook(bookStoreDto);
        return "book created";
    }

    //method to find all books
//    @GetMapping("/allbooks")
//    public Optional<List<BookStore>> fetchAllBooks(){
//       return bookStoreService.findAllBooks();
//    }

    //method to find all books by an author
    @GetMapping("/allbooksbyauthor/{author}")
    public Optional<List<BookStore>> fetchAllBooksByAuthor(@PathVariable String author){
        return bookStoreService.fetchAllBooksByAuthor(author);
    }

    //method to find a book by id
    @GetMapping("/fetchbookbyid/{id}")
    public Optional<BookStore> fetchBookById(@PathVariable Long id){
        return bookStoreService.fetchBookById(id);
    }
    @GetMapping("/findbookbytitle/{title}")
    public Optional<BookStore> findBookByTitle(@PathVariable String title){
        return bookStoreService.findBookByTitle(title);
    }

    @GetMapping("/findbookbyissn/{issn}")
    public Optional<BookStore> findBookByISSN(@PathVariable Long issn){
        return bookStoreService.findBookByISSN(issn);
    }

    @PutMapping("/updatebook")
    public String updateBook(@RequestBody BookStoreDto bookStoreDto){
        bookStoreService.updateBook(bookStoreDto);
        return " Book updated";
    }

    @DeleteMapping("/deletebook/{id}")
    public String deletingBook(@PathVariable Long id){
        bookStoreService.deletingBook(id);
        return "book deleted";
    }
}
