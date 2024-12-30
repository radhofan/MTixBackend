package com.example.MTIXBackend.repository;

import com.example.MTIXBackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // JpaRepository provides basic CRUD operations out-of-the-box.
    // Add custom queries here if needed.
    User findByEmail(String email);
    boolean existsByEmail(String email);
}