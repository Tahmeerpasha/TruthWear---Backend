package com.truthwear.truthwear.controller;

import com.truthwear.truthwear.entity.ShopOrder;
import com.truthwear.truthwear.service.ShopOrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/shop-orders")
public class ShopOrderController {

    private final ShopOrderServiceImpl shopOrderService;

    // Get all shop orders
    @GetMapping
    public ResponseEntity<List<ShopOrder>> getAllShopOrders() {
        try {
            List<ShopOrder> shopOrders = shopOrderService.getAllShopOrders();
            return ResponseEntity.ok(shopOrders);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get a specific shop order by id
    @GetMapping("/{id}")
    public ResponseEntity<ShopOrder> getAllShopOrdersById(@PathVariable int id) {
        try {
            ShopOrder shopOrder = shopOrderService.getAllShopOrdersById(id);
            return ResponseEntity.ok(shopOrder);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get all shop orders by user id
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ShopOrder>> getAllShopOrdersByUserId(@PathVariable int userId) {
        try {
            List<ShopOrder> shopOrders = shopOrderService.getAllShopOrdersByUserId(userId);
            return ResponseEntity.ok(shopOrders);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Create a new shop order
    @PostMapping
    public ResponseEntity<ShopOrder> createShopOrder(@RequestBody ShopOrder shopOrder) {
        try {
            ShopOrder createdShopOrder = shopOrderService.createShopOrder(shopOrder);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdShopOrder);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Update an existing shop order
    @PutMapping("/{id}")
    public ResponseEntity<ShopOrder> updateShopOrder(
            @PathVariable int id,
            @RequestParam(value = "orderDate", required = false) Timestamp orderDate,
            @RequestParam(value = "orderPaymentMethodId", required = false) Integer orderPaymentMethodId,
            @RequestParam(value = "shippingAddressId", required = false) Integer shippingAddressId,
            @RequestParam(value = "shippingMethodId", required = false) Integer shippingMethodId,
            @RequestParam(value = "orderTotal", required = false) BigDecimal orderTotal,
            @RequestParam(value = "orderStatus", required = false) Integer orderStatus
    ) {
        try {
            ShopOrder updatedShopOrder = shopOrderService.updateShopOrder(id, orderDate, shippingAddressId, shippingMethodId, orderTotal, orderStatus, orderPaymentMethodId);
            return ResponseEntity.ok(updatedShopOrder);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Delete a shop order by id
    @DeleteMapping("/{id}")
    public ResponseEntity<ShopOrder> deleteShopOrder(@PathVariable int id) {
        try {
            ShopOrder deletedShopOrder = shopOrderService.deleteShopOrder(id);
            return ResponseEntity.ok(deletedShopOrder);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}