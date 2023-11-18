package com.truthwear.truthwear.service;

import com.truthwear.truthwear.entity.ProductCategory;
import com.truthwear.truthwear.repository.ProductCategoryRepository;
import com.truthwear.truthwear.service.interfaces.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    // Get all product categories
    @Override
    public List<ProductCategory> getAllProductCategories() {
        return productCategoryRepository.findAll();
    }

    // Create a new product category
    @Override
    public ProductCategory createProductCategory(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }

    // Get a product category by name
    @Override
    public ProductCategory getProductCategoryByName(String name) {
        return productCategoryRepository.findByCategoryName(name);
    }

    // Delete a product category by name
    @Override
    public ProductCategory deleteProductCategory(String name) {
        ProductCategory productCategory = productCategoryRepository.findByCategoryName(name);
        if (productCategory != null) {
            productCategoryRepository.delete(productCategory);
        }
        return productCategory;
    }

    // Update an existing product category
    @Override
    public ProductCategory updateProductCategory(ProductCategory productCategory, int id) {
        Optional<ProductCategory> productCategoryOptional = productCategoryRepository.findById(id);
        if (productCategoryOptional.isEmpty()) {
            return null;
        }
        ProductCategory existingProductCategory = productCategoryOptional.get();
        existingProductCategory.setCategoryName(productCategory.getCategoryName());
        return productCategoryRepository.save(existingProductCategory);
    }
}