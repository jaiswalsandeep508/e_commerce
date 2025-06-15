package com.ecommerce.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ecommerce.entity.User;

//✅ @Repository 
//   → Marks this interface as a Spring Data repository. 
//✅ JpaRepository<User, Long> 
//   → Handles database operations for the User entity using Long as ID. 
//✅ findByEmail(String email) 
//   → Custom method to find a user by email.

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	// Find user by email
    Optional<User> findByEmail(String email);
}
