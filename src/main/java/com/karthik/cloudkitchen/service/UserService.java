package com.karthik.cloudkitchen.service;

import com.karthik.cloudkitchen.model.User;

// UserService.java
public interface UserService {
    void saveUser(User user);
    User authenticateUser(String username, String password);
    String getRegistrationSuccessMessage();
    void saveUser(org.apache.catalina.User user);
    boolean isUserExists(String username);
}
