package com.example.sprint_1.service.employee;


import com.example.sprint_1.entity.employee.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployee();

    Employee getEmployeeById(String id);

    List<Employee> searchEmployee(String name, String id);

    void deleteEmployee(String id);
}
