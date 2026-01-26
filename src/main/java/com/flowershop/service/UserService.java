package com.flowershop.service;

import com.flowershop.model.User;

import java.util.List;

public interface UserService {
    User registerUser(User user);
    User loginUser(String email, String password);
    User getUserById(String userId);
    List<User> getAllUsers();
    void deleteUser(String userId);
}
