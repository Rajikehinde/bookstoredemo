package com.library.bookstoredemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "book_store")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookStore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name = "book_title", unique = true,nullable = false)
    private String title;

    @Column(name = "book_author", unique = false,nullable = false)
    private String author;

    @Column(name = "book_description",nullable = false)
    private String description;
    @Column(name = "serial_number", unique = true,nullable = false)
    private Long issn;

    @Column(name = "series", unique = false,nullable = true)
    private int volume;

    @Column(name = "quantity",nullable = false)
    private Long quantity;

    @Column(name = "price",nullable = false)
    private Double price;

    @Column(name = "supply_date",nullable = false)
    private LocalDateTime supplyDate;
    @Column(name = "date_of_purchase",nullable = false)
    private LocalDateTime purchaseDate;

    @Column(name = "delete_status",nullable = false)
    private Boolean deleteStatus = false;
}
