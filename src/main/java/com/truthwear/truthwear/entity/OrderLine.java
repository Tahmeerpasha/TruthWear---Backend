package com.truthwear.truthwear.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "order_line")
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "product_id")
    private int productId;
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "qty")
    private int quantity;

    @Column(name = "price")
    private double price;

    public OrderLine() {
    }

    public OrderLine(int productId, int orderId, int quantity, double price) {
        this.productId = productId;
        this.orderId = orderId;
        this.quantity = quantity;
        this.price = price;
    }
}
