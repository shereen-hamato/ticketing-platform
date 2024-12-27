package com.ticketing.eventService.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {


    @GetMapping()
    public ResponseEntity<String> getHelloPage(){

        return ResponseEntity.ok("Hello world!");
    }

}
