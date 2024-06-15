package com.example.numberstorage.repository;

import com.example.numberstorage.model.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JournalEntryRepository extends MongoRepository<JournalEntry, String> {
    List<JournalEntry> findByCustomerId(String customerId);
    List<JournalEntry> findByLedgerId(String ledgerId);
}
