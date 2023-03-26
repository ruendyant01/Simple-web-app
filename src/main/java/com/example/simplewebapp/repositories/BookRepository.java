package com.example.simplewebapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.simplewebapp.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
