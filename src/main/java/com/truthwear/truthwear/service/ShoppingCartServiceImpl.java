package com.truthwear.truthwear.service;

import com.truthwear.truthwear.entity.ShoppingCart;
import com.truthwear.truthwear.entity.SiteUser;
import com.truthwear.truthwear.repository.ShoppingCartRepository;
import com.truthwear.truthwear.repository.SiteUserRepository;
import com.truthwear.truthwear.service.interfaces.ShoppingCartService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final SiteUserRepository siteUserRepository;

    @Override
    public ResponseEntity<List<ShoppingCart>> getAllShoppingCart() {
        return ResponseEntity.ok(shoppingCartRepository.findAll());
    }

    @Override
    public ResponseEntity<ShoppingCart> getShoppingCartById(int id) {
        return ResponseEntity.ok(shoppingCartRepository.findById(id).get());
    }

    @Override
    public ResponseEntity<ShoppingCart> getShoppingCartByUserId(int userId) {
        return ResponseEntity.ok(shoppingCartRepository.findByUserId(userId));
    }

    @Override
    public ResponseEntity<ShoppingCart> createShoppingCart(ShoppingCart shoppingCart) {
        return ResponseEntity.ok(shoppingCartRepository.save(shoppingCart));
    }

    @Override
    public ResponseEntity<ShoppingCart> updateShoppingCart(int id, int userId) {
        ShoppingCart shoppingCart = shoppingCartRepository.findById(id).get();
        SiteUser siteUser = siteUserRepository.findById(userId).get();
        shoppingCart.setUser(siteUser);
        if (userId != 0)return ResponseEntity.ok(shoppingCartRepository.save(shoppingCart));
        else return ResponseEntity.internalServerError().build();
    }

    @Override
    public ResponseEntity<ShoppingCart> deleteShoppingCart(int id) {
        ShoppingCart shoppingCart = shoppingCartRepository.findById(id).get();
        shoppingCartRepository.delete(shoppingCart);
        return ResponseEntity.ok(shoppingCart);
    }

}
