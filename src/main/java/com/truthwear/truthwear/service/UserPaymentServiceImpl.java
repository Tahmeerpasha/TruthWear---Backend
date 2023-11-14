package com.truthwear.truthwear.service;


import com.truthwear.truthwear.entity.UserPaymentMethod;
import com.truthwear.truthwear.repository.UserPaymentMethodRepository;
import com.truthwear.truthwear.service.interfaces.UserPaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

@Service
public class UserPaymentServiceImpl implements UserPaymentService {
    private final UserPaymentMethodRepository userPaymentMethodRepository;

    public UserPaymentServiceImpl(UserPaymentMethodRepository userPaymentMethodRepository) {
        this.userPaymentMethodRepository = userPaymentMethodRepository;
    }

    @Override
    public ResponseEntity<List<UserPaymentMethod>> getAllUserPayments() {
        return ResponseEntity.ok(userPaymentMethodRepository.findAll());
    }

    @Override
    public ResponseEntity<List<UserPaymentMethod>> getAllUserPaymentsById(int id) {
        return ResponseEntity.ok(userPaymentMethodRepository.findAllById(Collections.singleton(id)));
    }

    @Override
    public ResponseEntity<List<UserPaymentMethod>> getAllUserPaymentsByUserId(int userId) {
        return ResponseEntity.ok(userPaymentMethodRepository.findAllByUserId(userId));
    }

    @Override
    public ResponseEntity<UserPaymentMethod> createUserPaymentMethod(UserPaymentMethod userPaymentMethod) {
        return ResponseEntity.ok(userPaymentMethodRepository.save(userPaymentMethod));
    }

    @Override
    public ResponseEntity<UserPaymentMethod> updateUserPaymentMethod(int id, String clientName, String paymentStatus,
                                                                     String transactionId, Timestamp transactionDate) {
        UserPaymentMethod userPaymentMethod = userPaymentMethodRepository.findById(id).get();
        if (clientName != null)userPaymentMethod.setClientName(clientName);
        if (paymentStatus != null)userPaymentMethod.setPaymentStatus(paymentStatus);
        if (transactionId != null)userPaymentMethod.setTransactionId(transactionId);
        if (transactionDate != null)userPaymentMethod.setTransactionDate(transactionDate);
        return ResponseEntity.ok(userPaymentMethodRepository.save(userPaymentMethod));
    }

    @Override
    public ResponseEntity<UserPaymentMethod> deleteUserPaymentMethod(int id) {
        UserPaymentMethod userPaymentMethod = userPaymentMethodRepository.findById(id).get();
        userPaymentMethodRepository.delete(userPaymentMethod);
        return ResponseEntity.ok(userPaymentMethod);
    }

    @Override
    public ResponseEntity<List<UserPaymentMethod>> deleteUserPaymentMethodByUserId(int userId) {
        List<UserPaymentMethod> userPaymentMethod = userPaymentMethodRepository.findAllByUserId(userId);
        userPaymentMethodRepository.deleteAll(userPaymentMethod);
        return ResponseEntity.ok(userPaymentMethod);
    }
}
