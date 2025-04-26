package com.debbie.demo.employeeManagementSystem.service;

import com.debbie.demo.employeeManagementSystem.dto.EmployeeDto;
import com.debbie.demo.employeeManagementSystem.entity.Employee;
import com.debbie.demo.employeeManagementSystem.exception.ResourceNotFoundException;
import com.debbie.demo.employeeManagementSystem.mapper.EmployeeMapper;
import com.debbie.demo.employeeManagementSystem.repository.EmployeeRespository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRespository employeeRespository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRespository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }


    @Override
    public EmployeeDto getEmployeeById(Integer employeeId) {
        Employee employee = employeeRespository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with ID: " + employeeId + " doesn't exist"));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRespository.findAll();
        return employees.stream()
                .map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Integer employeeId, EmployeeDto updatedEmployee) {
        Employee employee = employeeRespository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("No update done. Employee ID: " + employeeId + " doesn't exist."));

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Employee updatedEmployeeObj = employeeRespository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployeeById(Integer employeeId) {
        Employee employee = employeeRespository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with ID: " + employeeId + " doesn't exist"));
        employeeRespository.deleteById(employeeId);
    }
}