package com.example.User_Management_Netflx.service;

import com.example.User_Management_Netflx.dto.ApiResponse;
import com.example.User_Management_Netflx.dto.SubscriptionDTO;
import com.example.User_Management_Netflx.entity.Subscription;
import com.example.User_Management_Netflx.repo.SubscriptionRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepo subscriptionRepo;

    @Autowired
    private ModelMapper modelMapper;

    public ApiResponse createSubscription(SubscriptionDTO subscriptionDTO) {

        if (subscriptionRepo.existsByUserId(subscriptionDTO.getUserId())) {
            return new ApiResponse(false, "User is already subscibed");
        } else {
            subscriptionRepo.save(modelMapper.map(subscriptionDTO, Subscription.class));

            return new ApiResponse(true, "Subscription by user : " + subscriptionDTO.getUserId() + " is successfull");

        }

    }
}
