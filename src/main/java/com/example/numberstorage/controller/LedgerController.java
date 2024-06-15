package com.example.numberstorage.controller;

import com.example.numberstorage.model.AccountType;
import com.example.numberstorage.model.Ledger;
import com.example.numberstorage.repository.LedgerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ledgers")
public class LedgerController {

    @Autowired
    private LedgerRepository ledgerRepository;

    @PostMapping
    public Ledger saveLedger(@RequestBody Ledger ledger) {
        // Optionally, you can handle saving logic here if needed
        return ledgerRepository.save(ledger);
    }

    @GetMapping
    public List<Ledger> getAllLedgers() {
        return ledgerRepository.findAll();
    }

    @GetMapping("/{ledgerId}")
    public Ledger getLedgerById(@PathVariable String ledgerId) {
        Optional<Ledger> optionalLedger = ledgerRepository.findById(ledgerId);

        if (optionalLedger.isPresent()) {
            Ledger ledger = optionalLedger.get();
            // Load customer and journal entries if needed
            // Ensure customer and journal entries are fetched from repositories if not eagerly loaded
            System.out.println("Found ledger: " + ledger);
            return ledger;
            
        } else {
            System.out.println("Ledger not found with ID: " + ledgerId);
            return null;
        }
    }
    @GetMapping("/all")
    public List<Ledger> getAllLedgersWithoutId() {
        return ledgerRepository.findAll();
    }
   @GetMapping("/type/{accountType}")
    public List<Ledger> getLedgersByAccountType(@PathVariable AccountType accountType) {
        return ledgerRepository.findByAccountType(accountType);
    }
    // You can add additional endpoints for updating, deleting, and other operations here
}
