package com.example.User_Management_Netflx.service;

import com.example.User_Management_Netflx.dto.ApiResponse;
import com.example.User_Management_Netflx.dto.ContentDTO;
import com.example.User_Management_Netflx.entity.Content;
import com.example.User_Management_Netflx.repo.ContentRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<ContentDTO> getAllContent(){
        List<Content>contentList = contentRepo.findAll();
        return modelMapper.map(contentList,new TypeToken<List<ContentDTO>>(){}.getType());
    }
    public List<ContentDTO> getAllContentsByTitle(String title){
        List<Content> contentList = contentRepo.getContentsByTitle(title);
        return modelMapper.map(contentList,new TypeToken<List<ContentDTO>>(){}.getType());
    }

    public ContentDTO getContentById(String contentId){
        Content content =contentRepo.getContentById(contentId);
        return modelMapper.map(content, ContentDTO.class);
    }

    public ApiResponse updateContent(ContentDTO contentDTO){
        contentRepo.save(modelMapper.map(contentDTO,Content.class));
        return new ApiResponse(true,"Successfully updated the Content");
    }

    public ApiResponse deleteContent(Integer contentId){
        contentRepo.deleteById(contentId);
        return new ApiResponse(true,"Successfully deleted the content");
    }

}
