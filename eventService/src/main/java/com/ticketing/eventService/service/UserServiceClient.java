package com.ticketing.eventService.service;


import com.ticketing.eventService.Model.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")
public interface UserServiceClient {

    @GetMapping("/users/{username}")
    UserDto getUserDetails(@PathVariable("username") String username);
}

