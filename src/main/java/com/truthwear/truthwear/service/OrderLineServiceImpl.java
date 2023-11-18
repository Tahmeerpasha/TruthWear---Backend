package com.truthwear.truthwear.service;

import com.truthwear.truthwear.entity.OrderLine;
import com.truthwear.truthwear.entity.Product;
import com.truthwear.truthwear.entity.ShopOrder;
import com.truthwear.truthwear.repository.OrderLineRepository;
import com.truthwear.truthwear.repository.ProductRepository;
import com.truthwear.truthwear.repository.ShopOrderRepository;
import com.truthwear.truthwear.service.interfaces.OrderLineService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class OrderLineServiceImpl implements OrderLineService {

    private  final OrderLineRepository orderLineRepository;
    private final ProductRepository productRepository;
    private final ShopOrderRepository shopOrderRepository;

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
        if (productId != null) {
            Product product = productRepository.findById(productId).get();
            orderLine.setProduct(product);
        }
        if (orderId != null) {
            ShopOrder shopOrder = shopOrderRepository.findById(orderId).get();
            orderLine.setShopOrder(shopOrder);
        }
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
