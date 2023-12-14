package com.truthwear.truthwear.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "shopping_cart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "user_id", unique = true)
    private SiteUser user;

    public ShoppingCart(SiteUser user) {
        this.user = user;
    }
}
