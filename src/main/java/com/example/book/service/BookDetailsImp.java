package com.example.book.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.book.entity.BookDetailsEntity;
import com.example.book.repo.BookRepository;
import com.example.book.repo.BookRepository;

@Component
public class BookDetailsImp implements BookDetailsService{
	
	
	@Autowired
	BookRepository repository;

	@Autowired
    public BookDetailsImp(BookRepository repository) {
        this.repository = repository;
    }
	
	
	@Override
	public List<BookDetailsEntity> getBookDetails() {
		
		List<BookDetailsEntity> bookDetails=repository.findAll();
		return bookDetails;
	}


	@Override
	public Optional<BookDetailsEntity> getBookById(int id) {
		Optional<BookDetailsEntity> bookById=repository.findById(id);
		return bookById;
	}


	@Override
	public BookDetailsEntity createBook(BookDetailsEntity resEntity) {
		int id=resEntity.getBookId();
		String title=resEntity.getTitle();
		String author=resEntity.getAuthor();
		String genre=resEntity.getGenre();
		Double price=resEntity.getPrice();
		LocalDate publicationDate=resEntity.getPublicationDate();
		char availability=resEntity.getAvailability();
		
		BookDetailsEntity savingEntity=new BookDetailsEntity();
		savingEntity.setBookId(id);
		savingEntity.setTitle(title);
		savingEntity.setAuthor(author);
		savingEntity.setGenre(genre);
		savingEntity.setPrice(price);
		savingEntity.setPublicationDate(publicationDate);
		savingEntity.setAvailability(availability);
		
		BookDetailsEntity save=repository.save(savingEntity);
		return save;
	}


	@Override
	public String deleteBook(int id) {
		Optional<BookDetailsEntity> optional=repository.findById(id);
		if(optional.isPresent()) {
			repository.deleteById(id);
		}
		
		return "Book Deleted Successfully!";
	}


	@Override
	public BookDetailsEntity updateBookDetails(int id, BookDetailsEntity resEntity) {
		Optional<BookDetailsEntity> findById=repository.findById(id);
		
		BookDetailsEntity savingEntity=findById.get();
		
		BookDetailsEntity update=null;
		if(findById.isPresent()) {
			String title=resEntity.getTitle();
			String author=resEntity.getAuthor();
			String genre=resEntity.getGenre();
			Double price=resEntity.getPrice();
			LocalDate publicationDate=resEntity.getPublicationDate();
			char availability=resEntity.getAvailability();
			
			
			savingEntity.setTitle(title);
			savingEntity.setAuthor(author);
			savingEntity.setGenre(genre);
			savingEntity.setPrice(price);
			savingEntity.setPublicationDate(publicationDate);
			savingEntity.setAvailability(availability);
			
			update=repository.save(savingEntity);
		}
		return update;
	}

	

}
