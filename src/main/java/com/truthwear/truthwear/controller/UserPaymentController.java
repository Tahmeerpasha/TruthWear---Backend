package com.truthwear.truthwear.controller;

import com.truthwear.truthwear.entity.UserPaymentMethod;
import com.truthwear.truthwear.service.UserPaymentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user-payments")
public class UserPaymentController {

    private final UserPaymentServiceImpl userPaymentService;

    public UserPaymentController(UserPaymentServiceImpl userPaymentService) {
        this.userPaymentService = userPaymentService;
    }

    // Get all user payments
    @GetMapping
    public ResponseEntity<List<UserPaymentMethod>> getAllUserPayments() {
        try {
            List<UserPaymentMethod> userPayments = userPaymentService.getAllUserPayments();
            return ResponseEntity.ok(userPayments);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get a specific user payment by id
    @GetMapping("/{id}")
    public ResponseEntity<List<UserPaymentMethod>> getAllUserPaymentsById(@PathVariable int id) {
        try {
            List<UserPaymentMethod> userPayments = userPaymentService.getAllUserPaymentsById(id);
            return ResponseEntity.ok(userPayments);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get all user payments by user id
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserPaymentMethod>> getAllUserPaymentsByUserId(@PathVariable int userId) {
        try {
            List<UserPaymentMethod> userPayments = userPaymentService.getAllUserPaymentsByUserId(userId);
            return ResponseEntity.ok(userPayments);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Create a new user payment
    @PostMapping
    public ResponseEntity<UserPaymentMethod> createUserPaymentMethod(@RequestBody UserPaymentMethod userPaymentMethod){
        try {
            UserPaymentMethod createdUserPayment = userPaymentService.createUserPaymentMethod(userPaymentMethod);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUserPayment);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Update an existing user payment
    @PutMapping("/{id}")
    public ResponseEntity<UserPaymentMethod> updateUserPaymentMethod(
            @PathVariable int id,
            @RequestParam(name = "clientName", required = false) String  clientName,
            @RequestParam(name = "paymentStatus", required = false) String paymentStatus,
            @RequestParam(name = "transactionId", required = false) String transactionId,
            @RequestParam(name = "transactionDate", required = false) Timestamp transactionDate
    ){
        try {
            UserPaymentMethod updatedUserPayment = userPaymentService.updateUserPaymentMethod(id, clientName, paymentStatus, transactionId, transactionDate);
            return ResponseEntity.ok(updatedUserPayment);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Delete a user payment by id
    @DeleteMapping("/{id}")
    public ResponseEntity<UserPaymentMethod> deleteUserPaymentMethod(@PathVariable int id){
        try {
            UserPaymentMethod deletedUserPayment = userPaymentService.deleteUserPaymentMethod(id);
            return ResponseEntity.ok(deletedUserPayment);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Delete all user payments by user id
    @DeleteMapping("/user/{userId}")
    public ResponseEntity<List<UserPaymentMethod>> deleteUserPaymentMethodByUserId(@PathVariable int userId)
    {
        try {
            List<UserPaymentMethod> deletedUserPayments = userPaymentService.deleteUserPaymentMethodByUserId(userId);
            return ResponseEntity.ok(deletedUserPayments);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}