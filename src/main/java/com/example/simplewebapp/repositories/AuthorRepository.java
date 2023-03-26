package com.example.simplewebapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.simplewebapp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
