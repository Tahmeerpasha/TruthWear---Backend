package com.truthwear.truthwear.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "shopping_cart_item")
public class ShoppingCartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "cart_id")
    private int cartId;
    @Column(name = "product_id")
    private int productId;
    @Column(name = "qty")
    private int quantity;

    public ShoppingCartItem() {
    }

    public ShoppingCartItem(int cartId, int productId, int quantity) {
        this.cartId = cartId;
        this.productId = productId;
        this.quantity = quantity;
    }
}
