package com.truthwear.truthwear.controller;

import com.truthwear.truthwear.entity.ProductReviews;
import com.truthwear.truthwear.service.ProductReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class ProductReviewController {
    private final ProductReviewServiceImpl productReviewService;

    @Autowired
    public ProductReviewController(ProductReviewServiceImpl productReviewService) {
        this.productReviewService = productReviewService;
    }

    @GetMapping("reviews")
    List<ProductReviews> getAllReviews(){
        return productReviewService.getAllReviews();
    }


//    Get reviews based on user ID
    @GetMapping("reviews/user/{userId}")
    ResponseEntity<List<ProductReviews>> getProductReviewBasedOnUserId(@PathVariable int userId){
        return productReviewService.getProductReviewBasedOnUserId(userId);
    }
//    Get Reviews based on product ID
    @GetMapping("reviews/product/{productId}")
    ResponseEntity<List<ProductReviews>> getProductReviewBasedOnProductId(@PathVariable int productId){
        return productReviewService.getProductReviewBasedOnProductId(productId);
    }

    @GetMapping("reviews/{id}")
    ResponseEntity<ProductReviews> getProductReviewById(@PathVariable int id){
        return productReviewService.getProductReviewById(id);
    }


    @PostMapping("reviews")
    ResponseEntity<ProductReviews> createReviews(@RequestBody ProductReviews productReviews){
        return productReviewService.createReviews(productReviews);
    }

    @PutMapping("reviews/{id}")
    ResponseEntity<ProductReviews> updateReviews(@PathVariable int id,@RequestParam(name = "ratingValue", required = false) Integer ratingValue, @RequestParam(name = "comments", required = false) String comments){
        return productReviewService.updateReviews(id,ratingValue,comments);
    }

    @DeleteMapping("reviews/{id}")
    ResponseEntity<ProductReviews> deleteReviewById(@PathVariable int id){
        return productReviewService.deleteReviewById(id);
    }

//    Delete all reviews of a particular user
    @DeleteMapping("reviews/user/{userId}")
    ResponseEntity<List<ProductReviews>> deleteReviewByUserId(@PathVariable int userId){
        return productReviewService.deleteReviewByUserId(userId);
    }

//    Delete all reviews of a particular product
    @DeleteMapping("reviews/product/{productId}")
    ResponseEntity<List<ProductReviews>> deleteReviewByProductId(@PathVariable int productId){
        return productReviewService.deleteReviewByProductId(productId);
    }

}
