package com.example.simplewebapp.repositories;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;

import com.example.simplewebapp.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, BigInteger> {

}
