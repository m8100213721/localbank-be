package com.example.payment_gateway_app.service;

import com.example.payment_gateway_app.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public User saveUser(User user);

    public User getUserById(Long id);

    public void deleteUserById(Long id);
}
