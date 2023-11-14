package com.truthwear.truthwear.controller;

import com.truthwear.truthwear.entity.PromotionCategory;
import com.truthwear.truthwear.service.PromotionCategoryServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PromotionCategoryController {
    private final PromotionCategoryServiceImpl promotionCategoryService;

    public PromotionCategoryController(PromotionCategoryServiceImpl promotionCategoryService) {
        this.promotionCategoryService = promotionCategoryService;
    }

    @GetMapping("/promotion_categories")
    ResponseEntity<List<PromotionCategory>> getAllPromotionCategory(){
        return promotionCategoryService.getAllPromotionCategory();
    }
    @GetMapping("/promotion_categories/{id}")
    ResponseEntity<PromotionCategory> getAllPromotionCategory(@PathVariable int id){
        return promotionCategoryService.getPromotionCategoryById(id);
    }

    @PostMapping("/promotion_categories")
    ResponseEntity<PromotionCategory> createPromotionCategory(@RequestBody PromotionCategory promotionCategory){
        return promotionCategoryService.createPromotionCategory(promotionCategory);
    }

    @PutMapping("/promotion_categories/{id}")
    ResponseEntity<PromotionCategory> updatePromotionCategory(
            @RequestParam(name = "categoryId", required = false) Integer categoryId,
            @RequestParam(name = "promotionId", required = false) Integer promotionId,
            @PathVariable int id){
        return promotionCategoryService.updatePromotionCategory(id,categoryId,promotionId);
    }
    @DeleteMapping("/promotion_categories/{id}")
    ResponseEntity<PromotionCategory> deletePromotionCategory(@PathVariable int id){
        return promotionCategoryService.deletePromotionCategory(id);
    }
}
