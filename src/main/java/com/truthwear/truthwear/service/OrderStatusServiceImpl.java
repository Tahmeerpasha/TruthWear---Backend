package com.truthwear.truthwear.service;

import com.truthwear.truthwear.entity.OrderStatus;
import com.truthwear.truthwear.repository.OrderStatusRepository;
import com.truthwear.truthwear.service.interfaces.OrderStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderStatusServiceImpl implements OrderStatusService {

    private final OrderStatusRepository orderStatusRepository;

    // Get all order statuses
    @Override
    public List<OrderStatus> getAllOrderStatus() {
        return orderStatusRepository.findAll();
    }

    // Get a specific order status by id
    @Override
    public OrderStatus getAllOrderStatusById(int id) {
        Optional<OrderStatus> orderStatusOptional = orderStatusRepository.findById(id);
        return orderStatusOptional.orElse(null);
    }

    // Create a new order status
    @Override
    public OrderStatus createOrderStatus(OrderStatus orderStatus) {
        return orderStatusRepository.save(orderStatus);
    }

    // Update an existing order status
    @Override
    public OrderStatus updateOrderStatus(int id, String orderStatus) {
        Optional<OrderStatus> orderStatusOptional = orderStatusRepository.findById(id);
        if (orderStatusOptional.isEmpty()) {
            return null;
        }
        OrderStatus existingOrderStatus = orderStatusOptional.get();
        if (orderStatus != null) {
            existingOrderStatus.setOrderStatus(orderStatus);
            return orderStatusRepository.save(existingOrderStatus);
        }
        return null;
    }

    // Delete an order status by id
    @Override
    public OrderStatus deleteOrderStatusById(int id) {
        Optional<OrderStatus> orderStatusOptional = orderStatusRepository.findById(id);
        if (orderStatusOptional.isEmpty()) {
            return null;
        }
        OrderStatus orderStatus = orderStatusOptional.get();
        orderStatusRepository.delete(orderStatus);
        return orderStatus;
    }
}