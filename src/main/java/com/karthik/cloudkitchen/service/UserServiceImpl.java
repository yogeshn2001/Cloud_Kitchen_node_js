package com.karthik.cloudkitchen.service;

import org.springframework.beans.factory.annotation.Autowired;
// UserServiceImpl.java
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.karthik.cloudkitchen.model.User;
import com.karthik.cloudkitchen.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Value("${registration.success.message}")
    private String registrationSuccessMessage;

    @SuppressWarnings("null")
    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User authenticateUser(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password)
                             .orElse(null);
    }

    @Override
    public String getRegistrationSuccessMessage() {
        return registrationSuccessMessage;
    }

    @Override
    public void saveUser(org.apache.catalina.User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveUser'");
    }

    @Override
    public boolean isUserExists(String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isUserExists'");
    }

    // @Override
    // public User findByUsername(String username) {
    //     return userRepository.findByUsername(username);
    // }
    public User findById(Long userId) {
        // Assuming userService has access to a UserRepository or some other mechanism to retrieve users from the database
        return userRepository.findById(userId).orElse(null);
    }
}
