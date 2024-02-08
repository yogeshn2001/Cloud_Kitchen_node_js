package com.karthik.cloudkitchen.repository;
// UserRepository.java
import org.springframework.data.jpa.repository.JpaRepository;

import com.karthik.cloudkitchen.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByUsernameAndPassword(String username, String password);
}

