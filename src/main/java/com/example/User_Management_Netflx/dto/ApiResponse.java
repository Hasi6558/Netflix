package com.example.User_Management_Netflx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data


public class ApiResponse {
    private final Object data;
    private boolean success;
    private String message;

    public ApiResponse(boolean success, String message) {
        this(success, message, null);
    }
    public ApiResponse(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

}

