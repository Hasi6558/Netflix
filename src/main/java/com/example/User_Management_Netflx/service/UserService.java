package com.example.User_Management_Netflx.service;

import com.example.User_Management_Netflx.dto.ApiResponse;
import com.example.User_Management_Netflx.dto.UserDTO;
import com.example.User_Management_Netflx.entity.Role;
import com.example.User_Management_Netflx.entity.User;
import com.example.User_Management_Netflx.repo.RoleRepo;
import com.example.User_Management_Netflx.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.hibernate.type.descriptor.sql.internal.NativeEnumDdlTypeImpl;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerNewUser(UserDTO userDTO){
        return userRepo.save(modelMapper.map(userDTO, User.class));
    }


    public ApiResponse updateUser(UserDTO userDTO){

            if(userRepo.existsById(userDTO.getUsername())){
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

}
