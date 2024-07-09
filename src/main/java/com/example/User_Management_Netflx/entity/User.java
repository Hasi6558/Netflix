package com.example.User_Management_Netflx.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {


//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int id;
    @Id

    private String first_name;
    private String last_name;
    private String email;
    private String password;

}
