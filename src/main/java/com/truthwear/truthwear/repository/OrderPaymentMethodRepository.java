package com.truthwear.truthwear.repository;

import com.truthwear.truthwear.entity.OrderPaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderPaymentMethodRepository extends JpaRepository<OrderPaymentMethod,Integer> {
}
