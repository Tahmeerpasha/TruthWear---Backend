package com.truthwear.truthwear.service.interfaces;

import com.truthwear.truthwear.entity.ShoppingCartItem;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ShoppingCartItemService {
    List<ShoppingCartItem> getAllShoppingCartItem();

    List<ShoppingCartItem> getAllShoppingCartItemByCartId(int cartId);

    ShoppingCartItem createShoppingCartItem(ShoppingCartItem shoppingCartItem);

    ShoppingCartItem updateShoppingCartItem(int id, Integer cartId, Integer productId, Integer quantity);

    ShoppingCartItem deleteShoppingCartItem(int id);

    List<ShoppingCartItem> deleteShoppingCartItemByCartId(int cartId);
}
