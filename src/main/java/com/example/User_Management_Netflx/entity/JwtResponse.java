package com.example.User_Management_Netflx.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor

public class JwtResponse {

    private User user;
    private String jwtToken;
}
