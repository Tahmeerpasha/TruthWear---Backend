package com.truthwear.truthwear.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "user_payment_method")
public class UserPaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "client_name")
    private String clientName;
    @Column(name = "payment_status")
    private String paymentStatus;
    @Column(name = "transaction_id")
    private String transactionId;
    @Column(name = "transaction_date")
    private Timestamp transactionDate;

    public UserPaymentMethod() {
    }
    public UserPaymentMethod(int userId, String clientName, String paymentStatus, String transactionId, Timestamp transactionDate) {
        this.userId = userId;
        this.clientName = clientName;
        this.paymentStatus = paymentStatus;
        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
    }
}
