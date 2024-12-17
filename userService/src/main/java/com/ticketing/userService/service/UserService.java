package com.ticketing.userService.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ticketing.userService.entity.User;
import com.ticketing.userService.repository.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user){
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if(existingUser.isPresent()){
            throw new RuntimeException("Email is already registered.");
        }
        return userRepository.save(user);
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found."));
    }
}
