package com.example.numberstorage.model;

public class JournalEntryItem {

    private String account;
    private Double amount;

    // Constructors
    public JournalEntryItem() {
    }

    public JournalEntryItem(String account, Double amount) {
        this.account = account;
        this.amount = amount;
    }

    // Getters and setters
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
