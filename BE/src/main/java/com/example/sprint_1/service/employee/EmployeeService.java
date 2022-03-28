package com.example.sprint_1.service.employee;

import com.example.sprint_1.dto.employee.EmployeeDTO;
import com.example.sprint_1.entity.employee.Employee;
import com.example.sprint_1.entity.employee.Position;
//import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    List<Position> getAllPosition();
    Employee findByEmployeeId(String id);
    void addEmployee(Employee employee);
    void editEmployee(Employee employee);
    void createNewEmployee(EmployeeDTO employeeDto);
    void editEmployee(String id,EmployeeDTO employeeDto);
}
