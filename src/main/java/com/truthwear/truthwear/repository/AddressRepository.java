package com.truthwear.truthwear.repository;

import com.truthwear.truthwear.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    Optional<Address> findById(Long id);
}
