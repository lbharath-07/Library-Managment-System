package com.example.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.book.entity.BookDetailsEntity;

@Service
public interface BookDetailsService {

	List<BookDetailsEntity> getBookDetails(); //get all books

	Optional<BookDetailsEntity> getBookById(int id); //get book by id
	
	BookDetailsEntity createBook(BookDetailsEntity entity);  //create a book using post
	
	String deleteBook(int id);  //delete a book
	
	BookDetailsEntity updateBookDetails(int id,BookDetailsEntity entity); //update book
	
}
