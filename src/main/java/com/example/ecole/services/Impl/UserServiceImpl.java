package com.example.ecole.services.Impl;


import com.example.ecole.entity.Role;
import com.example.ecole.entity.User;
import com.example.ecole.repositories.UserRepository;
import com.example.ecole.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.regex.Pattern.matches;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.orElse(null);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(int userId, User userDetails) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            user.setRole(userDetails.getRole());
            user.setDateJoined(userDetails.getDateJoined());
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }
    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public long countByRole(Role role) {
        return userRepository.countByRole(role);
    }



}
