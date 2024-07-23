package com.example.netflix.service;

import com.example.netflix.dto.ReviewDto;
import com.example.netflix.model.Review;
import com.example.netflix.repository.ReviewRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<ReviewDto> getAllReviews(){
        List<Review>reviewList=reviewRepository.findAll();
        return modelMapper.map(reviewList, new TypeToken<List<ReviewDto>>(){}.getType());
    }

    public ReviewDto saveReview(ReviewDto reviewDto){
        reviewRepository.save(modelMapper.map(reviewDto, Review.class));
        return reviewDto;
    }

    public ReviewDto updateReview(ReviewDto reviewDto){
        reviewRepository.save(modelMapper.map(reviewDto,Review.class));
        return reviewDto;
    }

    public String deleteReview(ReviewDto reviewDto){
        reviewRepository.delete(modelMapper.map(reviewDto, Review.class));
        return "Review Deleted";
    }
}
