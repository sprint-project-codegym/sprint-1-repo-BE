package com.example.sprint_1.controller;

import com.example.sprint_1.entity.employee.Employee;
import com.example.sprint_1.entity.security.Account;
import com.example.sprint_1.repository.employee.PositionRepository;
import com.example.sprint_1.repository.security.AccountRepository;
import com.example.sprint_1.service.employee.EmployeeService;
import com.example.sprint_1.service.employee.PositionService;
import com.example.sprint_1.service.security.AccountService;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/home")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PositionRepository positionRepository;

    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> findAllEmployee(){
        List<Employee> employeeList = employeeService.findAll();
        if(employeeList.isEmpty()) {
            return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public ResponseEntity<Void> addAccount(@RequestBody Account account){
        accountRepository.save(account);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

}
