package com.truthwear.truthwear.service;

import com.truthwear.truthwear.entity.ShoppingCart;
import com.truthwear.truthwear.entity.SiteUser;
import com.truthwear.truthwear.repository.ShoppingCartRepository;
import com.truthwear.truthwear.repository.SiteUserRepository;
import com.truthwear.truthwear.service.interfaces.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final SiteUserRepository siteUserRepository;

    // Get all shopping carts
    @Override
    public List<ShoppingCart> getAllShoppingCart() {
        return shoppingCartRepository.findAll();
    }

    // Get a specific shopping cart by id
    @Override
    public ShoppingCart getShoppingCartById(int id) {
        Optional<ShoppingCart> shoppingCartOptional = shoppingCartRepository.findById(id);
        return shoppingCartOptional.orElse(null);
    }

    // Get a shopping cart by user id
    @Override
    public ShoppingCart getShoppingCartByUserId(int userId) {
        return shoppingCartRepository.findByUserId(userId);
    }

    // Create a new shopping cart
    @Override
    public ShoppingCart createShoppingCart(ShoppingCart shoppingCart) {
        return shoppingCartRepository.save(shoppingCart);
    }

    // Update an existing shopping cart
    @Override
    public ShoppingCart updateShoppingCart(int id, int userId) {
        Optional<ShoppingCart> shoppingCartOptional = shoppingCartRepository.findById(id);
        if (shoppingCartOptional.isEmpty()) {
            return null;
        }
        ShoppingCart shoppingCart = shoppingCartOptional.get();
        Optional<SiteUser> siteUserOptional = siteUserRepository.findById(userId);
        if (siteUserOptional.isEmpty()) {
            return null;
        }
        SiteUser siteUser = siteUserOptional.get();
        shoppingCart.setUser(siteUser);
        return shoppingCartRepository.save(shoppingCart);
    }

    // Delete a shopping cart by id
    @Override
    public ShoppingCart deleteShoppingCart(int id) {
        Optional<ShoppingCart> shoppingCartOptional = shoppingCartRepository.findById(id);
        if (shoppingCartOptional.isEmpty()) {
            return null;
        }
        ShoppingCart shoppingCart = shoppingCartOptional.get();
        shoppingCartRepository.delete(shoppingCart);
        return shoppingCart;
    }
}