package com.truthwear.truthwear.service;

import com.truthwear.truthwear.entity.ProductCategory;
import com.truthwear.truthwear.entity.Promotion;
import com.truthwear.truthwear.entity.PromotionCategory;
import com.truthwear.truthwear.repository.ProductCategoryRepository;
import com.truthwear.truthwear.repository.PromotionCategoryRepository;
import com.truthwear.truthwear.repository.PromotionRepository;
import com.truthwear.truthwear.service.interfaces.PromotionCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PromotionCategoryServiceImpl implements PromotionCategoryService {

    private final PromotionCategoryRepository promotionCategoryRepository;
    private final ProductCategoryRepository productCategoryRepository;
    private final PromotionRepository promotionRepository;

    // Get all promotion categories
    @Override
    public List<PromotionCategory> getAllPromotionCategory() {
        return promotionCategoryRepository.findAll();
    }

    // Get a specific promotion category by id
    @Override
    public PromotionCategory getPromotionCategoryById(int id) {
        Optional<PromotionCategory> promotionCategoryOptional = promotionCategoryRepository.findById(id);
        return promotionCategoryOptional.orElse(null);
    }

    // Create a new promotion category
    @Override
    public PromotionCategory createPromotionCategory(PromotionCategory promotionCategory) {
        return promotionCategoryRepository.save(promotionCategory);
    }

    // Delete a promotion category by id
    @Override
    public PromotionCategory deletePromotionCategory(int id) {
        Optional<PromotionCategory> promotionCategoryOptional = promotionCategoryRepository.findById(id);
        if (promotionCategoryOptional.isEmpty()) {
            return null;
        }
        PromotionCategory promotionCategory = promotionCategoryOptional.get();
        promotionCategoryRepository.delete(promotionCategory);
        return promotionCategory;
    }

    // Update an existing promotion category
    @Override
    public PromotionCategory updatePromotionCategory(int id, Integer categoryId, Integer promotionId) {
        Optional<PromotionCategory> promotionCategoryOptional = promotionCategoryRepository.findById(id);
        if (promotionCategoryOptional.isEmpty()) {
            return null;
        }
        PromotionCategory promotionCategory = promotionCategoryOptional.get();
        if (categoryId != null) {
            Optional<ProductCategory> productCategoryOptional = productCategoryRepository.findById(categoryId);
            productCategoryOptional.ifPresent(promotionCategory::setProductCategory);
        }
        if (promotionId != null) {
            Optional<Promotion> promotionOptional = promotionRepository.findById(promotionId);
            promotionOptional.ifPresent(promotionCategory::setPromotion);
        }
        return promotionCategoryRepository.save(promotionCategory);
    }
}