package com.truthwear.truthwear.service;

import com.truthwear.truthwear.entity.OrderPaymentMethod;
import com.truthwear.truthwear.repository.OrderPaymentMethodRepository;
import com.truthwear.truthwear.service.interfaces.OrderPaymentMethodService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderPaymentMethodServiceImpl implements OrderPaymentMethodService {
    private final OrderPaymentMethodRepository orderPaymentMethodRepository;

    public OrderPaymentMethodServiceImpl(OrderPaymentMethodRepository orderPaymentMethodRepository) {
        this.orderPaymentMethodRepository = orderPaymentMethodRepository;
    }

    @Override
    public ResponseEntity<List<OrderPaymentMethod>> getAllOrderPaymentMethods() {
        return ResponseEntity.ok(orderPaymentMethodRepository.findAll());
    }

    @Override
    public ResponseEntity<OrderPaymentMethod> getAllOrderPaymentMethod(int id) {
        return ResponseEntity.ok(orderPaymentMethodRepository.findById(id).get());
    }

    @Override
    public ResponseEntity<OrderPaymentMethod> createOrderPaymentMethod(OrderPaymentMethod orderPaymentMethod) {
        return ResponseEntity.ok(orderPaymentMethodRepository.save(orderPaymentMethod));
    }

    @Override
    public ResponseEntity<OrderPaymentMethod> updateOrderPaymentMethod(int id, Integer orderId, Integer userPaymentMethodId) {
        OrderPaymentMethod orderPaymentMethod = orderPaymentMethodRepository.findById(id).get();
        if (orderId != null)orderPaymentMethod.setOrderId(orderId);
        if (userPaymentMethodId != null)orderPaymentMethod.setUserPaymentMethodId(userPaymentMethodId);
        return ResponseEntity.ok(orderPaymentMethodRepository.save(orderPaymentMethod));
    }

    @Override
    public ResponseEntity<OrderPaymentMethod> deleteOrderPaymentMethod(int id) {
        OrderPaymentMethod orderPaymentMethod = orderPaymentMethodRepository.findById(id).get();
        orderPaymentMethodRepository.delete(orderPaymentMethod);
        return ResponseEntity.ok(orderPaymentMethod);
    }


}
