package com.example.SpringBoot.LearningSpringBoot.Controller;


import com.example.SpringBoot.LearningSpringBoot.Services.EmployeeService;
import com.example.SpringBoot.LearningSpringBoot.dto.EmployeeDTO;
import com.example.SpringBoot.LearningSpringBoot.repositories.EmployeeRepositiory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class EmployeeController {
  public final EmployeeService employeeService;

    public EmployeeController( EmployeeService employeeService) {
        this.employeeService = employeeService;

    }
@PostMapping("/save")
    public EmployeeDTO SaveEmployee(@RequestBody  EmployeeDTO employeeDTO) {
        return employeeService.Save(employeeDTO);
    }

    @GetMapping("/employee")
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/{EmployeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable (name = "EmployeeId") Long id){
        return employeeService.findById(id);
    }
    @PutMapping("/{employeeId}")
    public EmployeeDTO updateEmployeeById(@PathVariable  Long employeeId, @RequestBody EmployeeDTO employeeDTO) {
        return employeeService.updateEmployee(employeeId,employeeDTO);
    }
}
