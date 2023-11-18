package com.truthwear.truthwear.controller;

import com.truthwear.truthwear.entity.OrderStatus;
import com.truthwear.truthwear.service.OrderStatusServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order-status")
public class OrderStatusController {

    private final OrderStatusServiceImpl orderStatusService;

    // Get all order statuses
    @GetMapping
    public ResponseEntity<List<OrderStatus>> getAllOrderStatus(){
        try {
            List<OrderStatus> orderStatuses = orderStatusService.getAllOrderStatus();
            return ResponseEntity.ok(orderStatuses);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get a specific order status by id
    @GetMapping("/{id}")
    public ResponseEntity<OrderStatus> getAllOrderStatusById(@PathVariable int id){
        try {
            OrderStatus orderStatus = orderStatusService.getAllOrderStatusById(id);
            return ResponseEntity.ok(orderStatus);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Create a new order status
    @PostMapping
    public ResponseEntity<OrderStatus> createOrderStatus(@RequestBody OrderStatus orderStatus){
        try {
            OrderStatus createdOrderStatus = orderStatusService.createOrderStatus(orderStatus);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdOrderStatus);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Update an existing order status
    @PutMapping("/{id}")
    public ResponseEntity<OrderStatus> updateOrderStatus(@PathVariable int id, @RequestParam("orderStatus") String orderStatus){
        try {
            OrderStatus updatedOrderStatus = orderStatusService.updateOrderStatus(id, orderStatus);
            return ResponseEntity.ok(updatedOrderStatus);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Delete an existing order status
    @DeleteMapping("/{id}")
    public ResponseEntity<OrderStatus> deleteOrderStatusById(@PathVariable int id){
        try {
            OrderStatus deletedOrderStatus = orderStatusService.deleteOrderStatusById(id);
            return ResponseEntity.ok(deletedOrderStatus);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}