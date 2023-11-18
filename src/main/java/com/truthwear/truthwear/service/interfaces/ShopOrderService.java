package com.truthwear.truthwear.service.interfaces;

import com.truthwear.truthwear.entity.ShopOrder;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public interface ShopOrderService {
    List<ShopOrder> getAllShopOrders();

    List<ShopOrder> getAllShopOrdersByUserId(int userId);

    ShopOrder createShopOrder(ShopOrder shopOrder);

    ShopOrder updateShopOrder(int id, Timestamp orderDate, Integer shippingAddressId, Integer shippingMethodId, BigDecimal orderTotal, Integer orderStatus, Integer paymentMethodId);

    ShopOrder deleteShopOrder(int id);

    ShopOrder getAllShopOrdersById(int id);
}
