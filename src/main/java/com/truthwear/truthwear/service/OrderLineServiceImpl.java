package com.truthwear.truthwear.service;

import com.truthwear.truthwear.entity.OrderLine;
import com.truthwear.truthwear.repository.OrderLineRepository;
import com.truthwear.truthwear.repository.ProductRepository;
import com.truthwear.truthwear.repository.ShopOrderRepository;
import com.truthwear.truthwear.service.interfaces.OrderLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderLineServiceImpl implements OrderLineService {

    private final OrderLineRepository orderLineRepository;
    private final ProductRepository productRepository;
    private final ShopOrderRepository shopOrderRepository;

    // Get all order lines
    @Override
    public List<OrderLine> getAllOrderLines() {
        return orderLineRepository.findAll();
    }

    // Get a specific order line by id
    @Override
    public OrderLine getOrderLineById(int id) {
        return orderLineRepository.findById(id).orElse(null);
    }

    // Create a new order line
    @Override
    public OrderLine createOrderLine(OrderLine orderLine) {
        return orderLineRepository.save(orderLine);
    }

    // Update an existing order line
    @Override
    public OrderLine updateOrderLine(int id, Integer productId, Integer orderId, Integer quantity, Integer price) {
        Optional<OrderLine> orderLineOptional = orderLineRepository.findById(id);
        if (orderLineOptional.isEmpty()) {
            return null;
        }
        OrderLine orderLine = orderLineOptional.get();
        if (productId != null) {
            productRepository.findById(productId).ifPresent(orderLine::setProduct);
        }
        if (orderId != null) {
            shopOrderRepository.findById(orderId).ifPresent(orderLine::setShopOrder);
        }
        if (quantity != null) {
            orderLine.setQuantity(quantity);
        }
        if (price != null) {
            orderLine.setPrice(price);
        }
        return orderLineRepository.save(orderLine);
    }

    // Delete an order line
    @Override
    public OrderLine deleteOrderLine(int id) {
        Optional<OrderLine> orderLineOptional = orderLineRepository.findById(id);
        if (orderLineOptional.isEmpty()) {
            return null;
        }
        OrderLine orderLine = orderLineOptional.get();
        orderLineRepository.delete(orderLine);
        return orderLine;
    }
}