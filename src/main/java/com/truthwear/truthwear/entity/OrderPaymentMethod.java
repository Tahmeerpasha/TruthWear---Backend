package com.truthwear.truthwear.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "order_payment_method")
public class OrderPaymentMethod {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private ShopOrder shopOrder;

    @ManyToOne
    @JoinColumn(name = "user_payment_method_id", nullable = false)
    private UserPaymentMethod userPaymentMethod;


    public OrderPaymentMethod(ShopOrder shopOrder, UserPaymentMethod userPaymentMethod) {
        this.shopOrder = shopOrder;
        this.userPaymentMethod = userPaymentMethod;
    }
}
