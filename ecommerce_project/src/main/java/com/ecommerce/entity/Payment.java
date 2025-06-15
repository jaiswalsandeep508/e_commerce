package com.ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Links payments to orders using a @OneToOne relationship. 
//✅ Stores payment method (Credit Card, PayPal, Stripe) & status (Success, Failed, Pending).

@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column(nullable = false)
    private String method;  // Possible values: "CREDIT_CARD", "PAYPAL", "STRIPE"

    @Column(nullable = false)
    private String status;  // Possible values: "SUCCESS", "FAILED", "PENDING"
    
 // Manually defined constructor to match service call
    public Payment(Long id, Order order, String method, String status) {
        this.id = id;
        this.order = order;
        this.method = method;
        this.status = status;
    }
}