package com.truthwear.truthwear.service;

import com.truthwear.truthwear.entity.ShoppingCartItem;
import com.truthwear.truthwear.repository.ShoppingCartItemRepository;
import com.truthwear.truthwear.service.interfaces.ShoppingCartItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartItemServiceImpl implements ShoppingCartItemService {

    private final ShoppingCartItemRepository shoppingCartItemRepository;
    public ShoppingCartItemServiceImpl(ShoppingCartItemRepository shoppingCartItemRepository, ShoppingCartItemRepository shoppingCartItemRepository1) {
        this.shoppingCartItemRepository = shoppingCartItemRepository1;
    }

    @Override
    public ResponseEntity<List<ShoppingCartItem>> getAllShoppingCartItem() {
        return ResponseEntity.ok(shoppingCartItemRepository.findAll());
    }

    @Override
    public ResponseEntity<List<ShoppingCartItem>> getAllShoppingCartItemByCartId(int cartId) {
        return ResponseEntity.ok(shoppingCartItemRepository.findAllByCartId(cartId));
    }

    @Override
    public ResponseEntity<ShoppingCartItem> createShoppingCartItem(ShoppingCartItem shoppingCartItem) {
        return ResponseEntity.ok(shoppingCartItemRepository.save(shoppingCartItem));
    }

    @Override
    public ResponseEntity<ShoppingCartItem> updateShoppingCartItem(int id, Integer cartId, Integer productId, Integer quantity) {
        ShoppingCartItem shoppingCartItem = shoppingCartItemRepository.findById(id).get();
        if (cartId != null)
            shoppingCartItem.setCartId(cartId);
        if (productId != null)
            shoppingCartItem.setProductId(productId);
        if (quantity != null)
            shoppingCartItem.setQuantity(quantity);

        return ResponseEntity.ok(shoppingCartItemRepository.save(shoppingCartItem));
    }

    @Override
    public ResponseEntity<ShoppingCartItem> deleteShoppingCartItem(int id) {
        ShoppingCartItem shoppingCartItem = shoppingCartItemRepository.findById(id).get();
        shoppingCartItemRepository.delete(shoppingCartItem);
        return ResponseEntity.ok(shoppingCartItem);
    }

    @Override
    public ResponseEntity<List<ShoppingCartItem>> deleteShoppingCartItemByCartId(int cartId) {
        List<ShoppingCartItem> shoppingCartItem = shoppingCartItemRepository.findAllByCartId(cartId);
        shoppingCartItemRepository.deleteAll(shoppingCartItem);
        return ResponseEntity.ok(shoppingCartItem);
    }
}
