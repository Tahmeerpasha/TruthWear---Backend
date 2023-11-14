package com.truthwear.truthwear.repository;

import com.truthwear.truthwear.entity.UserPaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserPaymentMethodRepository extends JpaRepository<UserPaymentMethod,Integer> {
    List<UserPaymentMethod> findAllByUserId(int userId);
}
