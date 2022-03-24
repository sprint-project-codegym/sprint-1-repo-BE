package com.example.sprint_1.controller;

import com.example.sprint_1.entity.employee.Employee;
import com.example.sprint_1.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("api/admin/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    public ResponseEntity<Page<Employee>> getList(@RequestParam(defaultValue = "0") Integer page,
                                                  @RequestParam(defaultValue = "2") Integer size,
                                                  @RequestParam(defaultValue = "") String name,
                                                  @RequestParam(defaultValue = "") String id){
        Pageable paging= PageRequest.of(page,size);
        Page<Employee> employees = employeeService.searchEmployee(paging,name,id);
        if(employees.isEmpty()){
            return new ResponseEntity<Page<Employee>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Page<Employee>>(employees, HttpStatus.OK);
    }
    @GetMapping("delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable String id){
        Employee employee=employeeService.getEmployeeById(id);
        if (employee==null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        employeeService.deleteEmployee(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
