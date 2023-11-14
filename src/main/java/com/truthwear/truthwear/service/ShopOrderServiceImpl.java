package com.truthwear.truthwear.service;

import com.truthwear.truthwear.entity.ShopOrder;
import com.truthwear.truthwear.repository.ShopOrderRepository;
import com.truthwear.truthwear.service.interfaces.ShopOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Service
public class ShopOrderServiceImpl implements ShopOrderService {

    private final ShopOrderRepository shopOrderRepository;

    public ShopOrderServiceImpl(ShopOrderRepository shopOrderRepository) {
        this.shopOrderRepository = shopOrderRepository;
    }

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
        if (orderPaymentMethodId != null)shopOrder.setPaymentMethodId(orderPaymentMethodId);
        if (shippingAddressId != null)shopOrder.setShippingAddressId(shippingAddressId);
        if (shippingMethodId != null)shopOrder.setShippingMethodId(shippingMethodId);
        if (orderTotal != null)shopOrder.setOrderTotal(orderTotal);
        if (orderStatus != null)shopOrder.setOrderStatusId(orderStatus);
        return ResponseEntity.ok(shopOrderRepository.save(shopOrder));
    }

    @Override
    public ResponseEntity<ShopOrder> deleteShopOrder(int id) {
        ShopOrder shopOrder = shopOrderRepository.findById(id).get();
        shopOrderRepository.delete(shopOrder);
        return ResponseEntity.ok(shopOrder);
    }


}
