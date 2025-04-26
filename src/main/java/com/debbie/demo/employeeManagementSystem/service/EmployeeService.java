package com.debbie.demo.employeeManagementSystem.service;

import com.debbie.demo.employeeManagementSystem.dto.EmployeeDto;
import com.debbie.demo.employeeManagementSystem.entity.Employee;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Integer employeeId);

    List<EmployeeDto>getAllEmployees();

    EmployeeDto updateEmployee(Integer employeeId, EmployeeDto updatedEmployee);

    void deleteEmployeeById(Integer employeeId);
}