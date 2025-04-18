package com.example.SpringBoot.LearningSpringBoot.advices;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
public class ApiResponse<T> {

    private LocalDateTime timestamp;
    private T data;
    private ApiError error;

    public ApiResponse(ApiError error) {
        this();
        this.error = error;
    }

    public ApiResponse(T data) {
        this();
        this.data = data;
    }

    public ApiResponse() {
        this.timestamp = LocalDateTime.now();
    }


}
