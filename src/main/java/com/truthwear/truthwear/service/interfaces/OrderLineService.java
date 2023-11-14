package com.truthwear.truthwear.service.interfaces;

import com.truthwear.truthwear.entity.OrderLine;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderLineService {
    ResponseEntity<List<OrderLine>> getAllOrderLines();

    ResponseEntity<OrderLine> getAllOrderLinesById(int id);

    ResponseEntity<OrderLine> createOrderLines(OrderLine orderLine);

    ResponseEntity<OrderLine> updateOrderLines(int id, Integer productId, Integer orderId, Integer quantity, Integer price);

    ResponseEntity<OrderLine> deleteOrderLines(int id);
}
