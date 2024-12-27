package com.example.MTIXBackend.repository;

import com.example.MTIXBackend.model.TiketKeluarga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TiketKeluargaRepository extends JpaRepository<TiketKeluarga, Integer> {
    // JpaRepository provides basic CRUD operations out-of-the-box.
    // Add custom queries here if needed.
    List<TiketKeluarga> findByStatus(String status);
}