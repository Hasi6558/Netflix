package com.example.User_Management_Netflx.service;

import com.example.User_Management_Netflx.dto.ApiResponse;
import com.example.User_Management_Netflx.dto.ContentDTO;
import com.example.User_Management_Netflx.entity.Content;
import com.example.User_Management_Netflx.entity.User;
import com.example.User_Management_Netflx.repo.ContentRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ContentService {
    @Autowired
    private ContentRepo contentRepo;

    @Autowired
    private ModelMapper modelMapper;

    public ApiResponse saveContent(ContentDTO contentDTO){
        if (contentRepo.existsById(contentDTO.getId())){
            return new ApiResponse(false,"Content already Exists");
        }else {
            contentRepo.save(modelMapper.map(contentDTO, Content.class));
            return new ApiResponse(true,"Successfully added the Content");
        }
    }

}
