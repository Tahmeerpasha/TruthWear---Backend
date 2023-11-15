package com.truthwear.truthwear.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "promotion")
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "promotion_name")
    private String promotionName;

    @Column(name = "promotion_description")
    private String promotionDescription;

    @Column(name = "discount_rate")
    private int discountRate;

    @Column(name = "start_date")
    private Timestamp startDate;

    @Column(name = "end_date")
    private Timestamp endDate;

    public Promotion() {
    }

    public Promotion(String promotionName, String promotionDescription, int discountRate, Timestamp startDate, Timestamp endDate) {
        this.promotionName = promotionName;
        this.promotionDescription = promotionDescription;
        this.discountRate = discountRate;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
