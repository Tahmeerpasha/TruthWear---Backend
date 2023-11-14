package com.truthwear.truthwear.service;

import com.truthwear.truthwear.entity.OrderStatus;
import com.truthwear.truthwear.repository.OrderStatusRepository;
import com.truthwear.truthwear.service.interfaces.OrderStatusService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderStatusServiceImpl implements OrderStatusService {
    private final OrderStatusRepository orderStatusRepository;

    public OrderStatusServiceImpl(OrderStatusRepository orderStatusRepository) {
        this.orderStatusRepository = orderStatusRepository;
    }

    @Override
    public ResponseEntity<List<OrderStatus>> getAllOrderStatus() {
        return ResponseEntity.ok(orderStatusRepository.findAll());
    }

    @Override
    public ResponseEntity<OrderStatus> getAllOrderStatusById(int id) {
        return ResponseEntity.ok(orderStatusRepository.findById(id).get());
    }

    @Override
    public ResponseEntity<OrderStatus> createOrderStatus(OrderStatus orderStatus) {
        return ResponseEntity.ok(orderStatusRepository.save(orderStatus));
    }

    public ResponseEntity<OrderStatus> updateOrderStatus(int id, String orderStatus) {
        OrderStatus orderStatus1 = orderStatusRepository.findById(id).get();
        if (orderStatus == null)return ResponseEntity.badRequest().build();
        else orderStatus1.setOrderStatus(orderStatus);
        return ResponseEntity.ok(orderStatusRepository.save(orderStatus1));
    }

    @Override
    public ResponseEntity<OrderStatus> deleteOrderStatusById(int id) {
        OrderStatus orderStatus = orderStatusRepository.findById(id).get();
        orderStatusRepository.delete(orderStatus);
        return ResponseEntity.ok(orderStatus);
    }
}
