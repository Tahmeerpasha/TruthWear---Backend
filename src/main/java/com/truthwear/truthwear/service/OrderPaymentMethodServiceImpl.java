package com.truthwear.truthwear.service;

import com.truthwear.truthwear.entity.OrderPaymentMethod;
import com.truthwear.truthwear.entity.ShopOrder;
import com.truthwear.truthwear.entity.UserPaymentMethod;
import com.truthwear.truthwear.repository.OrderPaymentMethodRepository;
import com.truthwear.truthwear.repository.ShopOrderRepository;
import com.truthwear.truthwear.repository.UserPaymentMethodRepository;
import com.truthwear.truthwear.service.interfaces.OrderPaymentMethodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderPaymentMethodServiceImpl implements OrderPaymentMethodService {
    private final OrderPaymentMethodRepository orderPaymentMethodRepository;
    private final ShopOrderRepository shopOrderRepository;
    private final UserPaymentMethodRepository userPaymentMethodRepository;

    // Get all order payment methods
    @Override
    public List<OrderPaymentMethod> getAllOrderPaymentMethods() {
        return orderPaymentMethodRepository.findAll();
    }

    // Get a specific order payment method by id
    @Override
    public OrderPaymentMethod getOrderPaymentMethodById(int id) {
        Optional<OrderPaymentMethod> orderPaymentMethod = orderPaymentMethodRepository.findById(id);
        return orderPaymentMethod.orElse(null);
    }

    // Create a new order payment method
    @Override
    public OrderPaymentMethod createOrderPaymentMethod(OrderPaymentMethod orderPaymentMethod) {
        return orderPaymentMethodRepository.save(orderPaymentMethod);
    }

    // Update an existing order payment method
    @Override
    public OrderPaymentMethod updateOrderPaymentMethod(int id, Integer orderId, Integer userPaymentMethodId) {
        Optional<OrderPaymentMethod> orderPaymentMethodOptional = orderPaymentMethodRepository.findById(id);
        if (orderPaymentMethodOptional.isEmpty()) {
            return null;
        }
        OrderPaymentMethod orderPaymentMethod = orderPaymentMethodOptional.get();
        if (orderId != null) {
            Optional<ShopOrder> shopOrderOptional = shopOrderRepository.findById(orderId);
            shopOrderOptional.ifPresent(orderPaymentMethod::setShopOrder);
        }
        if (userPaymentMethodId != null) {
            Optional<UserPaymentMethod> userPaymentMethodOptional = userPaymentMethodRepository.findById(userPaymentMethodId);
            userPaymentMethodOptional.ifPresent(orderPaymentMethod::setUserPaymentMethod);
        }
        return orderPaymentMethodRepository.save(orderPaymentMethod);
    }

    // Delete an existing order payment method
    @Override
    public OrderPaymentMethod deleteOrderPaymentMethod(int id) {
        Optional<OrderPaymentMethod> orderPaymentMethodOptional = orderPaymentMethodRepository.findById(id);
        if (orderPaymentMethodOptional.isEmpty()) {
            return null;
        }
        OrderPaymentMethod orderPaymentMethod = orderPaymentMethodOptional.get();
        orderPaymentMethodRepository.delete(orderPaymentMethod);
        return orderPaymentMethod;
    }
}