package com.truthwear.truthwear.service.interfaces;

import com.truthwear.truthwear.entity.ProductReviews;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductReviewService {


    List<ProductReviews> getAllReviews();

    ResponseEntity<ProductReviews> createReviews(ProductReviews productReviews);

    ResponseEntity<List<ProductReviews>> getProductReviewBasedOnUserId(int userId);

    ResponseEntity<List<ProductReviews>> getProductReviewBasedOnProductId(int productId);

    ResponseEntity<ProductReviews> updateReviews(int id,Integer ratingValue, String comments);

    ResponseEntity<ProductReviews> deleteReviewById(int id);

    ResponseEntity<List<ProductReviews>> deleteReviewByUserId(int userId);

    ResponseEntity<List<ProductReviews>> deleteReviewByProductId(int productId);

    ResponseEntity<ProductReviews> getProductReviewById(int id);
}
