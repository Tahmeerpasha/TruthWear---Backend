package com.truthwear.truthwear.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user_address")
public class UserAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "address_id")
    private int addressId;

    @Column(name = "is_default")
    private int isDefault;

    public UserAddress() {
    }

    public UserAddress(int userId, int addressId, int isDefault) {
        this.userId = userId;
        this.addressId = addressId;
        this.isDefault = isDefault;
    }
}
