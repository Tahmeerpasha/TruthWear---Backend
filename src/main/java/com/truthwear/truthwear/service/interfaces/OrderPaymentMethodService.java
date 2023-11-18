package com.truthwear.truthwear.service.interfaces;

import com.truthwear.truthwear.entity.OrderPaymentMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderPaymentMethodService {
    List<OrderPaymentMethod> getAllOrderPaymentMethods();

    OrderPaymentMethod getOrderPaymentMethodById(int id);

    OrderPaymentMethod createOrderPaymentMethod(OrderPaymentMethod orderPaymentMethod);

    OrderPaymentMethod updateOrderPaymentMethod(int id, Integer orderId, Integer userPaymentMethodId);

    OrderPaymentMethod deleteOrderPaymentMethod(int id);
}
