package com.example.SpringBoot.LearningSpringBoot.advices;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
@Builder
public class ApiError {
    private HttpStatus httpstatus;
    private String message;
}
