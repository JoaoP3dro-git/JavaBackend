package com.bosch.example.services;

import com.bosch.example.model.User;

public interface UserAuth {
    User loginByUsername(String userame);
    User loginByEmail(String email);
}
