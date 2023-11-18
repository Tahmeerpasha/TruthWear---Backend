package com.truthwear.truthwear.controller;

import com.truthwear.truthwear.entity.ShoppingCartItem;
import com.truthwear.truthwear.service.ShoppingCartItemServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/shopping-cart-items")
public class ShoppingCartItemController {

    private final ShoppingCartItemServiceImpl shoppingCartItemService;


    // Get all shopping cart items
    @GetMapping
    public ResponseEntity<List<ShoppingCartItem>> getAllShoppingCartItem() {
        try {
            List<ShoppingCartItem> shoppingCartItems = shoppingCartItemService.getAllShoppingCartItem();
            return ResponseEntity.ok(shoppingCartItems);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get all shopping cart items by cart id
    @GetMapping("/{cartId}")
    public ResponseEntity<List<ShoppingCartItem>> getAllShoppingCartItemByCartId(@PathVariable int cartId) {
        try {
            List<ShoppingCartItem> shoppingCartItems = shoppingCartItemService.getAllShoppingCartItemByCartId(cartId);
            return ResponseEntity.ok(shoppingCartItems);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Create a new shopping cart item
    @PostMapping
    public ResponseEntity<ShoppingCartItem> createShoppingCartItem(@RequestBody ShoppingCartItem shoppingCartItem) {
        try {
            ShoppingCartItem createdShoppingCartItem = shoppingCartItemService.createShoppingCartItem(shoppingCartItem);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdShoppingCartItem);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Update an existing shopping cart item
    @PutMapping("/{id}")
    public ResponseEntity<ShoppingCartItem> updateShoppingCartItem(@PathVariable int id, @RequestParam(name = "cartId", required = false) Integer cartId, @RequestParam(name = "productId", required = false) Integer productId, @RequestParam(name = "quantity", required = false) Integer quantity) {
        try {
            ShoppingCartItem updatedShoppingCartItem = shoppingCartItemService.updateShoppingCartItem(id, cartId, productId, quantity);
            return ResponseEntity.ok(updatedShoppingCartItem);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Delete a shopping cart item by id
    @DeleteMapping("/{id}")
    public ResponseEntity<ShoppingCartItem> deleteShoppingCartItem(@PathVariable int id) {
        try {
            ShoppingCartItem deletedShoppingCartItem = shoppingCartItemService.deleteShoppingCartItem(id);
            return ResponseEntity.ok(deletedShoppingCartItem);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Delete all shopping cart items by cart id
    @DeleteMapping("/cart/{cartId}")
    public ResponseEntity<List<ShoppingCartItem>> deleteShoppingCartItemsByCartId(@PathVariable int cartId) {
        try {
            List<ShoppingCartItem> deletedShoppingCartItems = shoppingCartItemService.deleteShoppingCartItemByCartId(cartId);
            return ResponseEntity.ok(deletedShoppingCartItems);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}