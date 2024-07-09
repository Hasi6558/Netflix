package com.example.User_Management_Netflx.repo;

import com.example.User_Management_Netflx.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepo extends JpaRepository<Subscription,Integer> {
    boolean existsByUserId(int userId);
}
