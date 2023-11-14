package com.truthwear.truthwear.service.interfaces;

import com.truthwear.truthwear.entity.ShippingMethod;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

public interface ShippingMethodService {
    ResponseEntity<List<ShippingMethod>> getAllShippingMethod();

    ResponseEntity<ShippingMethod> getShippingMethodById(int id);

    ResponseEntity<ShippingMethod> createShippingMethod(ShippingMethod shippingMethod);

    ResponseEntity<ShippingMethod> updateShippingMethod(int id, String shippingMethod, BigDecimal price);

    ResponseEntity<ShippingMethod> deleteShippingMethod(int id);
}
