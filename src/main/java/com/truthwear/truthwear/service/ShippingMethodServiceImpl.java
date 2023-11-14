package com.truthwear.truthwear.service;

import com.truthwear.truthwear.entity.ShippingMethod;
import com.truthwear.truthwear.repository.ShippingMethodRepository;
import com.truthwear.truthwear.service.interfaces.ShippingMethodService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ShippingMethodServiceImpl implements ShippingMethodService {
    private final ShippingMethodRepository shippingMethodRepository;

    public ShippingMethodServiceImpl(ShippingMethodRepository shippingMethodRepository) {
        this.shippingMethodRepository = shippingMethodRepository;
    }

    @Override
    public ResponseEntity<List<ShippingMethod>> getAllShippingMethod() {
        return ResponseEntity.ok(shippingMethodRepository.findAll());
    }

    @Override
    public ResponseEntity<ShippingMethod> getShippingMethodById(int id) {
        return ResponseEntity.ok(shippingMethodRepository.findById(id).get());
    }

    @Override
    public ResponseEntity<ShippingMethod> createShippingMethod(ShippingMethod shippingMethod) {
        return ResponseEntity.ok(shippingMethodRepository.save(shippingMethod));
    }

    @Override
    public ResponseEntity<ShippingMethod> updateShippingMethod(int id, String shippingMethod, BigDecimal price) {
        ShippingMethod shippingMethod1 = shippingMethodRepository.findById(id).get();
        if (shippingMethod != null)shippingMethod1.setShippingMethod(shippingMethod);
        if (price != null)shippingMethod1.setPrice(price);
        return ResponseEntity.ok(shippingMethodRepository.save(shippingMethod1));
    }

    @Override
    public ResponseEntity<ShippingMethod> deleteShippingMethod(int id) {
        ShippingMethod shippingMethod = shippingMethodRepository.findById(id).get();
        shippingMethodRepository.delete(shippingMethod);
        return ResponseEntity.ok(shippingMethod);
    }

}
