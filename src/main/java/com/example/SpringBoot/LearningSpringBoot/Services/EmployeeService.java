package com.example.SpringBoot.LearningSpringBoot.Services;

import com.example.SpringBoot.LearningSpringBoot.Entities.EmployeeEntity;
import com.example.SpringBoot.LearningSpringBoot.dto.EmployeeDTO;
import com.example.SpringBoot.LearningSpringBoot.repositories.EmployeeRepositiory;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepositiory employeeRepositiory;
  private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepositiory employeeRepositiory, ModelMapper modelMapper) {
        this.employeeRepositiory = employeeRepositiory;
        this.modelMapper = modelMapper;
    }



    public List<EmployeeDTO> findAll() {
        List<EmployeeEntity> employeeEntities = employeeRepositiory.findAll();

      return employeeEntities.stream()
               .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
               .collect(Collectors.toList());
    }

    public EmployeeDTO findById(Long id) {
        EmployeeEntity employee = employeeRepositiory.findById(id).orElse(null);
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    public EmployeeDTO Save(EmployeeDTO employeeDTO) {
        EmployeeEntity tosaveEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        EmployeeEntity employee = employeeRepositiory.save(tosaveEntity);
        return modelMapper.map(employee, EmployeeDTO.class);

    }
}
