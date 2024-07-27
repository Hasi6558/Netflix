package com.example.User_Management_Netflx.controller;

import com.example.User_Management_Netflx.dto.ApiResponse;
import com.example.User_Management_Netflx.dto.ReviewsDTO;
import com.example.User_Management_Netflx.service.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/reviews")
@CrossOrigin

public class ReviewsController {

    @Autowired
    private ReviewsService reviewsService;

    @PostMapping("/saveReview")
    public ResponseEntity<ApiResponse> saveReview(@RequestBody ReviewsDTO reviewsDTO){
        ApiResponse response = reviewsService.saveReview(reviewsDTO);
        if (response.isSuccess()){
            return ResponseEntity.ok(response);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
    @GetMapping("/getreviews/{movieId}")
    public List<ReviewsDTO> getReviews(@PathVariable int movieId){
        return reviewsService.getReviews(movieId);
    }
    @DeleteMapping("/deleteReview/{reviewId}")
    public ResponseEntity<ApiResponse> deleteContent(@PathVariable Integer reviewId){
        ApiResponse response = reviewsService.deleteContent(reviewId);
        if (response.isSuccess()){
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
