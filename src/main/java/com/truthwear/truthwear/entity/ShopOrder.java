package com.truthwear.truthwear.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;


@Entity
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public int getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(int paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public int getShippingAddressId() {
        return shippingAddressId;
    }

    public void setShippingAddressId(int shippingAddressId) {
        this.shippingAddressId = shippingAddressId;
    }

    public int getShippingMethodId() {
        return shippingMethodId;
    }

    public void setShippingMethodId(int shippingMethodId) {
        this.shippingMethodId = shippingMethodId;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }

    public int getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(int orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    @Override
    public String toString() {
        return "ShopOrder{" +
                "id=" + id +
                ", userId=" + userId +
                ", orderDate=" + orderDate +
                ", shippingAddressId=" + shippingAddressId +
                ", shippingMethodId=" + shippingMethodId +
                ", orderTotal=" + orderTotal +
                ", orderStatusId=" + orderStatusId +
                ", orderPaymentMethodId=" + paymentMethodId +
                '}';
    }
}
