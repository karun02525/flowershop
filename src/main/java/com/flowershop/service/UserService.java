package com.flowershop.service;

import com.flowershop.model.User;

import java.util.List;

public interface UserService {
    User registerUser(User user);
    User getUserById(String userId);
    List<User> getAllUsers();
    void deleteUser(String userId);
}
