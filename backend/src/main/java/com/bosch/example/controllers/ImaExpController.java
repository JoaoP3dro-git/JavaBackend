package com.bosch.example.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.dto.ImaExpResult;
import com.bosch.example.services.ImaExpService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ImaExpController {
    
    @Autowired
    ImaExpService service;

    @GetMapping("imaexp")
    public ImaExpResult getMethodName(@RequestParam Long A, @RequestParam Long b) {
        return service.calculate(A, b);
    }
    
}
