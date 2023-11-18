package com.truthwear.truthwear.service.interfaces;

import com.truthwear.truthwear.entity.ShoppingCart;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ShoppingCartService {
    List<ShoppingCart> getAllShoppingCart();

    ShoppingCart getShoppingCartById(int id);

    ShoppingCart getShoppingCartByUserId(int userId);

    ShoppingCart createShoppingCart(ShoppingCart shoppingCart);

    ShoppingCart updateShoppingCart(int id, int userId);

    ShoppingCart deleteShoppingCart(int id);
}
