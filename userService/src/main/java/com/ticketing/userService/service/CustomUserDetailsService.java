package com.ticketing.userService.service;

import com.ticketing.userService.entity.UserAccountDetails;
import com.ticketing.userService.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userAccountDetailsRepository; // Assuming your repository is named UserAccountDetailsRepository

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch the user from the database based on the username (email in this case)
        Optional<UserAccountDetails> user = userAccountDetailsRepository.findByEmail(username);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        // Return UserDetails object with username, password, and authorities (roles)
        return User.builder()
                .username(user.get().getEmail())
                .password(user.get().getPassword())
                .roles(user.get().getRole()) // Assuming user.getRole() returns a single role. If you have multiple roles, you may need to adjust this.
                .build();
    }
}

