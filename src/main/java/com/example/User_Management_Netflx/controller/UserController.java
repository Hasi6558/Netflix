package com.example.User_Management_Netflx.controller;


import com.example.User_Management_Netflx.dto.ApiResponse;
import com.example.User_Management_Netflx.dto.UserDTO;
import com.example.User_Management_Netflx.entity.User;
import com.example.User_Management_Netflx.service.UserService;
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

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> saveUser(@RequestBody UserDTO userDTO){
        ApiResponse response =   userService.saveUser(userDTO);
        if (response.isSuccess()){
            return ResponseEntity.ok(response);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @PutMapping("/updateProfile")
    public ResponseEntity<ApiResponse> updateUser(@RequestBody UserDTO userDTO){
        ApiResponse response= userService.updateUser(userDTO);
        if (response.isSuccess()){
            return ResponseEntity.ok(response);
        }else {
              return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @GetMapping("getUserProfile/{id}")
    public User getProfileDetails(@PathVariable int id){
        return userService.getUserById(id);
    }

    @GetMapping("/getAllUsers")
    public List<UserDTO> getUser(){
        return userService.getAllUsers();
    }



}
