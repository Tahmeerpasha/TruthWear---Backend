package com.truthwear.truthwear.repository;

import com.truthwear.truthwear.entity.Product;
import com.truthwear.truthwear.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findByProductNameContainingAndCategoryAndPriceBetween(String productName, ProductCategory category, double price, double price2);

    List<Product> findByProductNameContainingAndCategory(String productName, ProductCategory category);

    List<Product> findByProductNameContainingAndPriceBetween(String productName, double minPrice, double maxPrice);

    List<Product> findByCategoryAndPriceBetween(ProductCategory category, double price, double price2);

    List<Product> findByProductNameContaining(String name);

    List<Product> findByCategory(ProductCategory category);

    List<Product> findByPriceBetween(double minPrice, double maxPrice);
}
