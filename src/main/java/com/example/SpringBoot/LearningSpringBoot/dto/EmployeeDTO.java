package com.example.SpringBoot.LearningSpringBoot.dto;

import com.example.SpringBoot.LearningSpringBoot.CustomAnnotation.EmployeeRoleValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @NotBlank(message = "name should not be blank")
    @Size(min = 3 ,max = 7 , message = "size of the name lie between this range")
    private  String name ;
    @Email(message = "email should be in the correct way")
    private String email;
    @NotNull(message = "role is not null")
// @Pattern(regexp = "^(USER|ADMIN)$",message = "R0le of the employee can be USER OR ADMIN")
    @EmployeeRoleValidation(message = "Role is Admin or user only ") // here i am using the custom role validator
    private String role;
    private String age;
    private LocalDate dateOfJoining;
    @JsonProperty("isActive")
    private boolean isActive;

}
