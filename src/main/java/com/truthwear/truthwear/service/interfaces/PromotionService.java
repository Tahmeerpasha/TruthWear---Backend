package com.truthwear.truthwear.service.interfaces;

import com.truthwear.truthwear.entity.Promotion;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;
import java.util.List;

public interface PromotionService {
    ResponseEntity<List<Promotion>> getAllPromotions();

    ResponseEntity<Promotion> getPromotionsById(int id);

    ResponseEntity<Promotion> createPromotion(Promotion promotion);

    ResponseEntity<Promotion> updatePromotion(int id, String promotionName, String promotionDescription, Integer discountRate, Timestamp startDate, Timestamp endDate);

    ResponseEntity<Promotion> deletePromotion(int id);
}
