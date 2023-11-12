package com.truthwear.truthwear.repository;

import com.truthwear.truthwear.entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine,Integer> {
}
