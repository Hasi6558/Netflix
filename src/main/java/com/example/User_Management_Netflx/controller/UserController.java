package com.example.User_Management_Netflx.controller;


import com.example.User_Management_Netflx.dto.ApiResponse;
import com.example.User_Management_Netflx.dto.UserDTO;
import com.example.User_Management_Netflx.entity.User;
import com.example.User_Management_Netflx.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/v1/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostConstruct
    public void initRolesAndUsers(){
        userService.initRolesAndUser();
    }


    @GetMapping("/getUsers")
    public List<UserDTO> getUser(){
        return userService.getAllUsers();
    }
    @PostMapping("/registerNewUser")
    public User registerNewUser(@RequestBody UserDTO userDTO){
        return userService.registerNewUser(userDTO);

    }

    @GetMapping("/forAdmin")
    public String forAdmin(){
        return "This URL is only accessible to admin";
    }
    @GetMapping("/forUser")
    public String forUser(){
        return "This URL nly accessible for user";
    }


//    @PostMapping("/registerNewUser")
//    public ResponseEntity<ApiResponse> registerNewUser(@RequestBody UserDTO userDTO){
//        ApiResponse response =   userService.registerNewUser(userDTO);
//        if (response.isSuccess()){
//            return ResponseEntity.ok(response);
//        }else {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
//        }
//    }

    @PutMapping("/updateProfile")
    public ResponseEntity<ApiResponse> updateUser(@RequestBody UserDTO userDTO){
        ApiResponse response= userService.updateUser(userDTO);
        if (response.isSuccess()){
            return ResponseEntity.ok(response);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }


}
