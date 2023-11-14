package com.truthwear.truthwear.service.interfaces;

import com.truthwear.truthwear.entity.UserPaymentMethod;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;
import java.util.List;

public interface UserPaymentService {
    ResponseEntity<List<UserPaymentMethod>> getAllUserPayments();

    ResponseEntity<List<UserPaymentMethod>> getAllUserPaymentsById(int id);

    ResponseEntity<List<UserPaymentMethod>> getAllUserPaymentsByUserId(int userId);

    ResponseEntity<UserPaymentMethod> createUserPaymentMethod(UserPaymentMethod userPaymentMethod);

    ResponseEntity<UserPaymentMethod> updateUserPaymentMethod(int id, String clientName, String paymentStatus, String transactionId, Timestamp transactionDate);

    ResponseEntity<UserPaymentMethod> deleteUserPaymentMethod(int id);

    ResponseEntity<List<UserPaymentMethod>> deleteUserPaymentMethodByUserId(int userId);
}
