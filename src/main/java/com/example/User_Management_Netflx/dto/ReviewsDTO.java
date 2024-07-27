package com.example.User_Management_Netflx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewsDTO {
    private int id;
    private int userId;
    private int movieId;
    private int rating;
    private String content;
}
