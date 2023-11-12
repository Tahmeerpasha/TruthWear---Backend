package com.truthwear.truthwear.controller;

import com.truthwear.truthwear.entity.Product;
import com.truthwear.truthwear.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductServiceImpl productService;

    @Autowired
    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Optional<Product> getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PostMapping("/products/upload")
    public ResponseEntity<Product> createProduct(@RequestParam("categoryName") String categoryName,
                                                 @RequestParam("productName") String productName,
                                                 @RequestParam("productDescription") String productDescription,
                                                 @RequestParam("image")MultipartFile image,
                                                 @RequestParam("stock") long stock,
                                                 @RequestParam("price") double price
                                                 ) {
        return productService.createProduct(categoryName,productName, productDescription, image, stock, price);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable int id) {
        return productService.deleteProduct(id);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product){
        return productService.updateProduct(id, product);
    }

    @GetMapping("/products/search")
    public List<Product> searchProduct(
            @RequestParam(name = "name", required = false)     String name,
            @RequestParam(name = "category", required = false) String category,
            @RequestParam(name = "minPrice", defaultValue = ""+Integer.MIN_VALUE,required = false) double minPrice,
            @RequestParam(name = "maxPrice", defaultValue = ""+Integer.MAX_VALUE, required = false) double maxPrice
    ){
        return productService.searchProduct(name, category, minPrice, maxPrice);
    }
}
