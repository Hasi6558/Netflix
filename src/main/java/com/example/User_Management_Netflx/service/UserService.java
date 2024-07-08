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
import java.util.Set;

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

    public void initRolesAndUser(){
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleRepo.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleRepo.save(userRole);

        User adminUser = new User();
        adminUser.setFirst_name("admin");
        adminUser.setLast_name("admin");
        adminUser.setUsername("admin123");
        adminUser.setPassword(getEncodedPassword("admin@pass"));
        adminUser.setEmail("admin@netflix.com");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userRepo.save(adminUser);

        User user = new User();
        user.setFirst_name("hasindu");
        user.setLast_name("shehan");
        user.setUsername("user123");
        user.setPassword(getEncodedPassword("Hasidnu1234H"));
        user.setEmail("hasindus48@gmail.com");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRole(userRoles);
        userRepo.save(user);

    }




//    public ApiResponse registerNewUser(UserDTO userDTO){
//            if (userRepo.existsById(userDTO.getId())){
//                return new ApiResponse(false,"User is already exist");
//            }else {
//                userRepo.save(modelMapper.map(userDTO, User.class));
//                return new ApiResponse(true,"User registration success");
//            }
//    }

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

    public String getEncodedPassword(String password){
        return passwordEncoder.encode(password);
    }
}
