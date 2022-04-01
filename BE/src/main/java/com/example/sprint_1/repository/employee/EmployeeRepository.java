package com.example.sprint_1.repository.employee;

import com.example.sprint_1.entity.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
