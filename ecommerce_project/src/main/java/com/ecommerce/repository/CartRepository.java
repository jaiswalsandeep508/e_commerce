package com.ecommerce.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ecommerce.entity.Cart;

//✅ Links cart items to a user. 
//✅ Retrieves user’s cart for checkout.

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    // Get all cart items for a specific user
    List<Cart> findByUserId(Long userId);
}
