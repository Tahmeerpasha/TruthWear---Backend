package com.truthwear.truthwear.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
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
}
