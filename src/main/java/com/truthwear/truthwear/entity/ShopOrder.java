package com.truthwear.truthwear.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;


@Entity
@Data
@Table(name = "shop_order")
public class ShopOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "order_date")
    private Timestamp orderDate;
    @Column(name = "shipping_address")
    private int shippingAddressId;
    @Column(name = "shipping_method")
    private int shippingMethodId;
    @Column(name = "order_total")
    private BigDecimal orderTotal;
    @Column(name = "order_status")
    private int orderStatusId;
    @Column(name = "payment_method_id")
    private int paymentMethodId;
    public ShopOrder() {
    }

    public ShopOrder(int userId, Timestamp orderDate, int shippingAddressId, int shippingMethodId, BigDecimal orderTotal, int orderStatusId, int orderPaymentMethodId) {
        this.userId = userId;
        this.orderDate = orderDate;
        this.shippingAddressId = shippingAddressId;
        this.shippingMethodId = shippingMethodId;
        this.orderTotal = orderTotal;
        this.orderStatusId = orderStatusId;
        this.paymentMethodId = orderPaymentMethodId;
    }
}
