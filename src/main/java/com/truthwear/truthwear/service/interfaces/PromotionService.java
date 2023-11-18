package com.truthwear.truthwear.service.interfaces;

import com.truthwear.truthwear.entity.Promotion;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;
import java.util.List;

public interface PromotionService {
    List<Promotion> getAllPromotions();

    Promotion getPromotionsById(int id);

    Promotion createPromotion(Promotion promotion);

    Promotion updatePromotion(int id, String promotionName, String promotionDescription, Integer discountRate, Timestamp startDate, Timestamp endDate);

    Promotion deletePromotion(int id);
}
