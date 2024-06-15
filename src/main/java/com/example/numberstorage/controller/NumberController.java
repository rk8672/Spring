package com.example.numberstorage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.numberstorage.model.NumberEntity;
import com.example.numberstorage.repository.NumberRepository;

import java.util.List;

@RestController
@RequestMapping("/numbers")
public class NumberController {

    @Autowired
    private NumberRepository numberRepository;

    @PostMapping
    public NumberEntity saveNumber(@RequestBody NumberEntity numberEntity) {
        return numberRepository.save(numberEntity);
    }

    @GetMapping
    public List<NumberEntity> getAllNumbers() {
        return numberRepository.findAll();
    }
}