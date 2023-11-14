package com.truthwear.truthwear.service;

import com.truthwear.truthwear.entity.OrderLine;
import com.truthwear.truthwear.repository.OrderLineRepository;
import com.truthwear.truthwear.service.interfaces.OrderLineService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderLineServiceImpl implements OrderLineService {

    private  final OrderLineRepository orderLineRepository;

    public OrderLineServiceImpl(OrderLineRepository orderLineRepository) {
        this.orderLineRepository = orderLineRepository;
    }

    @Override
    public ResponseEntity<List<OrderLine>> getAllOrderLines() {
        return ResponseEntity.ok(orderLineRepository.findAll());
    }

    @Override
    public ResponseEntity<OrderLine> getAllOrderLinesById(int id) {
        return ResponseEntity.ok(orderLineRepository.findById(id).get());
    }

    @Override
    public ResponseEntity<OrderLine> createOrderLines(OrderLine orderLine) {
        return ResponseEntity.ok(orderLineRepository.save(orderLine));
    }

    @Override
    public ResponseEntity<OrderLine> updateOrderLines(int id, Integer productId, Integer orderId, Integer quantity, Integer price) {
        OrderLine orderLine = orderLineRepository.findById(id).get();
        if (productId != null)orderLine.setProductId(productId);
        if (orderId != null)orderLine.setOrderId(orderId);
        if (quantity != null)orderLine.setQuantity(quantity);
        if (price != null)orderLine.setPrice(price);
        return ResponseEntity.ok(orderLineRepository.save(orderLine));
    }

    @Override
    public ResponseEntity<OrderLine> deleteOrderLines(int id) {
        OrderLine orderLine = orderLineRepository.findById(id).get();
        orderLineRepository.delete(orderLine);
        return ResponseEntity.ok(orderLine);
    }

}
