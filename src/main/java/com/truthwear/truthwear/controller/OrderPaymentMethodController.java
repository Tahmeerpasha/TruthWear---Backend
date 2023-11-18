package com.truthwear.truthwear.controller;

import com.truthwear.truthwear.entity.OrderPaymentMethod;
import com.truthwear.truthwear.service.OrderPaymentMethodServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order-payment-methods")
public class OrderPaymentMethodController {
    private final OrderPaymentMethodServiceImpl orderPaymentMethodService;

    // Get all order payment methods
    @GetMapping
    public ResponseEntity<List<OrderPaymentMethod>> getAllOrderPaymentMethods() {
        try {
            List<OrderPaymentMethod> orderPaymentMethods = orderPaymentMethodService.getAllOrderPaymentMethods();
            return ResponseEntity.ok(orderPaymentMethods);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get a specific order payment method by id
    @GetMapping("/{id}")
    public ResponseEntity<OrderPaymentMethod> getOrderPaymentMethodById(@PathVariable int id) {
        try {
            OrderPaymentMethod orderPaymentMethod = orderPaymentMethodService.getOrderPaymentMethodById(id);
            return ResponseEntity.ok(orderPaymentMethod);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Create a new order payment method
    @PostMapping
    public ResponseEntity<OrderPaymentMethod> createOrderPaymentMethod(@RequestBody OrderPaymentMethod orderPaymentMethod) {
        try {
            OrderPaymentMethod createdOrderPaymentMethod = orderPaymentMethodService.createOrderPaymentMethod(orderPaymentMethod);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdOrderPaymentMethod);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Update an existing order payment method
    @PutMapping("/{id}")
    public ResponseEntity<OrderPaymentMethod> updateOrderPaymentMethod(
            @PathVariable int id,
            @RequestParam(required = false) Integer orderId,
            @RequestParam(required = false) Integer userPaymentMethodId) {
        try {
            OrderPaymentMethod updatedOrderPaymentMethod = orderPaymentMethodService.updateOrderPaymentMethod(id, orderId, userPaymentMethodId);
            return ResponseEntity.ok(updatedOrderPaymentMethod);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Delete an existing order payment method
    @DeleteMapping("/{id}")
    public ResponseEntity<OrderPaymentMethod> deleteOrderPaymentMethod(@PathVariable int id) {
        try {
            OrderPaymentMethod deletedOrderPaymentMethod = orderPaymentMethodService.deleteOrderPaymentMethod(id);
            return ResponseEntity.ok(deletedOrderPaymentMethod);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}