package com.inventorymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import com.inventorymanagement.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);
}
