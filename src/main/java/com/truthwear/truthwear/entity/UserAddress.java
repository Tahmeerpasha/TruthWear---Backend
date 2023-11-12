package com.truthwear.truthwear.entity;

import jakarta.persistence.*;
@Entity
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

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(int isDefault) {
        this.isDefault = isDefault;
    }

    @Override
    public String toString() {
        return "UserAddress{" +
                "id=" + id +
                ", userId=" + userId +
                ", addressId=" + addressId +
                ", isDefault=" + isDefault +
                '}';
    }
}
