package com.truthwear.truthwear.service.interfaces;

import com.truthwear.truthwear.entity.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();

    Optional<Product> getProductById(int id);

    ResponseEntity<Product> createProduct(String categoryName, String productName, String productDescription, MultipartFile image, long stock,double price);

    ResponseEntity<Product> deleteProduct(int id);

    ResponseEntity<Product> updateProduct(int id, Product product);

    List<Product> searchProduct(String name, String category, double minPrice, double maxPrice);
}
