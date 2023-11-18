package com.truthwear.truthwear.controller;

import com.truthwear.truthwear.entity.PromotionCategory;
import com.truthwear.truthwear.service.PromotionCategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/promotion-categories")
public class PromotionCategoryController {

    private final PromotionCategoryServiceImpl promotionCategoryService;


    // Get all promotion categories
    @GetMapping
    public ResponseEntity<List<PromotionCategory>> getAllPromotionCategory() {
        try {
            List<PromotionCategory> promotionCategories = promotionCategoryService.getAllPromotionCategory();
            return ResponseEntity.ok(promotionCategories);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get a specific promotion category by id
    @GetMapping("/{id}")
    public ResponseEntity<PromotionCategory> getPromotionCategory(@PathVariable int id) {
        try {
            PromotionCategory promotionCategory = promotionCategoryService.getPromotionCategoryById(id);
            return ResponseEntity.ok(promotionCategory);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Create a new promotion category
    @PostMapping
    public ResponseEntity<PromotionCategory> createPromotionCategory(@RequestBody PromotionCategory promotionCategory) {
        try {
            PromotionCategory createdPromotionCategory = promotionCategoryService.createPromotionCategory(promotionCategory);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPromotionCategory);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Update an existing promotion category
    @PutMapping("/{id}")
    public ResponseEntity<PromotionCategory> updatePromotionCategory(@PathVariable int id,
                                                                     @RequestParam(required = false) Integer categoryId,
                                                                     @RequestParam(required = false) Integer promotionId) {
        try {
            PromotionCategory updatedPromotionCategory = promotionCategoryService.updatePromotionCategory(id, categoryId, promotionId);
            return ResponseEntity.ok(updatedPromotionCategory);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Delete a promotion category by id
    @DeleteMapping("/{id}")
    public ResponseEntity<PromotionCategory> deletePromotionCategory(@PathVariable int id) {
        try {
            PromotionCategory deletedPromotionCategory = promotionCategoryService.deletePromotionCategory(id);
            return ResponseEntity.ok(deletedPromotionCategory);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}