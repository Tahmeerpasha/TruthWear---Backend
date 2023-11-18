package com.truthwear.truthwear.controller;

import com.truthwear.truthwear.entity.Promotion;
import com.truthwear.truthwear.service.PromotionServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api/v1/promotions")
public class PromotionController {

    private final PromotionServiceImpl promotionService;

    public PromotionController(PromotionServiceImpl promotionService) {
        this.promotionService = promotionService;
    }

    // Get all promotions
    @GetMapping
    public ResponseEntity<List<Promotion>> getAllPromotions() {
        try {
            List<Promotion> promotions = promotionService.getAllPromotions();
            return ResponseEntity.ok(promotions);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get a specific promotion by id
    @GetMapping("/{id}")
    public ResponseEntity<Promotion> getPromotionsById(@PathVariable int id) {
        try {
            Promotion promotion = promotionService.getPromotionsById(id);
            return ResponseEntity.ok(promotion);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Create a new promotion
    @PostMapping
    public ResponseEntity<Promotion> createPromotion(@RequestBody Promotion promotion) {
        try {
            Promotion createdPromotion = promotionService.createPromotion(promotion);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPromotion);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Update an existing promotion
    @PutMapping("/{id}")
    public ResponseEntity<Promotion> updatePromotion(@PathVariable int id,
                                                     @RequestParam(required = false) String promotionName,
                                                     @RequestParam(required = false) String promotionDescription,
                                                     @RequestParam(required = false) Timestamp startDate,
                                                     @RequestParam(required = false) Timestamp endDate,
                                                     @RequestParam(required = false) Integer discount
    ) {
        try {
            Promotion updatedPromotion = promotionService.updatePromotion(id, promotionName,promotionDescription, discount, startDate, endDate);
            return ResponseEntity.ok(updatedPromotion);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Delete a promotion by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Promotion> deletePromotion(@PathVariable int id) {
        try {
            Promotion deletedPromotion = promotionService.deletePromotion(id);
            return ResponseEntity.ok(deletedPromotion);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}