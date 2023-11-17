package com.truthwear.truthwear.controller;

import com.truthwear.truthwear.entity.ShoppingCartItem;
import com.truthwear.truthwear.service.ShoppingCartItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class ShoppingCartItemController {
    private final ShoppingCartItemServiceImpl shoppingCartItemService;

    @Autowired
    public ShoppingCartItemController(ShoppingCartItemServiceImpl shoppingCartItemService) {
        this.shoppingCartItemService = shoppingCartItemService;
    }

    @GetMapping("shopping-cart-items")
    ResponseEntity<List<ShoppingCartItem>> getAllShoppingCartItem() {
        return shoppingCartItemService.getAllShoppingCartItem();
    }

    @GetMapping("shopping-cart-items/{cartId}")
    ResponseEntity<List<ShoppingCartItem>> getAllShoppingCartItemByCartId(@PathVariable int cartId) {
        return shoppingCartItemService.getAllShoppingCartItemByCartId(cartId);
    }

    @PostMapping("shopping-cart-items")
    ResponseEntity<ShoppingCartItem> createShoppingCartItem(@RequestBody ShoppingCartItem shoppingCartItem){
        return shoppingCartItemService.createShoppingCartItem(shoppingCartItem);
    }

    @PutMapping("shopping-cart-items/{id}")
    ResponseEntity<ShoppingCartItem> updateShoppingCartItem(@PathVariable int id,
                                                            @RequestParam(name = "cartId", required = false) Integer cartId,
                                                            @RequestParam(name = "productId", required = false) Integer productId,
                                                            @RequestParam(name = "quantity", required = false) Integer quantity
                                                            ){
        return shoppingCartItemService.updateShoppingCartItem(id,cartId,productId,quantity);
    }

    @DeleteMapping("shopping-cart-items/{id}")
    ResponseEntity<ShoppingCartItem> deleteShoppingCartItem(@PathVariable int id){
        return shoppingCartItemService.deleteShoppingCartItem(id);
    }

    @DeleteMapping("shopping-cart-items/cart/{cartId}")
    ResponseEntity<List<ShoppingCartItem>> deleteShoppingCartItemsByCartId(@PathVariable int cartId)
    {
        return shoppingCartItemService.deleteShoppingCartItemByCartId(cartId);
    }
}