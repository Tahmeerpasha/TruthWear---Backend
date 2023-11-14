package com.truthwear.truthwear.service.interfaces;

import com.truthwear.truthwear.entity.PromotionCategory;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PromotionCategoryService {

    ResponseEntity<List<PromotionCategory>> getAllPromotionCategory();

    ResponseEntity<PromotionCategory> getPromotionCategoryById(int id);

    ResponseEntity<PromotionCategory> createPromotionCategory(PromotionCategory promotionCategory);

    ResponseEntity<PromotionCategory> deletePromotionCategory(int id);

    ResponseEntity<PromotionCategory> updatePromotionCategory(int id,Integer categoryId, Integer promotionId);
}
