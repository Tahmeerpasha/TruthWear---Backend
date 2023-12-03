package com.truthwear.truthwear.controller;

import com.truthwear.truthwear.entity.Product;
import com.truthwear.truthwear.entity.ProductCategory;
import com.truthwear.truthwear.service.ProductServiceImpl;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    // Get all products
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        try {
            List<Product> products = productService.getAllProducts();
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get a specific product by id
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        try {
            Optional<Product> product = productService.getProductById(id);
            return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("image/{id}")
    public ResponseEntity<Resource> serveImage(@PathVariable String id) throws IOException {
        String imagesFolderPath = "E:/Development/TruthWear/Backend/TruthWear";
        String imageName = productService.getProductById(Integer.parseInt(id)).get().getImage();
        Path imagePath = Paths.get(imagesFolderPath).resolve(imageName);
        Resource imageResource = new UrlResource(imagePath.toUri());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_JPEG_VALUE)
                .body(imageResource);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Product>> getProductByCategory(@PathVariable String category) {
        try {
            List<Product> products = productService.getProductByCategory(category);
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    // Create a new product
    @PostMapping("/upload")
    public ResponseEntity<Product> createProduct(@RequestParam("categoryName") String categoryName,
                                                 @RequestParam("productName") String productName,
                                                 @RequestParam("productDescription") String productDescription,
                                                 @RequestParam("image") MultipartFile image,
                                                 @RequestParam("stock") long stock,
                                                 @RequestParam("price") double price) {
        try {
            return productService.createProduct(categoryName, productName, productDescription, image, stock, price);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Delete a product by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable int id) {
        try {
            return productService.deleteProduct(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Update an existing product
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id,
                                                 @RequestParam(required = false) ProductCategory productCategory,
                                                 @RequestParam(required = false) String productName,
                                                 @RequestParam(required = false) String productDescription,
                                                 @RequestParam(required = false) MultipartFile image,
                                                 @RequestParam(required = false) Long stock,
                                                 @RequestParam(required = false) Double price
                                                 ) {
//            System.out.println("id: " + id+ " category: " + productCategory + " name: " + productName + " desc: " + productDescription + " image: " + image + " stock: " + stock + " price: " + price);
        try {
            return productService.updateProduct(id, productCategory, productName, productDescription, image, stock, price);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Search for products
    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProduct(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "category", required = false) String category,
            @RequestParam(name = "minPrice", defaultValue = "" + Integer.MIN_VALUE, required = false) double minPrice,
            @RequestParam(name = "maxPrice", defaultValue = "" + Integer.MAX_VALUE, required = false) double maxPrice) {
        try {
            List<Product> products = productService.searchProduct(name, category, minPrice, maxPrice);
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}