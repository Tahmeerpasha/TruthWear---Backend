package com.truthwear.truthwear.repository;

import com.truthwear.truthwear.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findByProductNameContainingAndCategoryIdAndPriceBetween(String name, int id, double minPrice, double maxPrice);

    List<Product> findByProductNameContainingAndCategoryId(String name, int id);

    List<Product> findByProductNameContainingAndPriceBetween(String name, double minPrice, double maxPrice);

    List<Product> findByCategoryIdAndPriceBetween(int id, double minPrice, double maxPrice);

    List<Product> findByProductNameContaining(String name);

    List<Product> findByCategoryId(int id);

    List<Product> findByPriceBetween(double minPrice, double maxPrice);
}
