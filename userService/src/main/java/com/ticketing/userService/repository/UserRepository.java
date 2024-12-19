package com.ticketing.userService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ticketing.userService.entity.UserAccountDetails;

@Repository
public interface UserRepository  extends JpaRepository<UserAccountDetails,Long> {

    public Optional<UserAccountDetails> findByEmail(String email);
}
