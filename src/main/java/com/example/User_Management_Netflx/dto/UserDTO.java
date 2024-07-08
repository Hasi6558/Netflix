package com.example.User_Management_Netflx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {

    private int id;
    private String first_name;
    private String last_name;
    private String username;
    private String email;
    private String password;
    private String role;

}
