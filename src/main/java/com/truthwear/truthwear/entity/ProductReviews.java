package com.truthwear.truthwear.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "product_review")
public class ProductReviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "ordered_product_id")
    private int orderedProductId;

    @Column(name = "rating_value")
    private int rating;

    @Column(name = "user_comment")
    private String review;

    public ProductReviews() {
    }

    public ProductReviews(int userId, int productId, int rating, String review) {
        this.userId = userId;
        this.orderedProductId = productId;
        this.rating = rating;
        this.review = review;
    }
}
