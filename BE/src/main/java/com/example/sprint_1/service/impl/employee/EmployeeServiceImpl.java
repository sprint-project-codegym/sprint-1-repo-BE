package com.example.sprint_1.service.impl.employee;

import com.example.sprint_1.entity.employee.Employee;
import com.example.sprint_1.repository.employee.EmployeeRepository;
import com.example.sprint_1.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.getAllEmployee();
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employeeRepository.getEmployeeById(id);
    }

    @Override
    public List<Employee> searchEmployee(String name, String id) {
        return employeeRepository.findEmployeeByIdAndName(name, id);
    }

    @Override
    public void deleteEmployee(String id) {
        employeeRepository.deleteEmployee(id);
    }
}
