package com.truthwear.truthwear.service;

import com.truthwear.truthwear.entity.OrderPaymentMethod;
import com.truthwear.truthwear.entity.ShopOrder;
import com.truthwear.truthwear.entity.UserPaymentMethod;
import com.truthwear.truthwear.repository.OrderPaymentMethodRepository;
import com.truthwear.truthwear.repository.ShopOrderRepository;
import com.truthwear.truthwear.repository.UserPaymentMethodRepository;
import com.truthwear.truthwear.service.interfaces.OrderPaymentMethodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderPaymentMethodServiceImpl implements OrderPaymentMethodService {
    private final OrderPaymentMethodRepository orderPaymentMethodRepository;
    private final ShopOrderRepository shopOrderRepository;
    private final UserPaymentMethodRepository userPaymentMethodRepository;

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
        if (orderId != null) {
            ShopOrder shopOrder = shopOrderRepository.findById(orderId).get();
            orderPaymentMethod.setShopOrder(shopOrder);
        }
        if (userPaymentMethodId != null) {
            UserPaymentMethod userPaymentMethod = userPaymentMethodRepository.findById(userPaymentMethodId).get();
            orderPaymentMethod.setUserPaymentMethod(userPaymentMethod);
        }
        return ResponseEntity.ok(orderPaymentMethodRepository.save(orderPaymentMethod));
    }

    @Override
    public ResponseEntity<OrderPaymentMethod> deleteOrderPaymentMethod(int id) {
        OrderPaymentMethod orderPaymentMethod = orderPaymentMethodRepository.findById(id).get();
        orderPaymentMethodRepository.delete(orderPaymentMethod);
        return ResponseEntity.ok(orderPaymentMethod);
    }


}
