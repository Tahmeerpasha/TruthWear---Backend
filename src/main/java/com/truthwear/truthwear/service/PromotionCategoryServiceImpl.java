package com.truthwear.truthwear.service;

import com.truthwear.truthwear.entity.ProductCategory;
import com.truthwear.truthwear.entity.Promotion;
import com.truthwear.truthwear.entity.PromotionCategory;
import com.truthwear.truthwear.repository.ProductCategoryRepository;
import com.truthwear.truthwear.repository.PromotionCategoryRepository;
import com.truthwear.truthwear.repository.PromotionRepository;
import com.truthwear.truthwear.service.interfaces.PromotionCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PromotionCategoryServiceImpl implements PromotionCategoryService {

    private final PromotionCategoryRepository promotionCategoryRepository;
    private final ProductCategoryRepository productCategoryRepository;
    private final PromotionRepository promotionRepository;

    @Override
    public ResponseEntity<List<PromotionCategory>> getAllPromotionCategory() {
        return ResponseEntity.ok(promotionCategoryRepository.findAll());
    }

    @Override
    public ResponseEntity<PromotionCategory> getPromotionCategoryById(int id) {
        PromotionCategory promotionCategory = promotionCategoryRepository.findById(id).isPresent() ? promotionCategoryRepository.findById(id).get() : null;
        if (promotionCategory == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(promotionCategory);
    }

    @Override
    public ResponseEntity<PromotionCategory> createPromotionCategory(PromotionCategory promotionCategory) {
        return ResponseEntity.ok(promotionCategoryRepository.save(promotionCategory));
    }

    @Override
    public ResponseEntity<PromotionCategory> deletePromotionCategory(int id) {
        PromotionCategory promotionCategory = promotionCategoryRepository.findById(id).isPresent() ? promotionCategoryRepository.findById(id).get() : null;
        if (promotionCategory == null) return ResponseEntity.notFound().build();
        promotionCategoryRepository.delete(promotionCategory);
        return ResponseEntity.ok(promotionCategory);

    }

    @Override
    public ResponseEntity<PromotionCategory> updatePromotionCategory(int id,Integer categoryId, Integer promotionId) {
        PromotionCategory promotionCategory = promotionCategoryRepository.findById(id).isPresent() ? promotionCategoryRepository.findById(id).get() : null;
        if (promotionCategory == null) return ResponseEntity.notFound().build();
        if (categoryId != null) {
            ProductCategory productCategory = productCategoryRepository.findById(categoryId).get();
            promotionCategory.setProductCategory(productCategory);
        }
        if (promotionId != null) {
            Promotion promotion = promotionRepository.findById(promotionId).get();
            promotionCategory.setPromotion(promotion);
        }
        return ResponseEntity.ok(promotionCategoryRepository.save(promotionCategory));
    }

}
