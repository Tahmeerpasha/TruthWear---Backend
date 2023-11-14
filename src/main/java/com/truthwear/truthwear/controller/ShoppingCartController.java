package com.truthwear.truthwear.controller;

import com.truthwear.truthwear.entity.ShoppingCart;
import com.truthwear.truthwear.service.ShoppingCartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ShoppingCartController {
    private final ShoppingCartServiceImpl shoppingCartService;

    @Autowired
    public ShoppingCartController(ShoppingCartServiceImpl shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/shopping_carts")
    ResponseEntity<List<ShoppingCart>> getAllShoppingCart(){
        return shoppingCartService.getAllShoppingCart();
    }

    @GetMapping("/shopping_carts/{id}")
    ResponseEntity<ShoppingCart> getShoppingCartById(@PathVariable int id){
        return shoppingCartService.getShoppingCartById(id);
    }

    @GetMapping("/shopping_carts/user/{userId}")
    ResponseEntity<ShoppingCart> getShoppingCartByUserId(@PathVariable int userId){
        return shoppingCartService.getShoppingCartByUserId(userId);
    }

    @PostMapping("/shopping_carts")
    ResponseEntity<ShoppingCart> createShoppingCart(@RequestBody ShoppingCart shoppingCart){
        return shoppingCartService.createShoppingCart(shoppingCart);
    }

    @PutMapping("/shopping_carts/{id}")
    ResponseEntity<ShoppingCart> updateShoppingCart(@RequestParam(name = "userId", required = false) int userId, @PathVariable int id){
        return shoppingCartService.updateShoppingCart(id,userId);
    }

    @DeleteMapping("/shopping_carts/{id}")
    ResponseEntity<ShoppingCart> deleteShoppingCart(@PathVariable int id){
        return shoppingCartService.deleteShoppingCart(id);
    }
}
