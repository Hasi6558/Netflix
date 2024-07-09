package com.example.User_Management_Netflx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContentDTO {
    private int id;
    private String title;
    private int releaseYear;
    private String genre;
    private String type;
    private String posterUrl;
    private String embedUrl;
}
