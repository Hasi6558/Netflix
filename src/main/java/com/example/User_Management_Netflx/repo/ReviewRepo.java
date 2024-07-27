package com.example.User_Management_Netflx.repo;

import com.example.User_Management_Netflx.entity.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepo extends JpaRepository<Reviews, Integer> {
}
