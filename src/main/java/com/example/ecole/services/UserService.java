package com.example.ecole.services;

import com.example.ecole.entity.Role;
import com.example.ecole.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(int userId);
    User createUser(User user);
    User updateUser(int userId, User userDetails);
    void deleteUser(int userId);
    User findByEmail(String email);
    long countByRole(Role role);
}
