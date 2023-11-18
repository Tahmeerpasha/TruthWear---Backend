package com.truthwear.truthwear.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private ProductCategory category;

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

    public Product(ProductCategory category, String productName, String description, String image, long stock, double price) {
        this.category = category;
        this.productName = productName;
        this.description = description;
        this.image = image;
        this.stock = stock;
        this.price = price;
    }
}
