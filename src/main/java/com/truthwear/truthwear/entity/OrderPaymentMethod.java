package com.truthwear.truthwear.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "order_payment_method")
public class OrderPaymentMethod {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "order_id")
    private int orderId;
    @Column(name = "user_payment_method_id")
    private int userPaymentMethodId;

    public OrderPaymentMethod() {
    }

    public OrderPaymentMethod(int orderId, int userPaymentMethodId) {
        this.orderId = orderId;
        this.userPaymentMethodId = userPaymentMethodId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserPaymentMethodId() {
        return userPaymentMethodId;
    }

    public void setUserPaymentMethodId(int userPaymentMethodId) {
        this.userPaymentMethodId = userPaymentMethodId;
    }

    @Override
    public String toString() {
        return "OrderPaymentMethod{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", userPaymentMethodId=" + userPaymentMethodId +
                '}';
    }
}
