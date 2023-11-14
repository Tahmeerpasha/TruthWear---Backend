package com.truthwear.truthwear.service.interfaces;

import com.truthwear.truthwear.entity.OrderStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderStatusService {
    ResponseEntity<List<OrderStatus>> getAllOrderStatus();
    ResponseEntity<OrderStatus> getAllOrderStatusById(int id);
    ResponseEntity<OrderStatus> createOrderStatus(OrderStatus orderStatus);
    ResponseEntity<OrderStatus> updateOrderStatus(int id, String orderStatus);

    ResponseEntity<OrderStatus> deleteOrderStatusById(int id);
}
