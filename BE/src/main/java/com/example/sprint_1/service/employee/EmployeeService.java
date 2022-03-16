package com.example.sprint_1.service.employee;


import com.example.sprint_1.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    Page<Employee> getAllEmployeePaging(Pageable pageable);

    List<Employee> getAllEmployee();

    Employee getEmployeeById(String id);

    Page<Employee> searchEmployee(Pageable pageable, String id, String name);

    void deleteEmployee(String id);
}
