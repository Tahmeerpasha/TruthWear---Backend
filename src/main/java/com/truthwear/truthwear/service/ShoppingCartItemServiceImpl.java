package com.truthwear.truthwear.service;

import com.truthwear.truthwear.entity.Product;
import com.truthwear.truthwear.entity.ShoppingCart;
import com.truthwear.truthwear.entity.ShoppingCartItem;
import com.truthwear.truthwear.repository.ProductRepository;
import com.truthwear.truthwear.repository.ShoppingCartItemRepository;
import com.truthwear.truthwear.repository.ShoppingCartRepository;
import com.truthwear.truthwear.service.interfaces.ShoppingCartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShoppingCartItemServiceImpl implements ShoppingCartItemService {

    private final ShoppingCartItemRepository shoppingCartItemRepository;
    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductRepository productRepository;

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
        if (cartId != null) {
            ShoppingCart shoppingCart = shoppingCartRepository.findById(cartId).get();
            shoppingCartItem.setCart(shoppingCart);
        }
        if (productId != null) {
            Product product = productRepository.findById(productId).get();
            shoppingCartItem.setProduct(product);
        }
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
