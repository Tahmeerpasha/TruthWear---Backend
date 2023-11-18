package com.truthwear.truthwear.service.interfaces;

import com.truthwear.truthwear.entity.UserPaymentMethod;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;
import java.util.List;

public interface UserPaymentService {
    List<UserPaymentMethod> getAllUserPayments();

    List<UserPaymentMethod> getAllUserPaymentsById(int id);

    List<UserPaymentMethod> getAllUserPaymentsByUserId(int userId);

    UserPaymentMethod createUserPaymentMethod(UserPaymentMethod userPaymentMethod);

    UserPaymentMethod updateUserPaymentMethod(int id, String clientName, String paymentStatus, String transactionId, Timestamp transactionDate);

    UserPaymentMethod deleteUserPaymentMethod(int id);

    List<UserPaymentMethod> deleteUserPaymentMethodByUserId(int userId);
}
