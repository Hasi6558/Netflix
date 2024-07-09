package com.example.User_Management_Netflx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SubscriptionDTO {

    private int id;
    private int userId;
    private LocalDate startDate;
    private LocalDate endDate;
}
