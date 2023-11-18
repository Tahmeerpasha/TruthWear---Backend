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

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private SiteUser user;


    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @Column(name = "is_default")
    private Integer isDefault;

    public UserAddress() {
    }

    public UserAddress(SiteUser user, Address address, int isDefault) {
        this.user = user;
        this.address = address;
        this.isDefault = isDefault;
    }
}
