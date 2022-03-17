package com.example.sprint_1.controller;

import com.example.sprint_1.entity.employee.Employee;
import com.example.sprint_1.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    public ResponseEntity<List<Employee>> getList(@RequestParam(defaultValue = "") String name,
                                                    @RequestParam(defaultValue = "") String id){
        List<Employee> list;
        if(!name.equals("")||!id.equals("")){
            return new ResponseEntity<List<Employee>>(employeeService.searchEmployee("%" +name+ "%", "%" +id+ "%"), HttpStatus.OK);
        }else {
            list = employeeService.getAllEmployee();
        }
        if(list.isEmpty()){
            return new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
    }
    @PatchMapping("delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable String id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
