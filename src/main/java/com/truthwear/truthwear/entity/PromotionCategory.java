package com.truthwear.truthwear.entity;

import jakarta.persistence.*;

@Entity
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(int promotionId) {
        this.promotionId = promotionId;
    }

    @Override
    public String toString() {
        return "PromotionCategory{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", promotionId=" + promotionId +
                '}';
    }
}
