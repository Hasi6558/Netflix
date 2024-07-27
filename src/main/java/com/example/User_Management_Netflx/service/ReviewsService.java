package com.example.User_Management_Netflx.service;

import com.example.User_Management_Netflx.repo.ContentRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ReviewsService {
    @Autowired
    private ContentRepo contentRepo;

    @Autowired
    private ModelMapper modelMapper;
}
