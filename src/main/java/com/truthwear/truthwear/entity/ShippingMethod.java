package com.truthwear.truthwear.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
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

    public ShippingMethod() {
    }

    public ShippingMethod(String shippingMethod, BigDecimal price) {
        this.shippingMethod = shippingMethod;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ShippingMethod{" +
                "id=" + id +
                ", shippingMethod='" + shippingMethod + '\'' +
                ", price=" + price +
                '}';
    }
}
