package com.example.SpringBoot.LearningSpringBoot.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.boot.registry.selector.spi.StrategyCreator;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;
@Data
@Entity
@Table(name = "Emplyee")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private  String name ;
    private String email;
    private String age;
    private LocalDate dateOfJoining;
    @JsonProperty("isActive")
    private boolean isActive;
}
