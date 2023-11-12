package com.truthwear.truthwear.repository;

import com.truthwear.truthwear.entity.User;
import com.truthwear.truthwear.entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAddressRepository extends JpaRepository<UserAddress, Integer> {
    List<UserAddress> findByUserId(int id);

    UserAddress findByAddressId(int id);
}
