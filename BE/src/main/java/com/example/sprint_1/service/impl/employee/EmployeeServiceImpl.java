package com.example.sprint_1.service.impl.employee;

import com.example.sprint_1.dto.employee.EmployeeDTO;
import com.example.sprint_1.entity.employee.Employee;
import com.example.sprint_1.entity.employee.Position;
import com.example.sprint_1.entity.security.Account;
import com.example.sprint_1.repository.employee.EmployeeRepository;
import com.example.sprint_1.service.employee.EmployeeService;
import com.example.sprint_1.service.security.AccountService;
import com.example.sprint_1.service.security.RoleService;
//import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private RoleService roleService;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findByEmployeeId(String id) {
        return employeeRepository.findByEmployeeId(id);
    }

    @Override
    public void addEmployee(Employee employee) {
//        employeeRepository.addEmployee(employee.getEmployeeName(),
//                employee.getEmployeeBirthday(), employee.getEmployeeGender(),
//                employee.getEmployeeIdCard(), employee.getEmployeeGmail(),
//                employee.getEmployeeAddress(), employee.getEmployeePhone(),
//                employee.getEmployeeDateStart(), employee.getEmployeeSalary());
    }

    @Override
    public void editEmployee(Employee employee) {
//        employeeRepository.editEmployee(employee.getEmployeeName(),
//                employee.getEmployeeBirthday(), employee.getEmployeeGender(),
//                employee.getEmployeeIdCard(), employee.getEmployeeGmail(),
//                employee.getEmployeeAddress(), employee.getEmployeePhone(),
//                employee.getEmployeeDateStart(), employee.getEmployeeSalary(), employee.getEmployeeId());
    }

    @Override
    public void createNewEmployee(EmployeeDTO employeeDto){
        Account account = new Account();
        account.setUserName(employeeDto.getUsername());
//        account.setEncryptPw(encoder.encode("123"));
        String password = encoder.encode(employeeDto.getPassword());
        account.setEncryptPw(password);
        account.setEnable(true);
        accountService.addNew(account.getUserName(), "123");
        int id = accountService.findIdUserByUserName(employeeDto.getUsername());
        System.out.println(id);
        roleService.setDefaultRole(id, 1);


        Employee employee = new Employee();
        employee.setEmployeeId(employeeDto.getId());
        employee.setEmployeeName(employeeDto.getName());
        employee.setEmployeeBirthday(employeeDto.getDateOfBirth());
        employee.setEmployeeGender(Boolean.valueOf(employeeDto.getGender()));
        employee.setEmployeeIdCard(employeeDto.getIdCard());
        employee.setEmployeeGmail(employeeDto.getEmail());
        employee.setEmployeeAddress(employeeDto.getAddress());
        employee.setEmployeePhone(employeeDto.getPhone());
        employee.setEmployeeSalary(employeeDto.getSalary());
        employee.setDeleteFlag(false);

        Position poEntity = new Position();
        poEntity.setPositionId(employeeDto.getPosition());
        employee.setPosition(poEntity);

        employee.setAccount(account);
        System.out.println(employee);
        employeeRepository.createNewEmployee(employee.getEmployeeId(), employee.getEmployeeName(), employee.getEmployeeBirthday(),
                employee.getEmployeeGender(),employee.getEmployeeIdCard(), employee.getEmployeeGmail(), employee.getEmployeeAddress(),
                employee.getEmployeePhone(), employee.getEmployeeSalary(), false,
                employee.getAccount().getAccountId(), employee.getPosition().getPositionId());
//        employeeRepository.createNewEmployee(employee.getEmployeeId(), false,
//                employee.getAccount().getAccountId(), employee.getPosition().getPositionId());
    }

    @Override
    public void editEmployee(String id,EmployeeDTO employeeDto) {

        Employee employee = employeeRepository.findByEmployeeId(employeeDto.getId());
        Account account = employee.getAccount();
        String newPassword = encoder.encode(employeeDto.getPassword());
        accountService.saveNewPassword(newPassword,account.getUserName());

        employee.setEmployeeName(employeeDto.getName());
        employee.setEmployeeBirthday(employeeDto.getDateOfBirth());
        employee.setEmployeeGender(Boolean.valueOf(employeeDto.getGender()));
        employee.setEmployeeIdCard(employeeDto.getIdCard());
        employee.setEmployeeGmail(employeeDto.getEmail());
        employee.setEmployeeAddress(employeeDto.getAddress());
        employee.setEmployeePhone(employeeDto.getPhone());
        employee.setEmployeeSalary(employeeDto.getSalary());

        Position poEntity = new Position();
        poEntity.setPositionId(employeeDto.getPosition());
        employee.setPosition(poEntity);

        System.out.println(employee);
        employeeRepository.editEmployee(employee.getEmployeeName(), employee.getEmployeeBirthday(),
                employee.getEmployeeGender(),employee.getEmployeeIdCard(), employee.getEmployeeGmail(), employee.getEmployeeAddress(),
                employee.getEmployeePhone(), employee.getEmployeeSalary(), employee.getDeleteFlag(),
                employee.getAccount().getAccountId(), employee.getPosition().getPositionId(),id);
    }

}
