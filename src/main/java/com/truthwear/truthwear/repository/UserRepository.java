package com.truthwear.truthwear.repository;

import com.truthwear.truthwear.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsByEmailId(String emailId);
}
