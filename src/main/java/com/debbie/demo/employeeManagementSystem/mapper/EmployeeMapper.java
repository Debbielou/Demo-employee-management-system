package com.debbie.demo.employeeManagementSystem.mapper;

import com.debbie.demo.employeeManagementSystem.dto.EmployeeDto;
import com.debbie.demo.employeeManagementSystem.entity.Employee;

public class EmployeeMapper {

 public static EmployeeDto mapToEmployeeDto(Employee employee) {

     return new EmployeeDto(
             employee.getId(),
             employee.getFirstName(),
             employee.getLastName(),
             employee.getEmail()
     );

 }
public static Employee mapToEmployee(EmployeeDto employeeDto) {
     return new Employee(
             employeeDto.getId(),
             employeeDto.getFirstName(),
             employeeDto.getLastName(),
             employeeDto.getEmail()
     );
}

}
