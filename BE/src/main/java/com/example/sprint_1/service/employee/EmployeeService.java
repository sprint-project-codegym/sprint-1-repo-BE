package com.example.sprint_1.service.employee;

import com.example.sprint_1.dto.employee.EmployeeDTO;
import com.example.sprint_1.entity.employee.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    void addEmployee(Employee employee);
    void editEmployee(Employee employee);
}
