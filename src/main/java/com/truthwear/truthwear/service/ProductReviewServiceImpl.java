package com.truthwear.truthwear.service;

import com.truthwear.truthwear.entity.ProductReviews;
import com.truthwear.truthwear.repository.ProductReviewsRepository;
import com.truthwear.truthwear.service.interfaces.ProductReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductReviewServiceImpl implements ProductReviewService {

    private final ProductReviewsRepository productReviewsRepository;

    // Get all reviews
    @Override
    public List<ProductReviews> getAllReviews() {
        return productReviewsRepository.findAll();
    }

    // Create a new review
    @Override
    public ProductReviews createReviews(ProductReviews productReviews) {
        return productReviewsRepository.save(productReviews);
    }

    // Get reviews based on user ID
    @Override
    public List<ProductReviews> getProductReviewBasedOnUserId(int userId) {
        return productReviewsRepository.findByUserId(userId);
    }

    // Get Reviews based on product ID
    @Override
    public List<ProductReviews> getProductReviewBasedOnProductId(int productId) {
        return productReviewsRepository.findByOrderedProductId(productId);
    }

    // Update an existing review
    @Override
    public ProductReviews updateReviews(int id, Integer ratingValue, String comments) {
        Optional<ProductReviews> productReviewsOptional = productReviewsRepository.findById(id);
        if (productReviewsOptional.isEmpty()) {
            return null;
        }
        ProductReviews productReviews = productReviewsOptional.get();
        if (ratingValue != null && ratingValue >= 0 && ratingValue <= 10 && comments != null && !comments.isEmpty()) {
            productReviews.setRating(ratingValue);
            productReviews.setReview(comments);
        } else if (ratingValue != null && ratingValue >= 0 && ratingValue <= 10) {
            productReviews.setRating(ratingValue);
        } else if (comments != null && !comments.isEmpty()) {
            productReviews.setReview(comments);
        }
        return productReviewsRepository.save(productReviews);
    }

    // Delete a review by id
    @Override
    public ProductReviews deleteReviewById(int id) {
        Optional<ProductReviews> productReviewsOptional = productReviewsRepository.findById(id);
        if (productReviewsOptional.isEmpty()) {
            return null;
        }
        ProductReviews productReviews = productReviewsOptional.get();
        productReviewsRepository.delete(productReviews);
        return productReviews;
    }

    // Delete all reviews of a particular user
    @Override
    public List<ProductReviews> deleteReviewByUserId(int userId) {
        List<ProductReviews> productReviews = productReviewsRepository.findByUserId(userId);
        if (productReviews != null && !productReviews.isEmpty()) {
            productReviewsRepository.deleteAll(productReviews);
        }
        return productReviews;
    }

    // Delete all reviews of a particular product
    @Override
    public List<ProductReviews> deleteReviewByProductId(int productId) {
        List<ProductReviews> productReviews = productReviewsRepository.findByOrderedProductId(productId);
        if (productReviews != null && !productReviews.isEmpty()) {
            productReviewsRepository.deleteAll(productReviews);
        }
        return productReviews;
    }

    // Get a specific review by id
    @Override
    public ProductReviews getProductReviewById(int id) {
        Optional<ProductReviews> productReviewsOptional = productReviewsRepository.findById(id);
        return productReviewsOptional.orElse(null);
    }
}