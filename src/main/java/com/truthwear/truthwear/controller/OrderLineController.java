package com.truthwear.truthwear.controller;

import com.truthwear.truthwear.entity.OrderLine;
import com.truthwear.truthwear.service.OrderLineServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order-lines")
@RequiredArgsConstructor
public class OrderLineController {
    private final OrderLineServiceImpl orderLineService;

//    Get all order lines
    @GetMapping
    public ResponseEntity<List<OrderLine>> getAllOrderLines() {
        try {
            List<OrderLine> orderLines = orderLineService.getAllOrderLines();
            return ResponseEntity.ok(orderLines);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

//    Get order line by id
    @GetMapping("/{id}")
    public ResponseEntity<OrderLine> getOrderLineById(@PathVariable int id) {
        try {
            OrderLine orderLine = orderLineService.getOrderLineById(id);
            return ResponseEntity.ok(orderLine);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

//    Create order line
    @PostMapping
    public ResponseEntity<OrderLine> createOrderLine(@RequestBody OrderLine orderLine) {
        try {
            OrderLine createdOrderLine = orderLineService.createOrderLine(orderLine);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdOrderLine);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

//    Update order line
    @PutMapping("/{id}")
    public ResponseEntity<OrderLine> updateOrderLine(
            @PathVariable int id,
            @RequestParam(required = false) Integer productId,
            @RequestParam(required = false) Integer orderId,
            @RequestParam(required = false) Integer quantity,
            @RequestParam(required = false) Integer price) {
        try {
            OrderLine updatedOrderLine = orderLineService.updateOrderLine(id, productId, orderId, quantity, price);
            return ResponseEntity.ok(updatedOrderLine);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

//    Delete order line
    @DeleteMapping("/{id}")
    public ResponseEntity<OrderLine> deleteOrderLine(@PathVariable int id) {
        try {
            OrderLine deletedOrderLine = orderLineService.deleteOrderLine(id);
            return ResponseEntity.ok(deletedOrderLine);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
