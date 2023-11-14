package com.truthwear.truthwear.service;

import com.truthwear.truthwear.entity.Promotion;
import com.truthwear.truthwear.repository.PromotionRepository;
import com.truthwear.truthwear.service.interfaces.PromotionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class PromotionServiceImpl implements PromotionService {

    private final PromotionRepository promotionRepository;

    public PromotionServiceImpl(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    @Override
    public ResponseEntity<List<Promotion>> getAllPromotions() {
        try {
            return ResponseEntity.ok(promotionRepository.findAll());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<Promotion> getPromotionsById(int id) {
        Promotion promotion = promotionRepository.findById(id).isPresent() ? promotionRepository.findById(id).get() : null;
        if (promotion == null) return ResponseEntity.notFound().build();
        try {
            return ResponseEntity.ok(promotion);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<Promotion> createPromotion(Promotion promotion) {
        try {
            return ResponseEntity.ok(promotionRepository.save(promotion));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<Promotion> updatePromotion(
            int id,
            String promotionName,
            String promotionDescription,
            Integer discountRate,
            Timestamp startDate,
            Timestamp endDate) {

        Optional<Promotion> optionalPromotion = promotionRepository.findById(id);

        if (optionalPromotion.isEmpty()) {
            return ResponseEntity.notFound().build();
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

        try {
            return ResponseEntity.ok(promotionRepository.save(promotion));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<Promotion> deletePromotion(int id) {
        Promotion promotion = promotionRepository.findById(id).isPresent() ? promotionRepository.findById(id).get() : null;
        if (promotion == null) return ResponseEntity.notFound().build();

        try {
            promotionRepository.delete(promotion);
            return ResponseEntity.ok(promotion);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
