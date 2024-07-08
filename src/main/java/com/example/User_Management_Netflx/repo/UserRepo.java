package com.example.User_Management_Netflx.repo;

import com.example.User_Management_Netflx.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);
}
