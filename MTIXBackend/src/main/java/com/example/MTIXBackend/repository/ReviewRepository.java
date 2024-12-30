package com.example.MTIXBackend.repository;

import com.example.MTIXBackend.model.Payment;
import com.example.MTIXBackend.model.Review;
import com.example.MTIXBackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    @Query(value = "SELECT * FROM review t WHERE t.museum_id = :museumId", nativeQuery = true)
    List<Review> findByMuseumId(@Param("museumId") Integer museumId);
}
