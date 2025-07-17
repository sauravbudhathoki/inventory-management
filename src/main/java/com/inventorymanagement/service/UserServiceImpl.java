package com.inventorymanagement.service;

import com.inventorymanagement.entity.User;
import com.inventorymanagement.enums.Role;
import com.inventorymanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    private final PasswordEncoder passwordEncoder;  // add password encoder

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User saveUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User object is null");
        }

        // Encode password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Do NOT force role here - accept role from caller
        // Validate role is not null (optional)
        if (user.getRole() == null) {
            user.setRole(Role.ROLE_USER);  // default role
        }

        // Do NOT override role here, assume caller (controller) sets it properly

        System.out.println("Saving user: " + user.getUsername() + ", Role: " + user.getRole());

        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    }
