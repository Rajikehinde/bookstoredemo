package com.library.bookstoredemo.dto;

import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class BookStoreDto {
     private Long ID;
     private String title;
    private String author;
    private String description;
    private Long issn;
    private int volume;
    private Long quantity;
    private Double price;
    private LocalDateTime supplyDate;
    private LocalDateTime purchaseDate;
    private Boolean deleteStatus;
}
