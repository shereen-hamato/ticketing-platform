package com.ticketing.userService.controller;

import com.ticketing.userService.entity.UserAccountDetails;
import com.ticketing.userService.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {


    @GetMapping()
    public ResponseEntity<String> getHelloPage(){

        return ResponseEntity.ok("Hello world!");
    }

}
