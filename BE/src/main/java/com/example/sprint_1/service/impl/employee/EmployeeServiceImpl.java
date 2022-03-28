package com.example.sprint_1.service.impl.employee;

import com.example.sprint_1.entity.employee.Employee;
import com.example.sprint_1.repository.employee.EmployeeRepository;
import com.example.sprint_1.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    public Employee findEmployeeByEmployeeId(String id) {
        return employeeRepository.findEmployeeByEmployeeId(id);
    }
}
