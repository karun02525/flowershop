package com.flowershop.service.impl;

import com.flowershop.model.User;
import com.flowershop.repository.UserRepository;
import com.flowershop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        if (!validateUserData(user.getFirstName())) {
            throw new RuntimeException("Invalid user data");
        }
        // Automatically set the creation timestamp
        user.setCreatedAtNow();
        return userRepository.save(user);
    }

    @Override
    public User getUserById(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(String userId) {
         userRepository.deleteById(userId);
    }

    private boolean validateUserData(String name) {
        return name !=null && !name.isEmpty();
    }

}
