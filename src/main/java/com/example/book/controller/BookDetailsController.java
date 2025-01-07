package com.example.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.book.entity.BookDetailsEntity;
import com.example.book.service.BookDetailsImp;
import com.example.book.entity.BookDetailsEntity;

@RestController
public class BookDetailsController {

	@Autowired
	BookDetailsImp service; 
	
	@GetMapping(value="books")
	public List<BookDetailsEntity> getAllBooks() {
		List<BookDetailsEntity> entity=service.getBookDetails();
		return entity;
	}
	
	@GetMapping(value="books/{id}")
	public Optional<BookDetailsEntity> getBooks(@PathVariable int id) {
		Optional<BookDetailsEntity> entity=service.getBookById(id);
		return entity;
	}
	
	@PostMapping(value="books/addNewBook")
	public ResponseEntity<BookDetailsEntity> addNewBook(@RequestBody BookDetailsEntity entity) {
		BookDetailsEntity entity1=service.createBook(entity);
		return new ResponseEntity<BookDetailsEntity>(entity1,HttpStatus.CREATED);
	}
	
	
	@DeleteMapping(value="books/deleteBook/{id}")
	public String deleteBook(@PathVariable int id) {
		String delete=service.deleteBook(id);
		return delete;
	}
	
	@PutMapping(value="books/updateBook/{id}")
	public ResponseEntity<BookDetailsEntity> updateBook(@PathVariable int id,@RequestBody BookDetailsEntity entity) {
		BookDetailsEntity entity1=service.updateBookDetails(id,entity);
		return new ResponseEntity<BookDetailsEntity>(entity1,HttpStatus.CREATED);
	}

}
