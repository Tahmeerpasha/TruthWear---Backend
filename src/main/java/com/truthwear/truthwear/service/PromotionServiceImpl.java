package com.truthwear.truthwear.service;

import com.truthwear.truthwear.entity.Promotion;
import com.truthwear.truthwear.repository.PromotionRepository;
import com.truthwear.truthwear.service.interfaces.PromotionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PromotionServiceImpl implements PromotionService {

    private final PromotionRepository promotionRepository;

    // Get all promotions
    @Override
    public List<Promotion> getAllPromotions() {
        return promotionRepository.findAll();
    }

    // Get a specific promotion by id
    @Override
    public Promotion getPromotionsById(int id) {
        Optional<Promotion> promotionOptional = promotionRepository.findById(id);
        return promotionOptional.orElse(null);
    }

    // Create a new promotion
    @Override
    public Promotion createPromotion(Promotion promotion) {
        return promotionRepository.save(promotion);
    }

    // Update an existing promotion
    @Override
    public Promotion updatePromotion(
            int id,
            String promotionName,
            String promotionDescription,
            Integer discountRate,
            Timestamp startDate,
            Timestamp endDate) {

        Optional<Promotion> optionalPromotion = promotionRepository.findById(id);

        if (optionalPromotion.isEmpty()) {
            return null;
        }

        Promotion promotion = optionalPromotion.get();

        if (promotionName != null) {
            promotion.setPromotionName(promotionName);
        }

        if (promotionDescription != null) {
            promotion.setPromotionDescription(promotionDescription);
        }

        if (discountRate != null) {
            promotion.setDiscountRate(discountRate);
        }

        if (startDate != null) {
            promotion.setStartDate(startDate);
        }

        if (endDate != null) {
            promotion.setEndDate(endDate);
        }

        return promotionRepository.save(promotion);
    }

    // Delete a promotion by id
    @Override
    public Promotion deletePromotion(int id) {
        Optional<Promotion> promotionOptional = promotionRepository.findById(id);
        if (promotionOptional.isEmpty()) {
            return null;
        }
        Promotion promotion = promotionOptional.get();
        promotionRepository.delete(promotion);
        return promotion;
    }
}