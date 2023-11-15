package com.truthwear.truthwear.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "promotion_category")
public class PromotionCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "promotion_id")
    private int promotionId;

    public PromotionCategory() {
    }

    public PromotionCategory(int categoryId, int promotionId) {
        this.categoryId = categoryId;
        this.promotionId = promotionId;
    }
}
