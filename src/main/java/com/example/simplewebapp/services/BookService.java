package com.example.simplewebapp.services;

import com.example.simplewebapp.domain.Book;

public interface BookService {
	
	public Iterable<Book> findAll();
}
