package com.truthwear.truthwear.service;

import com.truthwear.truthwear.entity.ShippingMethod;
import com.truthwear.truthwear.repository.ShippingMethodRepository;
import com.truthwear.truthwear.service.interfaces.ShippingMethodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShippingMethodServiceImpl implements ShippingMethodService {

    private final ShippingMethodRepository shippingMethodRepository;

    // Get all shipping methods
    @Override
    public List<ShippingMethod> getAllShippingMethod() {
        return shippingMethodRepository.findAll();
    }

    // Get a specific shipping method by id
    @Override
    public ShippingMethod getShippingMethodById(int id) {
        Optional<ShippingMethod> shippingMethodOptional = shippingMethodRepository.findById(id);
        return shippingMethodOptional.orElse(null);
    }

    // Create a new shipping method
    @Override
    public ShippingMethod createShippingMethod(ShippingMethod shippingMethod) {
        return shippingMethodRepository.save(shippingMethod);
    }

    // Update an existing shipping method
    @Override
    public ShippingMethod updateShippingMethod(int id, String shippingMethodName, BigDecimal price) {
        Optional<ShippingMethod> shippingMethodOptional = shippingMethodRepository.findById(id);
        if (shippingMethodOptional.isEmpty()) {
            return null;
        }
        ShippingMethod existingShippingMethod = shippingMethodOptional.get();
        if (shippingMethodName != null) {
            existingShippingMethod.setShippingMethod(shippingMethodName);
        }
        if (price != null) {
            existingShippingMethod.setPrice(price);
        }
        return shippingMethodRepository.save(existingShippingMethod);
    }

    // Delete a shipping method by id
    @Override
    public ShippingMethod deleteShippingMethod(int id) {
        Optional<ShippingMethod> shippingMethodOptional = shippingMethodRepository.findById(id);
        if (shippingMethodOptional.isEmpty()) {
            return null;
        }
        ShippingMethod shippingMethod = shippingMethodOptional.get();
        shippingMethodRepository.delete(shippingMethod);
        return shippingMethod;
    }
}