package com.truthwear.truthwear.repository;

import com.truthwear.truthwear.entity.ProductReviews;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductReviewsRepository extends JpaRepository<com.truthwear.truthwear.entity.ProductReviews,Integer> {
    List<ProductReviews> findByUserId(int userId);

    List<ProductReviews> findByProductId(int productId);
}
