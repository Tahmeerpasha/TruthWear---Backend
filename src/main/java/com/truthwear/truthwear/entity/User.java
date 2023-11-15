package com.truthwear.truthwear.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "site_user")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "user_password")
    private String password;

    public User() {
    }

    public User(String firstName, String lastName, String emailId, String phoneNumber, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
}
