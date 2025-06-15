package com.ecommerce.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Stores order details including status (Pending, Paid, Shipped). 
//✅ Defines a relationship between User & Order (@ManyToOne). 
//✅ Automatically stores order date (@Temporal(TemporalType.TIMESTAMP)).


@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private double totalPrice;

    @Column(nullable = false)
    private String status;  // Possible values: "PENDING", "PAID", "SHIPPED"

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();
    
 // Manually defined constructor to match your call
    public Order(Long id, User user, double totalPrice, String status, Date createdAt) {
        this.id = id;
        this.user = user;
        this.totalPrice = totalPrice;
        this.status = status;
        this.createdAt = (createdAt != null) ? createdAt : new Date(); // Default to current date if null
    }
}