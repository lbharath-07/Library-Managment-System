package com.example.book.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Books")
@Data
public class BookDetailsEntity {
	
	 @Id
    @Column(name = "BookID")
    private int bookId;

    @Column(name = "Title", nullable = false, length = 255)
    private String title;

    @Column(name = "Author", nullable = false, length = 255)
    private String author;

    @Column(name = "Genre", length = 100)
    private String genre;

    @Column(name = "Price")
    private Double price;

    @Column(name = "PUBLICATIONDATE")
    private LocalDate publicationDate;

    @Column(name = "Availability", length = 1)
    private char availability;

}
