package com.ticketing.userService.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticketing.userService.entity.UserAccountDetails;
import com.ticketing.userService.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;
    PasswordEncoder passwordEncoder;

 
    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }


    @PostMapping("/register")
    public ResponseEntity<UserAccountDetails> registerUser(@RequestBody UserAccountDetails user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
            return ResponseEntity.ok(userService.registerUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAccountDetails> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }


    @GetMapping("/profile")
    public ResponseEntity<?> getUserProfile(@AuthenticationPrincipal String username) {
        return ResponseEntity.ok("Welcome, " + username);
    }

}
