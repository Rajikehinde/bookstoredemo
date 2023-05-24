package com.library.bookstoredemo.reppo;

import com.library.bookstoredemo.entity.BookStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookStoreReppo extends JpaRepository<BookStore, Long> {
    //Optional<List<BookStore>> findAllBooks();
    Optional<List<BookStore>> findAllBooksByAuthor(String author);
    Optional<BookStore> findByTitle(String title);
    Optional<BookStore> findByIssn(Long issn);

    Optional<BookStore> findById(Long id);
}
