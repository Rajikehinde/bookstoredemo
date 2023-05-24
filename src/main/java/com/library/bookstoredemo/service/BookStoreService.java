package com.library.bookstoredemo.service;

import com.library.bookstoredemo.dto.BookStoreDto;
import com.library.bookstoredemo.entity.BookStore;
import com.library.bookstoredemo.reppo.BookStoreReppo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.swing.text.html.Option;
import java.awt.print.Book;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookStoreService {

    @Autowired
    private BookStoreReppo bookStoreReppo;

    //Book Creation
    public void createBook(BookStoreDto bookStoreDto){
        BookStore bookStore = new BookStore(); //Creating a new book object

        bookStore.setTitle(bookStoreDto.getTitle());
        bookStore.setAuthor(bookStoreDto.getAuthor());
        bookStore.setDescription(bookStoreDto.getDescription());
        bookStore.setIssn(bookStoreDto.getIssn());
        bookStore.setVolume(bookStoreDto.getVolume());
        bookStore.setQuantity(bookStoreDto.getQuantity());
        bookStore.setPrice(bookStoreDto.getPrice());
        bookStore.setSupplyDate(LocalDateTime.now());
        bookStore.setPurchaseDate(LocalDateTime.now()); //null till date/time of purchase
        bookStoreReppo.save(bookStore);

    }

    //Fetches all books in the database
//    public Optional<List<BookStore>> findAllBooks(){
//        return bookStoreReppo.findAllBooks();
//    }
    //Fetches all books written by an author
    public Optional<List<BookStore>> fetchAllBooksByAuthor(String author){
        return bookStoreReppo.findAllBooksByAuthor(author);
    }
    //Finding book by id
    public Optional<BookStore> fetchBookById(Long id){
        return bookStoreReppo.findById(id);
    }

    //Finding book by title
    public Optional<BookStore> findBookByTitle(String title){
        return bookStoreReppo.findByTitle(title);
    }

    //Finding book by ISSN
    public Optional<BookStore> findBookByISSN(Long issn){
        return bookStoreReppo.findByIssn(issn);
    }

    //Updating a book
    public void updateBook(BookStoreDto bookStoreDto){

        //to check that book
        BookStore findBook = bookStoreReppo.findById(bookStoreDto.getID()).get();
        if(findBook != null) {
            BookStore bookStore = new BookStore(); //Creating a new book object

            //bookStore.setTitle(bookStoreDto.getTitle());
            //bookStore.setAuthor(bookStoreDto.getAuthor());
            bookStore.setDescription(bookStoreDto.getDescription());
            //bookStore.setISSN(bookStoreDto.getISSN());
            bookStore.setVolume(bookStoreDto.getVolume());
            bookStore.setQuantity(bookStoreDto.getQuantity());
            bookStore.setPrice(bookStoreDto.getPrice());
            bookStore.setSupplyDate(LocalDateTime.now());
            //bookStore.setPurchaseDate(null); //null till date/time of purchase


            bookStoreReppo.save(bookStore);
        }
        else{
            System.out.println("Book not found.");
        }
    }

    //Deleting a book
    public void deletingBook(Long id){

        if (bookStoreReppo.existsById(id)){
            BookStore bookStore = new BookStore();
            bookStore = bookStoreReppo.findById(id).get();
            //only changes delete status
            bookStore.setDeleteStatus(true);

        }
        else {
            System.out.println("Book deleted");
        }
    }
}
