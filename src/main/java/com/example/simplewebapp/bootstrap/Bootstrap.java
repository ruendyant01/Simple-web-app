package com.example.simplewebapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.simplewebapp.domain.Author;
import com.example.simplewebapp.domain.Book;
import com.example.simplewebapp.domain.Publisher;
import com.example.simplewebapp.repositories.AuthorRepository;
import com.example.simplewebapp.repositories.BookRepository;
import com.example.simplewebapp.repositories.PublisherRepository;

@Component
public class Bootstrap implements CommandLineRunner {
	
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;

	public Bootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}



	@Override
	public void run(String... args) throws Exception {
		Author JKR = new Author();
		JKR.setName("JK Rowling");
		JKR.setDescription("Awesome author and most popular");
		
		Book harryPotter = new Book();
		harryPotter.setName("Harry Potter");
		harryPotter.setIsbn("Awesome book and most popular");
		
		Book harryPotter2 = new Book();
		harryPotter2.setName("Harry Potter 2");
		harryPotter2.setIsbn("Awesome book and most popular too");
		
		Publisher HPPublish = new Publisher();
		HPPublish.setPublisherName("JK Bowling");
		HPPublish.setCity("New York");
		
		Author JKRSave = this.authorRepository.save(JKR);
		Book HPSave = this.bookRepository.save(harryPotter);
		Book HPSave2 = this.bookRepository.save(harryPotter2);
		
		JKRSave.getBooks().add(HPSave);
		JKRSave.getBooks().add(HPSave2);
		HPSave.getAuthors().add(JKRSave);
		HPSave2.getAuthors().add(JKRSave);
		
		this.authorRepository.save(JKRSave);
		Publisher HpPublishSave = this.publisherRepository.save(HPPublish);
		
		HPSave.setPublishers(HpPublishSave);
		this.bookRepository.save(HPSave);
		this.bookRepository.save(HPSave2);
		
		System.out.println("Bootstrap");
		System.out.println("Book : " + this.bookRepository.count());
		System.out.println("Author : " + this.authorRepository.count());
		System.out.println("Publisher : " + this.publisherRepository.count());
	}
	
}










