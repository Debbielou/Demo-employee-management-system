package com.debbie.demo.employeeManagementSystem.repository;

import com.debbie.demo.employeeManagementSystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRespository  extends JpaRepository<Employee, Integer> {

}
