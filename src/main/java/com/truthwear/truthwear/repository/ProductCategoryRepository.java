package com.truthwear.truthwear.repository;

import com.truthwear.truthwear.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
    ProductCategory findByCategoryName(String name);
}
