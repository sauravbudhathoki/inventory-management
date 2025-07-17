package com.inventorymanagement.controller;

import com.inventorymanagement.entity.User;
import com.inventorymanagement.enums.Role;
import com.inventorymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Register a regular USER (anyone allowed)
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        if (user == null || user.getUsername() == null || user.getPassword() == null) {
            return ResponseEntity.badRequest().body("Missing required fields: username or password");
        }

        // Force role to USER regardless of input
        user.setRole(Role.ROLE_USER);

        try {
            User savedUser = userService.saveUser(user);
            return ResponseEntity.ok(savedUser);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error saving user: " + e.getMessage());
        }
    }

    // Register an ADMIN - restrict access only to admins (or remove @PreAuthorize if manual creation)
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/register-admin")
    public ResponseEntity<?> registerAdmin(@RequestBody User user) {
        if (user == null || user.getUsername() == null || user.getPassword() == null) {
            return ResponseEntity.badRequest().body("Missing required fields: username or password");
        }

        // Force role to ADMIN regardless of input
        user.setRole(Role.ROLE_ADMIN);

        try {
            User savedUser = userService.saveUser(user);
            return ResponseEntity.ok(savedUser);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error saving admin user: " + e.getMessage());
        }
    }
}
