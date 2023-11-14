package com.truthwear.truthwear.controller;

import com.truthwear.truthwear.entity.ShoppingCartItem;
import com.truthwear.truthwear.service.ShoppingCartItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ShoppingCartItemController {
    private final ShoppingCartItemServiceImpl shoppingCartItemService;

    @Autowired
    public ShoppingCartItemController(ShoppingCartItemServiceImpl shoppingCartItemService) {
        this.shoppingCartItemService = shoppingCartItemService;
    }

    @GetMapping("/shopping_cart_items")
    ResponseEntity<List<ShoppingCartItem>> getAllShoppingCartItem() {
        return shoppingCartItemService.getAllShoppingCartItem();
    }

    @GetMapping("/shopping_cart_items/{cartId}")
    ResponseEntity<List<ShoppingCartItem>> getAllShoppingCartItemByCartId(@PathVariable int cartId) {
        return shoppingCartItemService.getAllShoppingCartItemByCartId(cartId);
    }

    @PostMapping("/shopping_cart_items")
    ResponseEntity<ShoppingCartItem> createShoppingCartItem(@RequestBody ShoppingCartItem shoppingCartItem){
        return shoppingCartItemService.createShoppingCartItem(shoppingCartItem);
    }

    @PutMapping("/shopping_cart_items/{id}")
    ResponseEntity<ShoppingCartItem> updateShoppingCartItem(@PathVariable int id,
                                                            @RequestParam(name = "cartId", required = false) Integer cartId,
                                                            @RequestParam(name = "productId", required = false) Integer productId,
                                                            @RequestParam(name = "quantity", required = false) Integer quantity
                                                            ){
        return shoppingCartItemService.updateShoppingCartItem(id,cartId,productId,quantity);
    }

    @DeleteMapping("/shopping_cart_items/{id}")
    ResponseEntity<ShoppingCartItem> deleteShoppingCartItem(@PathVariable int id){
        return shoppingCartItemService.deleteShoppingCartItem(id);
    }

    @DeleteMapping("/shopping_cart_items/cart/{cartId}")
    ResponseEntity<List<ShoppingCartItem>> deleteShoppingCartItemsByCartId(@PathVariable int cartId)
    {
        return shoppingCartItemService.deleteShoppingCartItemByCartId(cartId);
    }
}