package com.truthwear.truthwear.service.interfaces;

import com.truthwear.truthwear.entity.OrderPaymentMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderPaymentMethodService {
    ResponseEntity<List<OrderPaymentMethod>> getAllOrderPaymentMethods();

    ResponseEntity<OrderPaymentMethod> getAllOrderPaymentMethod(int id);

    ResponseEntity<OrderPaymentMethod> createOrderPaymentMethod(OrderPaymentMethod orderPaymentMethod);

    ResponseEntity<OrderPaymentMethod> updateOrderPaymentMethod(int id, Integer orderId, Integer userPaymentMethodId);

    ResponseEntity<OrderPaymentMethod> deleteOrderPaymentMethod(int id);
}
