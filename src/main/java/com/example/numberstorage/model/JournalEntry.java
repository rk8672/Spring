package com.example.numberstorage.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "journalEntries")
public class JournalEntry {

    @Id
    private String id;
    private Date date;
    private String description;
    private double debit;
    private double credit;
    private String customerId;
    private String ledgerId;

    // Constructors
    public JournalEntry() {
    }

    public JournalEntry(Date date, String description, double debit, double credit, String customerId, String ledgerId) {
        this.date = date;
        this.description = description;
        this.debit = debit;
        this.credit = credit;
        this.customerId = customerId;
        this.ledgerId = ledgerId;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getLedgerId() {
        return ledgerId;
    }

    public void setLedgerId(String ledgerId) {
        this.ledgerId = ledgerId;
    }
}
