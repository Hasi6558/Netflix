package com.example.netflix.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Review {
    @Id
    private Long id;
    private Long contentId;
    private String username;
    private String comment;
    private int rating;
}
