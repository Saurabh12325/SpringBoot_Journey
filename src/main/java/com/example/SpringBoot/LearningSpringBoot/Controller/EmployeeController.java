package com.example.SpringBoot.LearningSpringBoot.Controller;


import com.example.SpringBoot.LearningSpringBoot.Services.EmployeeService;
import com.example.SpringBoot.LearningSpringBoot.dto.EmployeeDTO;
import com.example.SpringBoot.LearningSpringBoot.repositories.EmployeeRepositiory;
import jakarta.validation.Valid;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api")
public class EmployeeController {
  public final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
@PostMapping("/save")
    public ResponseEntity<EmployeeDTO>SaveEmployee(@RequestBody @Valid EmployeeDTO employeeDTO) {
        EmployeeDTO savedEmployee = employeeService.Save(employeeDTO);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/employee")
    public ResponseEntity<List<EmployeeDTO> > getAllEmployees() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @GetMapping("/{EmployeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable (name = "EmployeeId") Long id){
        Optional<EmployeeDTO> employeeDTO = employeeService.getEmployeeById(id);
       return employeeDTO
               .map(employeeDTO1 -> ResponseEntity.ok().body(employeeDTO1))
               .orElseThrow
                       (() -> new NoSuchElementException("Element not found"));
    }
    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO>  updateEmployeeById(@PathVariable  Long employeeId, @RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(employeeService.updateEmployee(employeeId,employeeDTO));
    }
    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable Long employeeId){
        boolean getdeleted = employeeService.deleteEmployeeById(employeeId);
        if(getdeleted){
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    @PatchMapping("/{employeeId}")
    public EmployeeDTO updateEmployeeDetailByID(@PathVariable Long employeeId , @RequestBody Map<String, Object> updates){
        return employeeService.updateEmployeeDetailByID(employeeId,updates);
    }
}
