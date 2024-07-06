package com.example.User_Management_Netflx.service;

import com.example.User_Management_Netflx.dto.ApiResponse;
import com.example.User_Management_Netflx.dto.UserDTO;
import com.example.User_Management_Netflx.entity.User;
import com.example.User_Management_Netflx.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;


    public ApiResponse saveUser(UserDTO userDTO){
        try{
            userRepo.save(modelMapper.map(userDTO, User.class));
            return new ApiResponse(true,"User registration successful");
        }catch (Exception e){
            return new ApiResponse(false,"User registration failed"+e.getMessage());
        }


    }

    public List<UserDTO> getAllUsers(){
        List<User>userList = userRepo.findAll();
        return modelMapper.map(userList,new TypeToken<List<UserDTO>>(){}.getType());
    }
}
