package com.truthwear.truthwear.service.interfaces;

import com.truthwear.truthwear.entity.ShopOrder;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public interface ShopOrderService {
    ResponseEntity<List<ShopOrder>> getAllShopOrders();

    ResponseEntity<List<ShopOrder>> getAllShopOrdersByUserId(int userId);

    ResponseEntity<ShopOrder> createShopOrder(ShopOrder shopOrder);

    ResponseEntity<ShopOrder> updateShopOrder(int id, Timestamp orderDate, Integer shippingAddressId, Integer shippingMethodId, BigDecimal orderTotal, Integer orderStatus, Integer paymentMethodId);

    ResponseEntity<ShopOrder> deleteShopOrder(int id);

    ResponseEntity<ShopOrder> getAllShopOrdersById(int id);
}
