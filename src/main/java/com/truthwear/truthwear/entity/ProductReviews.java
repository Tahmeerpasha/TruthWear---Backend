package com.truthwear.truthwear.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "product_review")
public class ProductReviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private SiteUser user;

    @ManyToOne
    @JoinColumn(name = "ordered_product_id", nullable = false)
    private OrderLine orderedProduct;

    @Column(name = "rating_value")
    private Integer rating;

    @Column(name = "user_comment")
    private String review;

    public ProductReviews(SiteUser user, OrderLine orderedProduct, int rating, String review) {
        this.user = user;
        this.orderedProduct = orderedProduct;
        this.rating = rating;
        this.review = review;
    }
}
