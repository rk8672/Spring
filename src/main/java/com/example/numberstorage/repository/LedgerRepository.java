package com.example.numberstorage.repository;

import com.example.numberstorage.model.AccountType;
import com.example.numberstorage.model.Ledger;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LedgerRepository extends MongoRepository<Ledger, String> {
    Ledger findByCustomerId(String customerId);
    List<Ledger> findByAccountType(AccountType accountType); // New method to find ledgers by account type
}
