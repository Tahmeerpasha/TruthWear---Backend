package com.truthwear.truthwear.service;

import com.truthwear.truthwear.entity.Product;
import com.truthwear.truthwear.entity.ProductCategory;
import com.truthwear.truthwear.repository.ProductCategoryRepository;
import com.truthwear.truthwear.repository.ProductRepository;
import com.truthwear.truthwear.service.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Value("${upload.path}")
    private String uploadDirectory;
    private final ProductCategoryRepository productCategoryRepository;
    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public ResponseEntity<Product> createProduct(String categoryName, String productName, String productDescription, MultipartFile image, long stock, double price) {
        try {
            String fileName = image.getOriginalFilename();
            String filePath = uploadDirectory + File.separator + fileName;

            // If directory is not present then create it
//            File file1 = new File(uploadDirectory);
//            if(!file1.exists()){
//                file1.mkdir();
//            }
//            print the path where image is stored
//            System.out.println(file.getAbsolutePath());


//            Copy file to the image directory
            Files.copy(image.getInputStream(), Paths.get(filePath));
            ProductCategory productCategory = productCategoryRepository.findByCategoryName(categoryName);
            Product product = new Product(productCategory, productName, productDescription, filePath, stock, price);
            productRepository.save(product);
            return ResponseEntity.ok(product);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @Override
    public ResponseEntity<Product> deleteProduct(int id) {
        try {
            Optional<Product> product = productRepository.findById(id);
            if (product.isPresent()) {
                boolean imgDeleted = deleteFile(product.get().getImage());
                if (imgDeleted) {
                    productRepository.deleteById(id);
                    return ResponseEntity.ok(product.get());
                } else return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @Override
    public ResponseEntity<Product> updateProduct(int id, ProductCategory productCategory, String productName, String productDescription, MultipartFile image, Long stock, Double price) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()) return ResponseEntity.notFound().build();
        else {
            try {
                Product product = productOptional.get();
                if (productCategory != null) product.setCategory(productCategory);
                if (productName != null) product.setProductName(productName);
                if (productDescription != null) product.setDescription(productDescription);
                if (stock != null)
                    if (stock != 0)
                        product.setStock(stock);
                if (price != null)
                    if (price != 0)
                        product.setPrice(price);
                if (image != null) {
                    boolean imgDeleted = deleteFile(product.getImage());
                    if (!imgDeleted)
                        return ResponseEntity.internalServerError().body(null);
                    else {
                        String fileName = image.getOriginalFilename();
                        String filePath = uploadDirectory + File.separator + fileName;
                        try {
                            Files.copy(image.getInputStream(), Paths.get(filePath));
                            product.setImage(filePath);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }

                productRepository.save(product);
                return ResponseEntity.ok(product);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return ResponseEntity.internalServerError().body(null);
    }

    @Override
    public List<Product> getProductByCategory(String category) {
        return productRepository.findByCategory(productCategoryRepository.findByCategoryName(category));
    }

    @Override
    public List<Product> searchProduct(String name, String category, double minPrice, double maxPrice) {
        System.out.println("|" + name.isEmpty() + "name " + category + " " + minPrice + " " + maxPrice);
        if (!name.isEmpty() && !category.isEmpty() && minPrice != 0 && maxPrice != 0) {
            return productRepository.findByProductNameContainingAndCategoryAndPriceBetween(name, productCategoryRepository.findByCategoryName(category), minPrice, maxPrice);
        } else if (!name.isEmpty() && !category.isEmpty()) {
            return productRepository.findByProductNameContainingAndCategory(name, productCategoryRepository.findByCategoryName(category));
        } else if (!name.isEmpty() && minPrice != 0 && maxPrice != 0) {
            return productRepository.findByProductNameContainingAndPriceBetween(name, minPrice, maxPrice);
        } else if (!category.isEmpty() && minPrice != 0 && maxPrice != 0) {
            return productRepository.findByCategoryAndPriceBetween(productCategoryRepository.findByCategoryName(category), minPrice, maxPrice);
        } else if (!name.isEmpty()) {
            return productRepository.findByProductNameContaining(name);
        } else if (!category.isEmpty()) {
            return productRepository.findByCategory(productCategoryRepository.findByCategoryName(category));
        } else if (minPrice == 0 && maxPrice != 0) {
            return productRepository.findByPriceBetween(minPrice, maxPrice);
        } else {
            return productRepository.findAll();
        }
    }

    private boolean deleteFile(String filePath) {
        try {
            Path path = Paths.get(filePath);
            Files.delete(path);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
