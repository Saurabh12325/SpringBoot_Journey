package com.example.SpringBoot.LearningSpringBoot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private  Long id;
    private  String name ;
    private String email;
    private String age;
    private LocalDate dateOfJoining;
    @JsonProperty("isActive")
    private boolean isActive;

}
