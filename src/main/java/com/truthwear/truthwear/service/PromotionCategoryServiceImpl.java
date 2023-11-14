package com.truthwear.truthwear.service;

import com.truthwear.truthwear.entity.PromotionCategory;
import com.truthwear.truthwear.repository.PromotionCategoryRepository;
import com.truthwear.truthwear.service.interfaces.PromotionCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionCategoryServiceImpl implements PromotionCategoryService {

    private final PromotionCategoryRepository promotionCategoryRepository;

    public PromotionCategoryServiceImpl(PromotionCategoryRepository promotionCategoryRepository) {
        this.promotionCategoryRepository = promotionCategoryRepository;
    }

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
        if (categoryId != null)
            promotionCategory.setCategoryId(categoryId);
        if (promotionId != null)
            promotionCategory.setPromotionId(promotionId);
        return ResponseEntity.ok(promotionCategoryRepository.save(promotionCategory));
    }

}
