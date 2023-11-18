package com.truthwear.truthwear.service;

import com.truthwear.truthwear.entity.Product;
import com.truthwear.truthwear.entity.ShoppingCart;
import com.truthwear.truthwear.entity.ShoppingCartItem;
import com.truthwear.truthwear.repository.ProductRepository;
import com.truthwear.truthwear.repository.ShoppingCartItemRepository;
import com.truthwear.truthwear.repository.ShoppingCartRepository;
import com.truthwear.truthwear.service.interfaces.ShoppingCartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShoppingCartItemServiceImpl implements ShoppingCartItemService {

    private final ShoppingCartItemRepository shoppingCartItemRepository;
    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductRepository productRepository;

    // Get all shopping cart items
    @Override
    public List<ShoppingCartItem> getAllShoppingCartItem() {
        return shoppingCartItemRepository.findAll();
    }

    // Get all shopping cart items by cart id
    @Override
    public List<ShoppingCartItem> getAllShoppingCartItemByCartId(int cartId) {
        return shoppingCartItemRepository.findAllByCartId(cartId);
    }

    // Create a new shopping cart item
    @Override
    public ShoppingCartItem createShoppingCartItem(ShoppingCartItem shoppingCartItem) {
        return shoppingCartItemRepository.save(shoppingCartItem);
    }

    // Update an existing shopping cart item
    @Override
    public ShoppingCartItem updateShoppingCartItem(int id, Integer cartId, Integer productId, Integer quantity) {
        Optional<ShoppingCartItem> shoppingCartItemOptional = shoppingCartItemRepository.findById(id);
        if (shoppingCartItemOptional.isEmpty()) {
            return null;
        }
        ShoppingCartItem shoppingCartItem = shoppingCartItemOptional.get();
        if (cartId != null) {
            Optional<ShoppingCart> shoppingCartOptional = shoppingCartRepository.findById(cartId);
            shoppingCartOptional.ifPresent(shoppingCartItem::setCart);
        }
        if (productId != null) {
            Optional<Product> productOptional = productRepository.findById(productId);
            productOptional.ifPresent(shoppingCartItem::setProduct);
        }
        if (quantity != null) {
            shoppingCartItem.setQuantity(quantity);
        }
        return shoppingCartItemRepository.save(shoppingCartItem);
    }

    // Delete a shopping cart item by id
    @Override
    public ShoppingCartItem deleteShoppingCartItem(int id) {
        Optional<ShoppingCartItem> shoppingCartItemOptional = shoppingCartItemRepository.findById(id);
        if (shoppingCartItemOptional.isEmpty()) {
            return null;
        }
        ShoppingCartItem shoppingCartItem = shoppingCartItemOptional.get();
        shoppingCartItemRepository.delete(shoppingCartItem);
        return shoppingCartItem;
    }

    // Delete all shopping cart items by cart id
    @Override
    public List<ShoppingCartItem> deleteShoppingCartItemByCartId(int cartId) {
        List<ShoppingCartItem> shoppingCartItem = shoppingCartItemRepository.findAllByCartId(cartId);
        if (shoppingCartItem != null && !shoppingCartItem.isEmpty()) {
            shoppingCartItemRepository.deleteAll(shoppingCartItem);
        }
        return shoppingCartItem;
    }
}