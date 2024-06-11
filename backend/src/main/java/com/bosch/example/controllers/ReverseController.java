package com.bosch.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.dto.ReverseResult;
import com.bosch.example.services.ReverseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class ReverseController {
    
    @Autowired
    ReverseService service;

    @GetMapping("reverse/{word}")
    public ReverseResult getMethodName(@PathVariable String word) {
        var result = service.reverse(word);
        var palindrome = service.isPalindrome(word, result);

        return new ReverseResult(result, palindrome);
    }
    
}
