package com.truthwear.truthwear.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public String toString() {
        return "UserPaymentMethod{" +
                "id=" + id +
                ", userId=" + userId +
                ", clientName='" + clientName + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
