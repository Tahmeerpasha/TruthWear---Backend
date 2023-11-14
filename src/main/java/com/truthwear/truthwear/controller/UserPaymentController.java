package com.truthwear.truthwear.controller;

import com.truthwear.truthwear.entity.ShoppingCartItem;
import com.truthwear.truthwear.entity.UserPaymentMethod;
import com.truthwear.truthwear.service.ShoppingCartItemServiceImpl;
import com.truthwear.truthwear.service.UserPaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserPaymentController {
    private final UserPaymentServiceImpl userPaymentService;

    @Autowired
    public UserPaymentController(UserPaymentServiceImpl userPaymentService) {
        this.userPaymentService = userPaymentService;
    }

    @GetMapping("/user_payments")
    ResponseEntity<List<UserPaymentMethod>> getAllUserPayments() {
        return userPaymentService.getAllUserPayments();
    }

    @GetMapping("/user_payments/{id}")
    ResponseEntity<List<UserPaymentMethod>> getAllUserPaymentsById(@PathVariable int id) {
        return userPaymentService.getAllUserPaymentsById(id);
    }
    @GetMapping("/user_payments/user/{userId}")
    ResponseEntity<List<UserPaymentMethod>> getAllUserPaymentsByUserId(@PathVariable int userId) {
        return userPaymentService.getAllUserPaymentsByUserId(userId);
    }
    @PostMapping("/user_payments")
    ResponseEntity<UserPaymentMethod> createUserPaymentMethod(@RequestBody UserPaymentMethod userPaymentMethod){
        return userPaymentService.createUserPaymentMethod(userPaymentMethod);
    }

    @PutMapping("/user_payments/{id}")
    ResponseEntity<UserPaymentMethod> updateUserPaymentMethod(@PathVariable int id,
                                                            @RequestParam(name = "clientName", required = false) String  clientName,
                                                            @RequestParam(name = "paymentStatus", required = false) String paymentStatus,
                                                            @RequestParam(name = "transactionId", required = false) String transactionId,
                                                                @RequestParam(name = "transactionDate", required = false) Timestamp transactionDate
    ){
        return userPaymentService.updateUserPaymentMethod(id,clientName,paymentStatus,transactionId,transactionDate);
    }

    @DeleteMapping("/user_payments/{id}")
    ResponseEntity<UserPaymentMethod> deleteUserPaymentMethod(@PathVariable int id){
        return userPaymentService.deleteUserPaymentMethod(id);
    }

    @DeleteMapping("/user_payments/user/{userId}")
    ResponseEntity<List<UserPaymentMethod>> deleteUserPaymentMethodByUserId(@PathVariable int userId)
    {
        return userPaymentService.deleteUserPaymentMethodByUserId(userId);
    }
}