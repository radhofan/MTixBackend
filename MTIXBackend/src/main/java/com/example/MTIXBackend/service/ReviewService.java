package com.example.MTIXBackend.service;

import com.example.MTIXBackend.model.Keranjang;
import com.example.MTIXBackend.model.Payment;
import com.example.MTIXBackend.model.Review;
import com.example.MTIXBackend.model.User;
import com.example.MTIXBackend.repository.KeranjangRepository;
import com.example.MTIXBackend.repository.ReviewRepository;
import com.example.MTIXBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ReviewService {

    //////////////////////////////////////////////////////// Attributes and Contructors
    ///
    private final ReviewRepository reviewRepository;
    private final MuseumService museumService;
    private final UserRepository userRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, MuseumService museumService, UserRepository userRepository) {
        this.reviewRepository = reviewRepository;
        this.museumService = museumService;
        this.userRepository = userRepository;
    }

    //////////////////////////////////////////////////////// Continued Business Methods
    public  List<Review> getAllMuseumReviews(int museum_id) {
        return reviewRepository.findByMuseumId(museum_id);
    }

    public Review addReview(Review review, int museum_id) {
        review.setMuseum(museumService.getMuseumById(museum_id));
        User user = userRepository.findById(review.getUser().getUser_id())
                .orElseThrow(() -> new RuntimeException("User not found"));
        review.setUser(user);
        return reviewRepository.save(review);
    }

    //////////////////////////////////////////////////////// CRUD Methods
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review getReviewById(int id) {
        Optional<Review> review = reviewRepository.findById(id);
        return review.orElse(null); // Return the user if found, else return null
    }

    public Review createReview(Review review) {
        return reviewRepository.save(review); // Save the new user to the database
    }

    public Review updateReview(Review review) {
        return reviewRepository.save(review); // Save the updated user to the database
    }

    public void deleteReview(int id) {
        reviewRepository.deleteById(id); // Delete the user by ID
    }

}
