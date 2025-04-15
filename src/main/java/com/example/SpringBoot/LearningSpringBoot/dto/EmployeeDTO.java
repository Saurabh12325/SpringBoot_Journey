package com.example.SpringBoot.LearningSpringBoot.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EmployeeDTO {

    public EmployeeDTO(boolean isActive, LocalDate dateOfJoining, String email, String name, Long id) {
        this.isActive = isActive;
        this.dateOfJoining = dateOfJoining;
        this.email = email;
        this.name = name;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    private  Long id;
    private  String name ;
    private String email;
    private LocalDate dateOfJoining;
    private boolean isActive;

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }




}
