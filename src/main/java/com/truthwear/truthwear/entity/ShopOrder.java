package com.truthwear.truthwear.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@Table(name = "shop_order")
public class ShopOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private SiteUser user;

    @Column(name = "order_date")
    private Timestamp orderDate;

    @ManyToOne
    @JoinColumn(name = "shipping_address", nullable = false)
    private Address shippingAddress;

    @ManyToOne
    @JoinColumn(name = "shipping_method", nullable = false)
    private ShippingMethod shippingMethod;

    @Column(name = "order_total")
    private BigDecimal orderTotal;

    @ManyToOne
    @JoinColumn(name = "order_status", nullable = false)
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    private OrderPaymentMethod orderPaymentMethod;

    public ShopOrder(SiteUser user, Timestamp orderDate, Address shippingAddress, ShippingMethod shippingMethod, BigDecimal orderTotal, OrderStatus orderStatus, OrderPaymentMethod orderPaymentMethod) {
        this.user = user;
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
        this.shippingMethod = shippingMethod;
        this.orderTotal = orderTotal;
        this.orderStatus = orderStatus;
        this.orderPaymentMethod = orderPaymentMethod;
    }
}
