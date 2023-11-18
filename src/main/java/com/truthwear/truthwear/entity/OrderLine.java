package com.truthwear.truthwear.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "order_line")
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private ShopOrder shopOrder;

    @Column(name = "qty")
    private int quantity;

    @Column(name = "price")
    private double price;

    public OrderLine(Product product, ShopOrder shopOrder, int quantity, double price) {
        this.product = product;
        this.shopOrder = shopOrder;
        this.quantity = quantity;
        this.price = price;
    }
}
