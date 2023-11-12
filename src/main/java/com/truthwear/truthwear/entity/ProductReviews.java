package com.truthwear.truthwear.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_review")
public class ProductReviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "ordered_product_id")
    private int productId;

    @Column(name = "rating_value")
    private int rating;

    @Column(name = "user_comment")
    private String review;

    public ProductReviews() {
    }

    public ProductReviews(int userId, int productId, int rating, String review) {
        this.userId = userId;
        this.productId = productId;
        this.rating = rating;
        this.review = review;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "Reviews{" +
                "id=" + id +
                ", userId=" + userId +
                ", productId=" + productId +
                ", rating=" + rating +
                ", review='" + review + '\'' +
                '}';
    }
}
