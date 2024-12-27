package com.ticketing.userService.controller;

import com.ticketing.userService.model.UserDto;
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

import java.util.Collections;

@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
    }


    @GetMapping("{username}")
    public ResponseEntity<UserDto> getUserDetails(@PathVariable String username) {
        // Fetch the user entity
        UserAccountDetails user = userService.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("User not found: " + username);
        }

        // Convert User entity to UserDto
        return ResponseEntity.ok(
                new UserDto(
                        user.getEmail(),
                        user.getName(),
                        Collections.singletonList(user.getRole()))
        );
    }


    @GetMapping("/profile")
    public ResponseEntity<?> getUserProfile(@AuthenticationPrincipal String username) {
        return ResponseEntity.ok("Welcome, " + username);
    }

}
