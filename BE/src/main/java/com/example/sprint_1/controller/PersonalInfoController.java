package com.example.sprint_1.controller;

import com.example.sprint_1.dto.employee.EmployeeAcountDTO;
import com.example.sprint_1.entity.employee.Employee;
import com.example.sprint_1.service.employee.PersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//Controller của Nhung -- làm chức năng chỉnh sửa Thông tin cá nhân
@RestController
public class PersonalInfoController {

    @Autowired
    private PersonalInfoService personalInfoService;

    @GetMapping("/personal-info/{id}")
    public ResponseEntity<Employee> getEmployeeByAccountId(@PathVariable(value = "id") String id) {
        Employee employee = personalInfoService.findEmployeeById(id);
//        return new ResponseEntity<>(employee, HttpStatus.OK);
        return ResponseEntity.ok().body(employee);
    }

    @PutMapping("/personal-info/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") String id, @Valid @RequestBody EmployeeAcountDTO em) {
        Employee employee = personalInfoService.findEmployeeById(id);
        personalInfoService.saveEmployee(id, em);
        return new ResponseEntity<>(HttpStatus.OK);
    }






}
