package com.truthwear.truthwear.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user_payment_method")
public class UserPaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private SiteUser user;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "payment_status")
    private String paymentStatus;

    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "transaction_date")
    private Timestamp transactionDate;


    public UserPaymentMethod(SiteUser user, String clientName, String paymentStatus, String transactionId, Timestamp transactionDate) {
        this.user = user;
        this.clientName = clientName;
        this.paymentStatus = paymentStatus;
        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
    }
}
