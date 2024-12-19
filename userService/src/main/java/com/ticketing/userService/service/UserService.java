package com.ticketing.userService.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ticketing.userService.entity.UserAccountDetails;
import com.ticketing.userService.repository.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserAccountDetails registerUser(UserAccountDetails user){
        Optional<UserAccountDetails> existingUser = userRepository.findByEmail(user.getEmail());
        if(existingUser.isPresent()){
            throw new RuntimeException("Email is already registered.");
        }
        return userRepository.save(user);
    }

    public UserAccountDetails getUserById(Long id){
        return userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found."));
    }
}
