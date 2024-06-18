package com.bosch.example.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.model.User;
import com.bosch.example.repositories.UserJPARepository;
import com.bosch.example.services.MailValidator;
import com.bosch.example.services.PasswordValidator;
import com.bosch.example.services.UserAuth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserController {

    @Autowired
    UserJPARepository repo;

    @Autowired
    PasswordValidator passValidator;

    @Autowired
    MailValidator mailValidator;

    @Autowired
    UserAuth userAuth;
    
    @PostMapping("create")
    public ResponseEntity<String> create(@RequestBody User user) {
        
        if (user.getUsername() == null || user.getUsername().length() < 4) {
            return ResponseEntity.badRequest()
                .body("Username is too short.");
        }

        if (!mailValidator.validate(user.getEmail())) {
            return ResponseEntity.badRequest()
                .body("Email is too short or invalid.");
        }

        if (userAuth.loginByUsername(user.getUsername()) != null) {
            return ResponseEntity.badRequest()
                .body("Username already taken.");
        }

        if (userAuth.loginByEmail(user.getEmail()) != null) {
            return ResponseEntity.badRequest()
            .body("Email already taken.");
        }

        if (!passValidator.validate(user.getPassword())) {
            return ResponseEntity.badRequest()
            .body("Password is to short or Invalid! Your password must be at least 8 digits long and include at least 1 lowercase character, 1 uppercase character and 1 number.");
        }

        repo.save(user);

        return ResponseEntity.ok("User registered successfully.");
    }
    
}
