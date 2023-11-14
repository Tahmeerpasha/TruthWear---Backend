package com.truthwear.truthwear.service.interfaces;

import com.truthwear.truthwear.entity.ShoppingCartItem;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ShoppingCartItemService {
    ResponseEntity<List<ShoppingCartItem>> getAllShoppingCartItem();

    ResponseEntity<List<ShoppingCartItem>> getAllShoppingCartItemByCartId(int cartId);

    ResponseEntity<ShoppingCartItem> createShoppingCartItem(ShoppingCartItem shoppingCartItem);

    ResponseEntity<ShoppingCartItem> updateShoppingCartItem(int id, Integer cartId, Integer productId, Integer quantity);

    ResponseEntity<ShoppingCartItem> deleteShoppingCartItem(int id);

    ResponseEntity<List<ShoppingCartItem>> deleteShoppingCartItemByCartId(int cartId);
}
