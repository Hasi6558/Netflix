package com.example.netflix.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ReviewDto {
    private Long id;
    private Long contentId;
    private String username;
    private String comment;
    private int rating;
}
