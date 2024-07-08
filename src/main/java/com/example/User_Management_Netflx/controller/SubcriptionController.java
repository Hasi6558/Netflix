package com.example.User_Management_Netflx.controller;

import com.example.User_Management_Netflx.dto.ApiResponse;
import com.example.User_Management_Netflx.dto.SubscriptionDTO;
import com.example.User_Management_Netflx.entity.Subscription;
import com.example.User_Management_Netflx.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="api/v1/subscription")
@CrossOrigin
public class SubcriptionController {

    @Autowired
    private SubscriptionService subscriptionService;


    @PostMapping("/subscribe")
    public ResponseEntity<ApiResponse> createSubscription(@RequestBody SubscriptionDTO subscriptionDTO){
        ApiResponse response = subscriptionService.createSubscription(subscriptionDTO);

        if (response.isSuccess()){
            return ResponseEntity.ok(response);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
