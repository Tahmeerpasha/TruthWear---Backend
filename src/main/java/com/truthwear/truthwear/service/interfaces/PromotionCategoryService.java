package com.truthwear.truthwear.service.interfaces;

import com.truthwear.truthwear.entity.PromotionCategory;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PromotionCategoryService {

    List<PromotionCategory> getAllPromotionCategory();

    PromotionCategory getPromotionCategoryById(int id);

    PromotionCategory createPromotionCategory(PromotionCategory promotionCategory);

    PromotionCategory deletePromotionCategory(int id);

    PromotionCategory updatePromotionCategory(int id,Integer categoryId, Integer promotionId);
}
