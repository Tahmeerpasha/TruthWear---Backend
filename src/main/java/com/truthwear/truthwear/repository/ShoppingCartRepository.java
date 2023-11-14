package com.truthwear.truthwear.repository;

import com.truthwear.truthwear.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Integer> {
    ShoppingCart findByUserId(int userId);
}
