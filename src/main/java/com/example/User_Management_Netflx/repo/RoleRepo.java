package com.example.User_Management_Netflx.repo;

import com.example.User_Management_Netflx.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends CrudRepository<Role, String> {


}
