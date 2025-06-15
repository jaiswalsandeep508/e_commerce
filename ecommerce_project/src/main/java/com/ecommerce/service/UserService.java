package com.ecommerce.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.ecommerce.entity.User;
import com.ecommerce.repository.UserRepository;
import jakarta.transaction.Transactional;

//✅ Uses @Service → Marks this class as a service. 
//✅ Uses @Transactional → Ensures database consistency. 
//✅ Handles user registration & lookup by email.

@Service
@Transactional  // Ensures atomic transactions
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
