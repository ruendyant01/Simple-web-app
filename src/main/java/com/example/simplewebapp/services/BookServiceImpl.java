package com.example.simplewebapp.services;

import org.springframework.stereotype.Service;

import com.example.simplewebapp.domain.Book;
import com.example.simplewebapp.repositories.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	
	private final BookRepository bookRepository;
	
	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	@Override
	public Iterable<Book> findAll() {
		return this.bookRepository.findAll();
	}

}
