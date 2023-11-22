package com.truthwear.truthwear.service;

import com.truthwear.truthwear.entity.ProductCategory;
import com.truthwear.truthwear.repository.ProductCategoryRepository;
import com.truthwear.truthwear.service.interfaces.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
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
        if(productCategory.getCategoryName() == null || productCategory.getCategoryName().isEmpty()){
            throw new RuntimeException("Product category name cannot be empty");
        }
        if(productCategoryRepository.findByCategoryName(productCategory.getCategoryName()) != null){
            throw new RuntimeException("Product category already exists");
        }
        return productCategoryRepository.save(productCategory);
    }

    // Get a product category by name
    @Override
    public ProductCategory getProductCategoryByName(String name) {
        return productCategoryRepository.findByCategoryName(name);
    }

    // Delete a product category by name
    @Override
    public ProductCategory deleteProductCategory(int id) {
        ProductCategory productCategory = productCategoryRepository.findById(id).get();
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