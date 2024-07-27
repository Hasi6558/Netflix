package com.example.User_Management_Netflx.service;

import com.example.User_Management_Netflx.dto.ApiResponse;
import com.example.User_Management_Netflx.dto.ReviewsDTO;
import com.example.User_Management_Netflx.entity.Reviews;
import com.example.User_Management_Netflx.repo.ReviewRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ReviewsService {
    @Autowired
    private ReviewRepo reviewRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<ReviewsDTO> getReviews(int movieId){
        List<Reviews>reviewsList = reviewRepo.findAllByMovieId(movieId);
        return modelMapper.map(reviewsList,new TypeToken<List<ReviewsDTO>>(){}.getType());
    }

    public ApiResponse saveReview(ReviewsDTO reviewsDTO){
        if (reviewRepo.existsById(reviewsDTO.getId())){
            return new ApiResponse(false,"Review already Exists");
        }else {
            reviewRepo.save(modelMapper.map(reviewsDTO, Reviews.class));
            return new ApiResponse(true,"Successfully saved the Review");
        }
    }
    public ApiResponse deleteContent(Integer reviewId){
        reviewRepo.deleteById(reviewId);
        return new ApiResponse(true,"Successfully deleted the review");
    }

}
