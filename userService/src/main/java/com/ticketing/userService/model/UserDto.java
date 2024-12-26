package com.ticketing.userService.model;

import java.util.List;

public class UserDto {
    private String username;
    private String fullName;
    private List<String> roles;

    // Constructors
    public UserDto() {
    }

    public UserDto(String username, String fullName, List<String> roles) {
        this.username = username;
        this.fullName = fullName;
        this.roles = roles;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", roles=" + roles +
                '}';
    }
}

