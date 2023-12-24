package com.truthwear.truthwear.repository;

import com.truthwear.truthwear.entity.ShoppingCartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoppingCartItemRepository extends JpaRepository<ShoppingCartItem,Integer> {
    List<ShoppingCartItem> findAllByCartId(int cartId);

    ShoppingCartItem findByCartIdAndProductId(int id, int id1);
}
