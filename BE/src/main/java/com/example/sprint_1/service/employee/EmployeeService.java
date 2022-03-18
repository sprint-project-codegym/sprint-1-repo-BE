package com.example.sprint_1.service.employee;


import com.example.sprint_1.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface EmployeeService {

    Page<Employee> getAllEmployee(Pageable pageable);

    Employee getEmployeeById(String id);

    Page<Employee> searchEmployee(Pageable pageable, String name, String id);

    void deleteEmployee(String id);
}
