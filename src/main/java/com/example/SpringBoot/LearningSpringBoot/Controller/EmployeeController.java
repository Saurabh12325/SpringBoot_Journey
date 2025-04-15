package com.example.SpringBoot.LearningSpringBoot.Controller;

import com.example.SpringBoot.LearningSpringBoot.Entities.EmployeeEntity;
import com.example.SpringBoot.LearningSpringBoot.repositories.EmployeeRepositiory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class EmployeeController {
    public final EmployeeRepositiory employeeRepositiory;

    public EmployeeController(EmployeeRepositiory employeeRepositiory) {
        this.employeeRepositiory = employeeRepositiory;
    }
@PostMapping("/save")
    public EmployeeEntity SaveEmployee(@RequestBody  EmployeeEntity employeeEntity) {
        return employeeRepositiory.save(employeeEntity);
    }

    @GetMapping("/employee")
    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepositiory.findAll();
    }

    @GetMapping("/{EmployeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable (name = "EmployeeId") Long id){
        return employeeRepositiory.findById(id).orElse(null);
    }
}
