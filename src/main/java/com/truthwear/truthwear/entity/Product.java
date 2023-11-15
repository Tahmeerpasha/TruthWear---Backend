package com.truthwear.truthwear.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_description")
    private String description;

    @Column(name = "product_image")
    private String image;

    @Column(name = "stock")
    private long stock;

    @Column(name = "price")
    private double price;

    public Product() {
    }

    public Product(int categoryId, String productName, String description, String image, long stock, double price) {
        this.categoryId = categoryId;
        this.productName = productName;
        this.description = description;
        this.image = image;
        this.stock = stock;
        this.price = price;
    }
}
