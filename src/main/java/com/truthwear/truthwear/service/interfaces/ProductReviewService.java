package com.truthwear.truthwear.service.interfaces;

import com.truthwear.truthwear.entity.ProductReviews;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductReviewService {


    List<ProductReviews> getAllReviews();

    ProductReviews createReviews(ProductReviews productReviews);

    List<ProductReviews> getProductReviewBasedOnUserId(int userId);

    List<ProductReviews> getProductReviewBasedOnProductId(int productId);

    ProductReviews updateReviews(int id,Integer ratingValue, String comments);

    ProductReviews deleteReviewById(int id);

    List<ProductReviews> deleteReviewByUserId(int userId);

    List<ProductReviews> deleteReviewByProductId(int productId);

    ProductReviews getProductReviewById(int id);
}
