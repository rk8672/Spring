package com.example.numberstorage.repository;

import com.example.numberstorage.model.Customer; // Adjust to your actual entity class
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
    // You can define additional query methods here if needed
}
