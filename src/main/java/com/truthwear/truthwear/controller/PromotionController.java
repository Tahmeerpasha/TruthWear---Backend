package com.truthwear.truthwear.controller;

import com.truthwear.truthwear.entity.Promotion;
import com.truthwear.truthwear.service.PromotionServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class PromotionController {

    private final PromotionServiceImpl promotionService;

    public PromotionController(PromotionServiceImpl promotionService) {
        this.promotionService = promotionService;
    }

    @GetMapping("promotions")
    ResponseEntity<List<Promotion>> getAllPromotions() {
        return promotionService.getAllPromotions();
    }

    @GetMapping("promotions/{id}")
    ResponseEntity<Promotion> getPromotionsById(@PathVariable int id) {
        return promotionService.getPromotionsById(id);
    }

    @PostMapping("promotions")
    ResponseEntity<Promotion> createPromotion(@RequestBody Promotion promotion) {
        return promotionService.createPromotion(promotion);
    }

    @PutMapping("promotions/{id}")
    ResponseEntity<Promotion> updatePromotion(@RequestParam(name = "promotionName", required = false) String promotionName,
                                              @RequestParam(name = "promotionDescription", required = false) String promotionDescription,
                                              @RequestParam(name = "discountRate", required = false) Integer discountRate,
                                              @RequestParam(name = "startDate", required = false) Timestamp startDate,
                                              @RequestParam(name = "endDate", required = false) Timestamp endDate,
                                              @PathVariable int id
    ) {
        return promotionService.updatePromotion(id, promotionName, promotionDescription, discountRate, startDate, endDate);
    }

    @DeleteMapping("promotions/{id}")
    ResponseEntity<Promotion> deletePromotion(@PathVariable int id) {
        return promotionService.deletePromotion(id);
    }


}
