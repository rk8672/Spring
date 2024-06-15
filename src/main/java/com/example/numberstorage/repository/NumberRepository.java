package com.example.numberstorage.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.numberstorage.model.NumberEntity;

public interface NumberRepository extends MongoRepository<NumberEntity, String> {
}