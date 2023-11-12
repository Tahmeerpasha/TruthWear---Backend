package com.truthwear.truthwear.controller;

import com.truthwear.truthwear.entity.ProductCategory;
import com.truthwear.truthwear.service.ProductCategoryServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductCategoryController {

    private final ProductCategoryServiceImpl productCategoryService;

    public ProductCategoryController(ProductCategoryServiceImpl productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @GetMapping("/product_categories")
    public List<ProductCategory> getProductCategories(){
        return productCategoryService.getAllProductCategories();
    }

    @GetMapping( value = "/product_category", params = "name")
    public ProductCategory getProductCategory(@RequestParam String name){return productCategoryService.getProductCategoryByName(name);}

    @PostMapping("/product_categories")
    public ProductCategory createProductCategory(@RequestBody ProductCategory productCategory){
        return productCategoryService.createProductCategory(productCategory);
    }

    @PutMapping("/product_categories/{id}")
    public ProductCategory updateProductCategory(@RequestBody ProductCategory productCategory, @PathVariable int id){
        return productCategoryService.updateProductCategory(productCategory,id);
    }
    @DeleteMapping(value = "/product_categories", params = "name")
    public ProductCategory deleteProductCategory(@RequestParam String name){
        return productCategoryService.deleteProductCategory(name);
    }
}
