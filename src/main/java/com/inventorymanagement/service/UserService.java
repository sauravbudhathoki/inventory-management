package com.inventorymanagement.service;

import com.inventorymanagement.entity.User;

import java.util.Optional;

public interface UserService {

    User saveUser(User user);
    Optional<User> findByUsername(String username);
}
