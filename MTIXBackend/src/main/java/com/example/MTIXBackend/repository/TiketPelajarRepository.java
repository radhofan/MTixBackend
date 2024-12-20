package com.example.MTIXBackend.repository;

import com.example.MTIXBackend.model.TiketPelajar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiketPelajarRepository extends JpaRepository<TiketPelajar, Integer> {
    // JpaRepository provides basic CRUD operations out-of-the-box.
    // Add custom queries here if needed.
}