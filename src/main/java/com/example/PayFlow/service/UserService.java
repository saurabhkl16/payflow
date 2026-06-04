package com.example.PayFlow.service;

import com.example.PayFlow.entity.User;
import com.example.PayFlow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user){
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long userId){
        return userRepository.findById(userId).
                orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
    }

    public User findByUpiId(String upiId){
        return userRepository.findByUpiId(upiId).
                orElseThrow(() -> new RuntimeException("User not found with id: " + upiId));
    }
}
