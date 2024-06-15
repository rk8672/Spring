package com.example.numberstorage.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "ledgers")
public class Ledger {

    @Id
    private String id;

    private String customerId;

    private AccountType accountType; 

    @DBRef 
    private Customer customer;

    @DBRef 
    private List<JournalEntry> journalEntries = new ArrayList<>();

    public Ledger() {
    }

    // Constructor with customerId and accountType
    public Ledger(String customerId, AccountType accountType) {
        this.customerId = customerId;
        this.accountType = accountType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<JournalEntry> getJournalEntries() {
        return journalEntries;
    }

    public void setJournalEntries(List<JournalEntry> journalEntries) {
        this.journalEntries = journalEntries;
    }

    public void addJournalEntry(JournalEntry journalEntry) {
        this.journalEntries.add(journalEntry);
    }

    // Optionally, you can also define methods to remove journal entries or perform other operations
}
