package com.truthwear.truthwear.controller;

import com.truthwear.truthwear.entity.ShippingMethod;
import com.truthwear.truthwear.service.ShippingMethodServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/shipping-methods")
public class ShippingMethodController {

    private final ShippingMethodServiceImpl shippingMethodService;


    // Get all shipping methods
    @GetMapping
    public ResponseEntity<List<ShippingMethod>> getAllShippingMethod() {
        try {
            List<ShippingMethod> shippingMethods = shippingMethodService.getAllShippingMethod();
            return ResponseEntity.ok(shippingMethods);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get a specific shipping method by id
    @GetMapping("/{id}")
    public ResponseEntity<ShippingMethod> getShippingMethodById(@PathVariable int id) {
        try {
            ShippingMethod shippingMethod = shippingMethodService.getShippingMethodById(id);
            return ResponseEntity.ok(shippingMethod);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Create a new shipping method
    @PostMapping
    public ResponseEntity<ShippingMethod> createShippingMethod(@RequestBody ShippingMethod shippingMethod) {
        try {
            ShippingMethod createdShippingMethod = shippingMethodService.createShippingMethod(shippingMethod);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdShippingMethod);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Update an existing shipping method
    @PutMapping("/{id}")
    public ResponseEntity<ShippingMethod> updateShippingMethod(@PathVariable int id,
                                                               @RequestParam(value = "shippingMethod", required = false) String shippingMethodName,
                                                               @RequestParam(value = "price", required = false) BigDecimal price
    ) {
        try {
            ShippingMethod updatedShippingMethod = shippingMethodService.updateShippingMethod(id, shippingMethodName, price);
            return ResponseEntity.ok(updatedShippingMethod);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Delete a shipping method by id
    @DeleteMapping("/{id}")
    public ResponseEntity<ShippingMethod> deleteShippingMethod(@PathVariable int id) {
        try {
            ShippingMethod deletedShippingMethod = shippingMethodService.deleteShippingMethod(id);
            return ResponseEntity.ok(deletedShippingMethod);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}