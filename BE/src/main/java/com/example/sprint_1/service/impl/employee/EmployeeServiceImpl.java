package com.example.sprint_1.service.impl.employee;

import com.example.sprint_1.dto.employee.EmployeeDTO;
import com.example.sprint_1.entity.employee.Employee;
import com.example.sprint_1.repository.employee.EmployeeRepository;
import com.example.sprint_1.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.addEmployee(employee.getEmployeeName(),
                employee.getEmployeeBirthday(), employee.getEmployeeGender(),
                employee.getEmployeeIdCard(), employee.getEmployeeGmail(),
                employee.getEmployeeAddress(), employee.getEmployeePhone(),
                employee.getEmployeeDateStart(), employee.getEmployeeSalary());
    }

    @Override
    public void editEmployee(Employee employee) {
        employeeRepository.editEmployee(employee.getEmployeeName(),
                employee.getEmployeeBirthday(), employee.getEmployeeGender(),
                employee.getEmployeeIdCard(), employee.getEmployeeGmail(),
                employee.getEmployeeAddress(), employee.getEmployeePhone(),
                employee.getEmployeeDateStart(), employee.getEmployeeSalary(), employee.getEmployeeId());
    }

}
