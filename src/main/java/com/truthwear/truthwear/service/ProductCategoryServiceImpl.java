package com.truthwear.truthwear.service;


import com.truthwear.truthwear.entity.ProductCategory;
import com.truthwear.truthwear.repository.ProductCategoryRepository;
import com.truthwear.truthwear.service.interfaces.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private ProductCategoryRepository productCategoryRepository;

    public ProductCategoryServiceImpl() {
    }

    @Autowired
    public ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    @Override
    public List<ProductCategory> getAllProductCategories() {
        return productCategoryRepository.findAll();
    }

    @Override
    public ProductCategory createProductCategory(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }

    @Override
    public ProductCategory getProductCategoryByName(String name) {
        return productCategoryRepository.findByCategoryName(name);
    }

    @Override
    public ProductCategory deleteProductCategory(String name) {
        ProductCategory productCategory = productCategoryRepository.findByCategoryName(name);
        if (productCategory == null)throw new NoSuchElementException("Product category not found");
        else productCategoryRepository.delete(productCategory);
        return productCategory;
    }

    @Override
    public ProductCategory updateProductCategory(ProductCategory productCategory, int id) {
        ProductCategory productCategory1 = productCategoryRepository.findById(id).orElseThrow(()->new NoSuchElementException("Product category not found"));
        productCategory1.setCategoryName(productCategory.getCategoryName());
        productCategoryRepository.save(productCategory1);
        return productCategory1;
    }
}
