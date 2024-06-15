package com.example.numberstorage.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators.In;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "numbers")
public class NumberEntity {
    @Id
    private String id;
    private String name;
    private Integer number;
    private Integer balance;
    private Integer needToPay;


    // ID
    public String getId() {
        return id;

    }

    public void setId(String id) {
        this.id = id;
    }
// Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Number
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    // Balance
    public Integer getBalance(){
        return balance;
    }

    public void setBalance(Integer balance){
        this.balance=balance;
    }
// Need To Pay
public Integer getNeedToPay(){
    return needToPay;
}
public void setNeedToPay(Integer needToPay){
    this.needToPay=needToPay;
}


}
