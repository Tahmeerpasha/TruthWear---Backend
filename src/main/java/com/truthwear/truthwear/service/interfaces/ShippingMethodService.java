package com.truthwear.truthwear.service.interfaces;

import com.truthwear.truthwear.entity.ShippingMethod;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

public interface ShippingMethodService {
    List<ShippingMethod> getAllShippingMethod();

    ShippingMethod getShippingMethodById(int id);

    ShippingMethod createShippingMethod(ShippingMethod shippingMethod);

    ShippingMethod updateShippingMethod(int id, String shippingMethod, BigDecimal price);

    ShippingMethod deleteShippingMethod(int id);
}
