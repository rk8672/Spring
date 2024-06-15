package com.example.numberstorage.controller;

import com.example.numberstorage.model.JournalEntry;
import com.example.numberstorage.model.Ledger;
import com.example.numberstorage.repository.JournalEntryRepository;
import com.example.numberstorage.repository.LedgerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journalEntries")
public class JournalEntryController {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private LedgerRepository ledgerRepository;

    @PostMapping
    public JournalEntry createJournalEntry(@RequestBody JournalEntry journalEntry) {
        Ledger ledger = ledgerRepository.findByCustomerId(journalEntry.getCustomerId());
        if (ledger != null) {
            journalEntry.setLedgerId(ledger.getId());
            journalEntryRepository.save(journalEntry);

            // Update ledger with the new journal entry
            ledger.addJournalEntry(journalEntry);
            ledgerRepository.save(ledger);
        }
        return journalEntry;
    }

    @GetMapping
    public List<JournalEntry> getAllJournalEntries() {
        return journalEntryRepository.findAll();
    }

    @GetMapping("/customer/{customerId}")
    public List<JournalEntry> getJournalEntriesByCustomerId(@PathVariable String customerId) {
        return journalEntryRepository.findByCustomerId(customerId);
    }

    @GetMapping("/ledger/{ledgerId}")
    public List<JournalEntry> getJournalEntriesByLedgerId(@PathVariable String ledgerId) {
        return journalEntryRepository.findByLedgerId(ledgerId);
    }
}
