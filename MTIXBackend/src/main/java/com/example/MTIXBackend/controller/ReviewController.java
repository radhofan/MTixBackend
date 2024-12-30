package com.example.MTIXBackend.controller;

import com.example.MTIXBackend.model.Admin;
import com.example.MTIXBackend.model.Keranjang;
import com.example.MTIXBackend.model.Review;
import com.example.MTIXBackend.service.KeranjangService;
import com.example.MTIXBackend.controller.KeranjangController;
import com.example.MTIXBackend.model.User;
import com.example.MTIXBackend.service.ReviewService;
import com.example.MTIXBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reviews") // Define base URL for User-related operations
public class ReviewController {

    //////////////////////////////////////////////////////// Attributes and Contructors
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;  // Ensure proper initialization
    }

    //////////////////////////////////////////////////////// Business Methods
    @GetMapping("/getAllMuseumReviews/{museum_id}")
    public List<Review> getAllMuseumReviews(@PathVariable int museum_id) {
        return reviewService.getAllMuseumReviews(museum_id);
    }

    @PostMapping("/addReview/{museum_id}")
    public Review addReview(@RequestBody Review review, @PathVariable int museum_id) {
        return reviewService.addReview(review, museum_id);
    }

    //////////////////////////////////////////////////////// CRUD Methods
    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable int id) {
        return reviewService.getReviewById(id);
    }

    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return reviewService.createReview(review);
    }

    @PutMapping("/{id}")
    public Review updateReview(@PathVariable int id, @RequestBody Review review) {
        review.setReview_id(id);
        return reviewService.updateReview(review);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable int id) {
        reviewService.deleteReview(id);
    }
}
