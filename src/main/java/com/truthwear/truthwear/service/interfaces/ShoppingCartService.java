package com.truthwear.truthwear.service.interfaces;

import com.truthwear.truthwear.entity.ShoppingCart;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ShoppingCartService {
    ResponseEntity<List<ShoppingCart>> getAllShoppingCart();

    ResponseEntity<ShoppingCart> getShoppingCartById(int id);

    ResponseEntity<ShoppingCart> getShoppingCartByUserId(int userId);

    ResponseEntity<ShoppingCart> createShoppingCart(ShoppingCart shoppingCart);

    ResponseEntity<ShoppingCart> updateShoppingCart(int id, int userId);

    ResponseEntity<ShoppingCart> deleteShoppingCart(int id);
}
