package com.ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//✅ Uses Lombok annotations to simplify the code. 
//✅ Ensures unique email and mandatory fields. 
//✅ Manages both customers and admins using the role field.

@Entity
@Table(name = "users")
@Data  // Lombok: Generates getters, setters, equals, hashCode, and toString
@NoArgsConstructor  // Lombok: No-args constructor
@AllArgsConstructor // Lombok: All-args constructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;  // Possible values: "ADMIN", "CUSTOMER"
    
}
