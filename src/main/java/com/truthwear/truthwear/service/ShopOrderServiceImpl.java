package com.truthwear.truthwear.service;

import com.truthwear.truthwear.entity.*;
import com.truthwear.truthwear.repository.*;
import com.truthwear.truthwear.service.interfaces.ShopOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShopOrderServiceImpl implements ShopOrderService {

    private final ShopOrderRepository shopOrderRepository;
    private final OrderPaymentMethodRepository orderPaymentMethodRepository;
    private final AddressRepository addressRepository;
    private final ShippingMethodRepository shippingMethodRepository;
    private final OrderStatusRepository orderStatusRepository;

    // Get all shop orders
    @Override
    public List<ShopOrder> getAllShopOrders() {
        return shopOrderRepository.findAll();
    }

    // Get a specific shop order by id
    @Override
    public ShopOrder getAllShopOrdersById(int id) {
        Optional<ShopOrder> shopOrderOptional = shopOrderRepository.findById(id);
        return shopOrderOptional.orElse(null);
    }

    // Get all shop orders by user id
    @Override
    public List<ShopOrder> getAllShopOrdersByUserId(int userId) {
        return shopOrderRepository.findAllByUserId(userId);
    }

    // Create a new shop order
    @Override
    public ShopOrder createShopOrder(ShopOrder shopOrder) {
        return shopOrderRepository.save(shopOrder);
    }

    // Update an existing shop order
    @Override
    public ShopOrder updateShopOrder(int id, Timestamp orderDate,
                                     Integer shippingAddressId, Integer shippingMethodId,
                                     BigDecimal orderTotal, Integer orderStatus, Integer orderPaymentMethodId) {
        Optional<ShopOrder> shopOrderOptional = shopOrderRepository.findById(id);
        if (shopOrderOptional.isEmpty()) {
            return null;
        }
        ShopOrder shopOrder = shopOrderOptional.get();
        if (orderDate != null) {
            shopOrder.setOrderDate(orderDate);
        }
        if (orderPaymentMethodId != null) {
            Optional<OrderPaymentMethod> orderPaymentMethodOptional = orderPaymentMethodRepository.findById(orderPaymentMethodId);
            orderPaymentMethodOptional.ifPresent(shopOrder::setOrderPaymentMethod);
        }
        if (shippingAddressId != null) {
            Optional<Address> addressOptional = addressRepository.findById(shippingAddressId);
            addressOptional.ifPresent(shopOrder::setShippingAddress);
        }
        if (shippingMethodId != null) {
            Optional<ShippingMethod> shippingMethodOptional = shippingMethodRepository.findById(shippingMethodId);
            shippingMethodOptional.ifPresent(shopOrder::setShippingMethod);
        }
        if (orderTotal != null) {
            shopOrder.setOrderTotal(orderTotal);
        }
        if (orderStatus != null) {
            Optional<OrderStatus> orderStatusOptional = orderStatusRepository.findById(orderStatus);
            orderStatusOptional.ifPresent(shopOrder::setOrderStatus);
        }
        return shopOrderRepository.save(shopOrder);
    }

    // Delete a shop order by id
    @Override
    public ShopOrder deleteShopOrder(int id) {
        Optional<ShopOrder> shopOrderOptional = shopOrderRepository.findById(id);
        if (shopOrderOptional.isEmpty()) {
            return null;
        }
        ShopOrder shopOrder = shopOrderOptional.get();
        shopOrderRepository.delete(shopOrder);
        return shopOrder;
    }
}