package com.truthwear.truthwear.controller;

import com.truthwear.truthwear.entity.ProductCategory;
import com.truthwear.truthwear.service.ProductCategoryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product-categories")
public class ProductCategoryController {

    private final ProductCategoryServiceImpl productCategoryService;

    public ProductCategoryController(ProductCategoryServiceImpl productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    // Get all product categories
    @GetMapping
    public ResponseEntity<List<ProductCategory>> getProductCategories(){
        try {
            List<ProductCategory> productCategories = productCategoryService.getAllProductCategories();
            return ResponseEntity.ok(productCategories);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get a specific product category by name
    @GetMapping("/{name}")
    public ResponseEntity<ProductCategory> getProductCategory(@PathVariable String name){
        try {
            ProductCategory productCategory = productCategoryService.getProductCategoryByName(name);
            return ResponseEntity.ok(productCategory);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Create a new product category
    @PostMapping
    public ResponseEntity<ProductCategory> createProductCategory(@RequestBody ProductCategory productCategory){
        try {
            ProductCategory createdProductCategory = productCategoryService.createProductCategory(productCategory);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdProductCategory);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Update an existing product category
    @PutMapping("/{id}")
    public ResponseEntity<ProductCategory> updateProductCategory(@RequestBody ProductCategory productCategory, @PathVariable int id){
        try {
            ProductCategory updatedProductCategory = productCategoryService.updateProductCategory(productCategory, id);
            return ResponseEntity.ok(updatedProductCategory);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Delete a product category by name
    @DeleteMapping("/{name}")
    public ResponseEntity<ProductCategory> deleteProductCategory(@PathVariable String name){
        try {
            ProductCategory deletedProductCategory = productCategoryService.deleteProductCategory(name);
            return ResponseEntity.ok(deletedProductCategory);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}