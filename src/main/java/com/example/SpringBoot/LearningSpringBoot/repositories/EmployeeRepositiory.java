package com.example.SpringBoot.LearningSpringBoot.repositories;

import com.example.SpringBoot.LearningSpringBoot.Entities.EmployeeEntity;
import com.example.SpringBoot.LearningSpringBoot.dto.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepositiory extends JpaRepository<EmployeeEntity, Long> {
    Optional<EmployeeEntity> findById(Long id);

}
