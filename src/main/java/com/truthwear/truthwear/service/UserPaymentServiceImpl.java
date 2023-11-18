package com.truthwear.truthwear.service;

import com.truthwear.truthwear.entity.UserPaymentMethod;
import com.truthwear.truthwear.repository.UserPaymentMethodRepository;
import com.truthwear.truthwear.service.interfaces.UserPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserPaymentServiceImpl implements UserPaymentService {

    private final UserPaymentMethodRepository userPaymentMethodRepository;

    // Get all user payments
    @Override
    public List<UserPaymentMethod> getAllUserPayments() {
        return userPaymentMethodRepository.findAll();
    }

    // Get a specific user payment by id
    @Override
    public List<UserPaymentMethod> getAllUserPaymentsById(int id) {
        return userPaymentMethodRepository.findAllById(Collections.singleton(id));
    }

    // Get all user payments by user id
    @Override
    public List<UserPaymentMethod> getAllUserPaymentsByUserId(int userId) {
        return userPaymentMethodRepository.findAllByUserId(userId);
    }

    // Create a new user payment
    @Override
    public UserPaymentMethod createUserPaymentMethod(UserPaymentMethod userPaymentMethod) {
        return userPaymentMethodRepository.save(userPaymentMethod);
    }

    // Update an existing user payment
    @Override
    public UserPaymentMethod updateUserPaymentMethod(int id, String clientName, String paymentStatus,
                                                     String transactionId, Timestamp transactionDate) {
        Optional<UserPaymentMethod> userPaymentMethodOptional = userPaymentMethodRepository.findById(id);
        if (userPaymentMethodOptional.isEmpty()) {
            return null;
        }
        UserPaymentMethod userPaymentMethod = userPaymentMethodOptional.get();
        if (clientName != null) {
            userPaymentMethod.setClientName(clientName);
        }
        if (paymentStatus != null) {
            userPaymentMethod.setPaymentStatus(paymentStatus);
        }
        if (transactionId != null) {
            userPaymentMethod.setTransactionId(transactionId);
        }
        if (transactionDate != null) {
            userPaymentMethod.setTransactionDate(transactionDate);
        }
        return userPaymentMethodRepository.save(userPaymentMethod);
    }

    // Delete a user payment by id
    @Override
    public UserPaymentMethod deleteUserPaymentMethod(int id) {
        Optional<UserPaymentMethod> userPaymentMethodOptional = userPaymentMethodRepository.findById(id);
        if (userPaymentMethodOptional.isEmpty()) {
            return null;
        }
        UserPaymentMethod userPaymentMethod = userPaymentMethodOptional.get();
        userPaymentMethodRepository.delete(userPaymentMethod);
        return userPaymentMethod;
    }

    // Delete all user payments by user id
    @Override
    public List<UserPaymentMethod> deleteUserPaymentMethodByUserId(int userId) {
        List<UserPaymentMethod> userPaymentMethods = userPaymentMethodRepository.findAllByUserId(userId);
        if (userPaymentMethods != null && !userPaymentMethods.isEmpty()) {
            userPaymentMethodRepository.deleteAll(userPaymentMethods);
        }
        return userPaymentMethods;
    }
}