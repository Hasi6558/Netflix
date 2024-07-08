package com.example.User_Management_Netflx.entity;

import lombok.Data;

@Data
public class JwtRequest {

    private String userName;
    private String password;
}
