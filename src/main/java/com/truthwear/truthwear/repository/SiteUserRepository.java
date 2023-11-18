package com.truthwear.truthwear.repository;

import com.truthwear.truthwear.entity.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;
import java.util.Optional;

public interface SiteUserRepository extends JpaRepository<SiteUser,Integer> {
    boolean existsByEmailId(String emailId);

    Optional<SiteUser> findByEmailId(String emailId);

    Optional<SiteUser> findById(Long id);
}
