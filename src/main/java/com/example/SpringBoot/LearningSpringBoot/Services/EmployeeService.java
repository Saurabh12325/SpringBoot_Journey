package com.example.SpringBoot.LearningSpringBoot.Services;

import com.example.SpringBoot.LearningSpringBoot.Entities.EmployeeEntity;
import com.example.SpringBoot.LearningSpringBoot.dto.EmployeeDTO;
import com.example.SpringBoot.LearningSpringBoot.exceptions.ResourceNotFoundExceptions;
import com.example.SpringBoot.LearningSpringBoot.repositories.EmployeeRepositiory;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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



    public EmployeeDTO Save(EmployeeDTO employeeDTO) {
        EmployeeEntity tosaveEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        EmployeeEntity employee = employeeRepositiory.save(tosaveEntity);
        return modelMapper.map(employee, EmployeeDTO.class);

    }
    public EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO employeeDTO) {
        isExistsByEmployeeId(employeeId);
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        employeeEntity.setId(employeeId);
        EmployeeEntity saveEmployeeEntity = employeeRepositiory.save(employeeEntity);
        return modelMapper.map(saveEmployeeEntity, EmployeeDTO.class);
    }

    private void isExistsByEmployeeId(Long employeeId) {
        boolean exists = employeeRepositiory.existsById(employeeId);
        if (!exists) {
            throw new ResourceNotFoundExceptions("Employee Not Found with id " + employeeId);
        }
    }


    public boolean deleteEmployeeById(Long employeeId) {
        isExistsByEmployeeId(employeeId);
        employeeRepositiory.deleteById(employeeId);
        return true;
    }

    public EmployeeDTO updateEmployeeDetailByID(Long employeeId, Map<String, Object> updates) {
        isExistsByEmployeeId(employeeId);
        EmployeeEntity employeeEntity = employeeRepositiory.findById(employeeId).get();
        updates.forEach((field,value) ->{
        Field fieldToBeUpdated = ReflectionUtils.findRequiredField(EmployeeEntity.class,field);
        fieldToBeUpdated.setAccessible(true);
        ReflectionUtils.setField(fieldToBeUpdated,employeeEntity,value);
        });

return  modelMapper.map(employeeRepositiory.save(employeeEntity), EmployeeDTO.class);
    }

    public Optional<EmployeeDTO> getEmployeeById(Long id) {
        return employeeRepositiory.findById(id).map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class));
    }
}
