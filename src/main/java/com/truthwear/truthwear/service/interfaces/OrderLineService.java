package com.truthwear.truthwear.service.interfaces;

import com.truthwear.truthwear.entity.OrderLine;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderLineService {
    List<OrderLine> getAllOrderLines();

    OrderLine getOrderLineById(int id);

    OrderLine createOrderLine(OrderLine orderLine);

    OrderLine updateOrderLine(int id, Integer productId, Integer orderId, Integer quantity, Integer price);

    OrderLine deleteOrderLine(int id);
}
