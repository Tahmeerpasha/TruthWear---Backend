package com.truthwear.truthwear.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@Table(name = "shipping_method")
public class ShippingMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "shipping_method")
    private String shippingMethod;

    @Column(name = "price")
    private BigDecimal price;

    public ShippingMethod(String shippingMethod, BigDecimal price) {
        this.shippingMethod = shippingMethod;
        this.price = price;
    }

}
