package com.example.book.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.book.entity.BookDetailsEntity;

@Repository
public interface BookRepository extends JpaRepository<BookDetailsEntity,Integer>{


}
