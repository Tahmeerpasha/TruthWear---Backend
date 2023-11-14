package com.truthwear.truthwear.repository;

import com.truthwear.truthwear.entity.ShopOrder;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopOrderRepository extends JpaRepository<ShopOrder, Integer> {
    List<ShopOrder> findAllByUserId(int userId);
}
