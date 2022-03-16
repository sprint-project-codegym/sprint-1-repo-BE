package com.example.sprint_1.controller;

import com.example.sprint_1.entity.employee.Employee;
import com.example.sprint_1.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public ResponseEntity<List<Employee>> getList(){
        List<Employee> list = employeeService.getAllEmployee();
        if(list.isEmpty()){
            return new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
    }
    @GetMapping("/paging")
    public ResponseEntity<Page<Employee>> getListPaging(@PageableDefault(value = 1) Pageable pageable){
        Page<Employee> list = employeeService.getAllEmployeePaging(pageable);
        if(list.isEmpty()){
            return new ResponseEntity<Page<Employee>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Page<Employee>>(list, HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<Page<Employee>> getListPaging(@PageableDefault(value = 1) Pageable pageable, String id, String name){
        Page<Employee> list = employeeService.searchEmployee(pageable, id, name);
        if(list.isEmpty()){
            return new ResponseEntity<Page<Employee>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Page<Employee>>(list, HttpStatus.OK);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable String id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
