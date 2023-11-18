package com.truthwear.truthwear.controller;

import com.truthwear.truthwear.entity.ShoppingCart;
import com.truthwear.truthwear.service.ShoppingCartServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/shopping-carts")
public class ShoppingCartController {

    private final ShoppingCartServiceImpl shoppingCartService;

    // Get all shopping carts
    @GetMapping
    public ResponseEntity<List<ShoppingCart>> getAllShoppingCart() {
        try {
            List<ShoppingCart> shoppingCarts = shoppingCartService.getAllShoppingCart();
            return ResponseEntity.ok(shoppingCarts);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get a specific shopping cart by id
    @GetMapping("/{id}")
    public ResponseEntity<ShoppingCart> getShoppingCartById(@PathVariable int id) {
        try {
            ShoppingCart shoppingCart = shoppingCartService.getShoppingCartById(id);
            return ResponseEntity.ok(shoppingCart);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get a shopping cart by user id
    @GetMapping("/user/{userId}")
    public ResponseEntity<ShoppingCart> getShoppingCartByUserId(@PathVariable int userId) {
        try {
            ShoppingCart shoppingCart = shoppingCartService.getShoppingCartByUserId(userId);
            return ResponseEntity.ok(shoppingCart);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Create a new shopping cart
    @PostMapping
    public ResponseEntity<ShoppingCart> createShoppingCart(@RequestBody ShoppingCart shoppingCart) {
        try {
            ShoppingCart createdShoppingCart = shoppingCartService.createShoppingCart(shoppingCart);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdShoppingCart);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Update an existing shopping cart
    @PutMapping("/{id}")
    public ResponseEntity<ShoppingCart> updateShoppingCart(@PathVariable int id, @RequestParam(name = "userId", required = false) Integer userId) {
        try {
            ShoppingCart updatedShoppingCart = shoppingCartService.updateShoppingCart(id, userId);
            return ResponseEntity.ok(updatedShoppingCart);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Delete a shopping cart by id
    @DeleteMapping("/{id}")
    public ResponseEntity<ShoppingCart> deleteShoppingCart(@PathVariable int id) {
        try {
            ShoppingCart deletedShoppingCart = shoppingCartService.deleteShoppingCart(id);
            return ResponseEntity.ok(deletedShoppingCart);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}