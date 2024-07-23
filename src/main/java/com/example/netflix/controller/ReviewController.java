package com.example.netflix.controller;

import com.example.netflix.dto.ReviewDto;
import com.example.netflix.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="api/reviews/")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/getreviews")
    public List<ReviewDto> getReviews(){
        return reviewService.getAllReviews();
    }
    @PostMapping("/addreview")
    public ReviewDto saveReview(@RequestBody ReviewDto reviewDto){
        return reviewService.saveReview(reviewDto);
    }

    @PutMapping("/updatereview")
    public ReviewDto updateReview(@RequestBody ReviewDto reviewDto){
        return reviewService.updateReview(reviewDto);
    }

    @DeleteMapping("/deletereview")
    public String deleteReview(@RequestBody ReviewDto reviewDto){
        return reviewService.deleteReview(reviewDto);
    }
}
