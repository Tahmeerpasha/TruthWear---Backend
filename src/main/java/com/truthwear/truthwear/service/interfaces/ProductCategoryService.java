package com.truthwear.truthwear.service.interfaces;

import com.truthwear.truthwear.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    List<ProductCategory> getAllProductCategories();

    ProductCategory createProductCategory(ProductCategory productCategory);

    ProductCategory getProductCategoryByName(String name);

    ProductCategory deleteProductCategory(int id);

    ProductCategory updateProductCategory(ProductCategory productCategory, int id);
}
