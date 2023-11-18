package com.truthwear.truthwear.controller;

import com.truthwear.truthwear.entity.ProductReviews;
import com.truthwear.truthwear.service.ProductReviewServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reviews")
public class ProductReviewController {

    private final ProductReviewServiceImpl productReviewService;

    // Get all reviews
    @GetMapping
    public ResponseEntity<List<ProductReviews>> getAllReviews() {
        List<ProductReviews> reviews = productReviewService.getAllReviews();
        if (reviews != null) {
            return ResponseEntity.ok(reviews);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get reviews based on user ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ProductReviews>> getProductReviewBasedOnUserId(@PathVariable int userId) {
        List<ProductReviews> reviews = productReviewService.getProductReviewBasedOnUserId(userId);
        if (reviews != null) {
            return ResponseEntity.ok(reviews);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get Reviews based on product ID
    @GetMapping("/product/{productId}")
    public ResponseEntity<List<ProductReviews>> getProductReviewBasedOnProductId(@PathVariable int productId) {
        List<ProductReviews> reviews = productReviewService.getProductReviewBasedOnProductId(productId);
        if (reviews != null) {
            return ResponseEntity.ok(reviews);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get a specific review by id
    @GetMapping("/{id}")
    public ResponseEntity<ProductReviews> getProductReviewById(@PathVariable int id) {
        ProductReviews review = productReviewService.getProductReviewById(id);
        if (review != null) {
            return ResponseEntity.ok(review);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Create a new review
    @PostMapping
    public ResponseEntity<ProductReviews> createReviews(@RequestBody ProductReviews productReviews) {
        ProductReviews review = productReviewService.createReviews(productReviews);
        if (review != null) {
            return ResponseEntity.ok(review);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Update an existing review
    @PutMapping("/{id}")
    public ResponseEntity<ProductReviews> updateReviews(@PathVariable int id, @RequestParam(name = "ratingValue", required = false) Integer ratingValue, @RequestParam(name = "comments", required = false) String comments) {
        ProductReviews review = productReviewService.updateReviews(id, ratingValue, comments);
        if (review != null) {
            return ResponseEntity.ok(review);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Delete a review by id
    @DeleteMapping("/{id}")
    public ResponseEntity<ProductReviews> deleteReviewById(@PathVariable int id) {
        ProductReviews review = productReviewService.deleteReviewById(id);
        if (review != null) {
            return ResponseEntity.ok(review);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Delete all reviews of a particular user
    @DeleteMapping("/user/{userId}")
    public ResponseEntity<List<ProductReviews>> deleteReviewByUserId(@PathVariable int userId) {
        List<ProductReviews> reviews = productReviewService.deleteReviewByUserId(userId);
        if (reviews != null) {
            return ResponseEntity.ok(reviews);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Delete all reviews of a particular product
    @DeleteMapping("/product/{productId}")
    public ResponseEntity<List<ProductReviews>> deleteReviewByProductId(@PathVariable int productId) {
        List<ProductReviews> reviews = productReviewService.deleteReviewByProductId(productId);
        if (reviews != null) {
            return ResponseEntity.ok(reviews);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}