package com.example.MTIXBackend.repository;

import com.example.MTIXBackend.model.TiketKeluarga;
import com.example.MTIXBackend.model.TiketPelajar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TiketPelajarRepository extends JpaRepository<TiketPelajar, Integer> {
    // JpaRepository provides basic CRUD operations out-of-the-box.
    // Add custom queries here if needed.
    @Query(value = "SELECT * FROM tiket_pelajar t WHERE t.keranjang_id = :keranjangId", nativeQuery = true)
    List<TiketPelajar> findByKeranjangId(@Param("keranjangId") Integer keranjangId);
}