package com.example.User_Management_Netflx.service;

import com.example.User_Management_Netflx.entity.Role;
import com.example.User_Management_Netflx.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;

    public Role createNewRole(Role role){
        return roleRepo.save(role);
    }

}
