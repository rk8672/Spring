package com.example.numberstorage.controller;

import com.example.numberstorage.model.AccountType;
import com.example.numberstorage.model.Customer;
import com.example.numberstorage.model.Ledger;
import com.example.numberstorage.repository.CustomerRepository;
import com.example.numberstorage.repository.LedgerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private LedgerRepository ledgerRepository;

    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer) {
        // Save the customer
        Customer savedCustomer = customerRepository.save(customer);

        // Create a new ledger for the customer with Revenue account type
        Ledger ledger = new Ledger(savedCustomer.getId(), AccountType.REVENUE); // Assuming customers are primarily sources of revenue
        ledger.setCustomer(savedCustomer);
        ledgerRepository.save(ledger);

        return savedCustomer;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
   
    }

    @GetMapping("/{customerId}")
    public Customer getCustomerById(@PathVariable String customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        return optionalCustomer.orElse(null);
    }
}
