package com.truthwear.truthwear.service.interfaces;

import com.truthwear.truthwear.entity.OrderStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderStatusService {
    List<OrderStatus> getAllOrderStatus();
    OrderStatus getAllOrderStatusById(int id);
    OrderStatus createOrderStatus(OrderStatus orderStatus);
    OrderStatus updateOrderStatus(int id, String orderStatus);

    OrderStatus deleteOrderStatusById(int id);
}
