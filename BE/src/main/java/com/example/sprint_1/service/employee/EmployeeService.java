package com.example.sprint_1.service.employee;

import com.example.sprint_1.entity.employee.Employee;
import com.example.sprint_1.dto.employee.EmployeeDTO;
import com.example.sprint_1.entity.employee.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    Employee findEmployeeByEmployeeId(String id);
    //    Employee findEmployeeById(String id);

    List<Employee> findAll();

    List<Position> getAllPosition();

    Employee findByEmployeeId(String id);

    void addEmployee(Employee employee);

    void editEmployee(Employee employee);

    void createNewEmployee(EmployeeDTO employeeDto);

    void editEmployee(String id, EmployeeDTO employeeDto);

    Page<Employee> getAllEmployee(Pageable pageable);

    Employee getEmployeeById(String id);

    Page<Employee> searchEmployee(Pageable pageable, String name, String id);

    void deleteEmployee(String id);
}
