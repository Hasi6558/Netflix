package com.example.User_Management_Netflx.controller;

import com.example.User_Management_Netflx.dto.ApiResponse;
import com.example.User_Management_Netflx.dto.ContentDTO;
import com.example.User_Management_Netflx.dto.UserDTO;
import com.example.User_Management_Netflx.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/content")
@CrossOrigin
public class ContentController {
    @Autowired
    private ContentService contentService;
    @PostMapping("/saveContent")
    public ResponseEntity<ApiResponse> saveContent(@RequestBody ContentDTO contentDTO){
        ApiResponse response = contentService.saveContent(contentDTO);
        if (response.isSuccess()){
            return ResponseEntity.ok(response);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
    @GetMapping("/getAllContent")
    public List<ContentDTO> getUser(){
        return contentService.getAllContent();
    }

    @GetMapping("/getAllContentsByTitle/{title}")
    public List<ContentDTO> getAllContentsByTitle(@PathVariable String title){
        return contentService.getAllContentsByTitle(title);
    }
    @GetMapping("/getContentById/{contentId}")
    public ContentDTO getContentById(@PathVariable String contentId){
        return contentService.getContentById(contentId);
    }
}
