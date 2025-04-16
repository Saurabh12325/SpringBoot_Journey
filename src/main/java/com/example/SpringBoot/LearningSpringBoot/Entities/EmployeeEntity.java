package com.example.SpringBoot.LearningSpringBoot.Entities;

import com.example.SpringBoot.LearningSpringBoot.CustomAnnotation.EmployeeRoleValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
@Table(name = "Emplyee")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

 @NotBlank(message = "name should not be blank")
 @Size(min = 3 ,max = 7 , message = "size of the name lie between this range")
    private  String name ;
 @Email(message = "email should be in the correct way")
    private String email;
 @NotNull(message = "role is not null")
// @Pattern(regexp = "^(USER|ADMIN)$",message = "R0le of the employee can be USER OR ADMIN")
 @EmployeeRoleValidation // here i am using the custom role validator
 private String role;
    private String age;
    private LocalDate dateOfJoining;
    @JsonProperty("isActive")
    private boolean isActive;
}
