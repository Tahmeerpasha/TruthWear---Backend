package com.truthwear.truthwear.service;

import com.truthwear.truthwear.entity.ProductReviews;
import com.truthwear.truthwear.repository.ProductReviewsRepository;
import com.truthwear.truthwear.service.interfaces.ProductReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductReviewServiceImpl implements ProductReviewService{

    private final ProductReviewsRepository productReviewsRepository;

    @Autowired
    public ProductReviewServiceImpl(ProductReviewsRepository productReviewsRepository) {
        this.productReviewsRepository = productReviewsRepository;
    }

    @Override
    public List<ProductReviews> getAllReviews() {
        return productReviewsRepository.findAll();
    }

    @Override
    public ResponseEntity<ProductReviews> createReviews(ProductReviews productReviews) {

        return ResponseEntity.ok(productReviewsRepository.save(productReviews));
    }

    @Override
    public ResponseEntity<List<ProductReviews>> getProductReviewBasedOnUserId(int userId) {
        List<ProductReviews> productReviews;
        try {
            productReviews = productReviewsRepository.findByUserId(userId);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
        if (productReviews != null)
            return ResponseEntity.ok(productReviews);
        else
            return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<List<ProductReviews>> getProductReviewBasedOnProductId(int productId) {
        List<ProductReviews> productReviews;
        try {
             productReviews = productReviewsRepository.findByProductId(productId);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
        if (productReviews != null)
            return ResponseEntity.ok(productReviews);
        else
            return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<ProductReviews> updateReviews(int id,int ratingValue, String comments) {
           ProductReviews productReviews =  productReviewsRepository.findById(id).get();
        if (ratingValue >= 0 && ratingValue <= 10 && !comments.isEmpty()){
            productReviews.setRating(ratingValue);
            productReviews.setReview(comments);
        }else if (ratingValue >= 0 && ratingValue <= 10 )
            productReviews.setRating(ratingValue);
        else productReviews.setReview(comments);

        try {
          return ResponseEntity.ok(productReviewsRepository.save(productReviews));
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<ProductReviews> deleteReviewById(int id) {
        try {
        ProductReviews productReviews = productReviewsRepository.findById(id).get();
        productReviewsRepository.delete(productReviews);
        return ResponseEntity.ok(productReviews);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<List<ProductReviews>> deleteReviewByUserId(int userId) {
        List<ProductReviews> productReviews = productReviewsRepository.findByUserId(userId);
        if (productReviews != null){
            try {
                    productReviewsRepository.deleteAll(productReviews);
                    return ResponseEntity.ok(productReviews);
            }catch (Exception e){
                return ResponseEntity.internalServerError().build();
            }
        }else
            return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<List<ProductReviews>> deleteReviewByProductId(int productId) {
        List<ProductReviews> productReviews = productReviewsRepository.findByProductId(productId);
        if (productReviews != null){
            try {
                productReviewsRepository.deleteAll(productReviews);
                return ResponseEntity.ok(productReviews);
            }catch (Exception e){
                return ResponseEntity.internalServerError().build();
            }
        }else
            return ResponseEntity.notFound().build();
    }



}
