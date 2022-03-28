package com.example.sprint_1.controller;

import com.example.sprint_1.dto.employee.EmployeeDTO;
import com.example.sprint_1.entity.employee.Employee;
import com.example.sprint_1.entity.employee.Position;
import com.example.sprint_1.entity.security.Role;
import com.example.sprint_1.repository.employee.PositionRepository;
import com.example.sprint_1.repository.security.AccountRepository;
import com.example.sprint_1.service.employee.EmployeeService;
import com.example.sprint_1.service.employee.PositionService;
import com.example.sprint_1.service.security.RoleService;

//import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import com.example.sprint_1.validation.employee.EmployeeCreateValidation;
import com.example.sprint_1.validation.employee.EmployeeEditValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/home")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PositionRepository positionRepository;

    @Autowired
    private PositionService positionService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private EmployeeCreateValidation employeeCreateValidation;

    @Autowired
    private EmployeeEditValidation employeeEditValidation;

    @RequestMapping(value = "/position",method = RequestMethod.GET)
    public ResponseEntity<List<Position>> findAllPosition(){
        List<Position> positionList = employeeService.getAllPosition();
        if(positionList.isEmpty()) {
            return new ResponseEntity<List<Position>>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<List<Position>>(positionList, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> findAllEmployee(){
        List<Employee> employeeList = employeeService.findAll();
        if(employeeList.isEmpty()) {
            return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
        }
    }

//    @RequestMapping(value = "/employee/account",method = RequestMethod.GET)
//    public ResponseEntity<List<Account>> findAllAccount(){
//        List<Account> accounts = accountRepository.findAll();
//        if(accounts.isEmpty()) {
//            return new ResponseEntity<List<Account>>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<List<Account>>(accounts, HttpStatus.OK);
//        }
//    }
//
//    @RequestMapping(value = "/employee/account", method = RequestMethod.POST)
//    public ResponseEntity<Void> addAccount(@RequestBody Account account){
//        accountRepository.save(account);
//        return new ResponseEntity<Void>(HttpStatus.CREATED);
//    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public ResponseEntity<?> createEmployee(@Validated @RequestBody EmployeeDTO employeeDto, BindingResult bindingResult) {
        employeeCreateValidation.validate(employeeDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.NOT_ACCEPTABLE);
        }
        employeeService.createNewEmployee(employeeDto);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/employee/{id}",method = RequestMethod.GET)
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String id){
        Employee employee = employeeService.findByEmployeeId(id);
        System.out.println(employee);
        if(employee==null) {
            return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<Employee>(employee, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> editEmployee(@PathVariable("id") String id, @Validated @RequestBody EmployeeDTO employeeDto, BindingResult bindingResult) {
        System.out.println(employeeDto);
        employeeEditValidation.validate(employeeDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.NOT_ACCEPTABLE);
        }
        employeeService.editEmployee(id,employeeDto);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    /**
     * LuyenNT code
     *
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ResponseEntity<List<Object>> createVaccinations() {
        List<Position> positionList = positionService.getAllPosition();
        List<Role> roleList = roleService.getAllRoles();
        List<Object> list = Arrays.asList(positionList, roleList);
        return new ResponseEntity<List<Object>>(list, HttpStatus.OK);
    }

}
