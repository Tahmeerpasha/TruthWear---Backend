package com.truthwear.truthwear.service;

import com.truthwear.truthwear.entity.*;
import com.truthwear.truthwear.repository.*;
import com.truthwear.truthwear.service.interfaces.ShopOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopOrderServiceImpl implements ShopOrderService {

    private final ShopOrderRepository shopOrderRepository;
    private final OrderPaymentMethodRepository orderPaymentMethodRepository;
    private final AddressRepository addressRepository;
    private final ShippingMethodRepository shippingMethodRepository;
    private final OrderStatusRepository orderStatusRepository;
    @Override
    public ResponseEntity<List<ShopOrder>> getAllShopOrders() {
        return ResponseEntity.ok(shopOrderRepository.findAll());
    }
    @Override
    public ResponseEntity<ShopOrder> getAllShopOrdersById(int id) {
        return ResponseEntity.ok(shopOrderRepository.findById(id).get());
    }
    @Override
    public ResponseEntity<List<ShopOrder>> getAllShopOrdersByUserId(int userId) {
        return ResponseEntity.ok(shopOrderRepository.findAllByUserId(userId));
    }

    @Override
    public ResponseEntity<ShopOrder> createShopOrder(ShopOrder shopOrder) {
            return ResponseEntity.ok(shopOrderRepository.save(shopOrder));
    }

    @Override
    public ResponseEntity<ShopOrder> updateShopOrder(int id, Timestamp orderDate,
                                                     Integer shippingAddressId, Integer shippingMethodId,
                                                     BigDecimal orderTotal, Integer orderStatus, Integer orderPaymentMethodId) {
        ShopOrder shopOrder = shopOrderRepository.findById(id).get();
        if (orderDate != null)shopOrder.setOrderDate(orderDate);
        if (orderPaymentMethodId != null) {
            OrderPaymentMethod orderPaymentMethod = orderPaymentMethodRepository.findById(orderPaymentMethodId).get();
            shopOrder.setOrderPaymentMethod(orderPaymentMethod);
        }
        if (shippingAddressId != null) {
            Address address = addressRepository.findById(shippingAddressId).get();
            shopOrder.setShippingAddress(address);
        }
        if (shippingMethodId != null) {
            ShippingMethod shippingMethod = shippingMethodRepository.findById(shippingMethodId).get();
            shopOrder.setShippingMethod(shippingMethod);
        }
        if (orderTotal != null)shopOrder.setOrderTotal(orderTotal);
        if (orderStatus != null) {
            OrderStatus orderStatus1 = orderStatusRepository.findById(orderStatus).get();
            shopOrder.setOrderStatus(orderStatus1);
        }
        return ResponseEntity.ok(shopOrderRepository.save(shopOrder));
    }

    @Override
    public ResponseEntity<ShopOrder> deleteShopOrder(int id) {
        ShopOrder shopOrder = shopOrderRepository.findById(id).get();
        shopOrderRepository.delete(shopOrder);
        return ResponseEntity.ok(shopOrder);
    }


}
