package com.example.User_Management_Netflx.entity;

import jakarta.persistence.*;

public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userId;
    private int rating;
    @Lob
    @Column(columnDefinition = "COMMENT")
    private String content;
}
