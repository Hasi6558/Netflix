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
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;


    public ApiResponse saveUser(UserDTO userDTO){
            if (userRepo.existsById(userDTO.getId())){
                return new ApiResponse(false,"User is already exist");
            }else {
                userRepo.save(modelMapper.map(userDTO, User.class));
                return new ApiResponse(true,"User registration success");
            }
    }

    public boolean authenticate(String username,String password){
        Optional<User> userOpt =userRepo.findByUsername(username);
        if (userOpt.isPresent()){
            User user =userOpt.get();
            return user.getPassword().equals(password);
        }
        return false;
    }

    public ApiResponse updateUser(UserDTO userDTO){

            if(userRepo.existsById(userDTO.getId())){
                userRepo.save(modelMapper.map(userDTO,User.class));
                return new ApiResponse(true,"User update success");
            }else {
                return new ApiResponse(false,"User not found");
            }

    }

    public List<UserDTO> getAllUsers(){
        List<User>userList = userRepo.findAll();
        return modelMapper.map(userList,new TypeToken<List<UserDTO>>(){}.getType());
    }

    public User getUserById(int id){
        return  userRepo.findById(id).orElse(null);
    }


}
