package com.example.sprint_1.service.impl.employee;

import com.example.sprint_1.dto.employee.EmployeeDTO;
import com.example.sprint_1.entity.employee.Employee;
import com.example.sprint_1.entity.employee.Position;
import com.example.sprint_1.entity.security.Account;
import com.example.sprint_1.repository.employee.EmployeeRepository;
import com.example.sprint_1.repository.employee.PositionRepository;
import com.example.sprint_1.service.employee.EmployeeService;
import com.example.sprint_1.service.employee.PositionService;
import com.example.sprint_1.service.security.AccountService;
import com.example.sprint_1.service.security.RoleService;
//import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import com.example.sprint_1.ultils.GenerateUsername;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private PositionService positionService;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Position> getAllPosition() {
        return positionService.getAllPosition();
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
        account.setUserName(GenerateUsername.generate(employeeDto.getEmployeeName()));
        String password = encoder.encode("123123");
        account.setEnable(true);
        account.setEmail(employeeDto.getEmployeeGmail()); // nếu employee.email null thì sẽ không lưu account
        int i=1;
        while (true) {
            try { // nếu tồn tại account rồi thì thêm số vào ví dụ leconghau -> leconghau1
                accountService.addNew(account.getUserName(), account.getEmail(), password);
                break;
            } catch (Exception e) {
                account.setUserName(account.getUserName().replaceAll("[\\d]+",""));
                account.setUserName(account.getUserName() + i);
            }
            i++;
        }
        int id = accountService.findIdUserByUserName(account.getUserName());
        account.setAccountId(id);
        System.out.println(id);
        roleService.setDefaultRole(id, 1);


        Employee employee = new Employee();
        int code = (int) Math.floor(((Math.random() * 899999) + 100000));
        employee.setEmployeeId("E" + code);
        employee.setEmployeeName(employeeDto.getEmployeeName());
        employee.setEmployeeBirthday(employeeDto.getEmployeeBirthday());
        employee.setEmployeeGender(employeeDto.getEmployeeGender());
        employee.setEmployeeIdCard(employeeDto.getEmployeeIdCard());
        employee.setEmployeeGmail(employeeDto.getEmployeeGmail());
        employee.setEmployeeAddress(employeeDto.getEmployeeAddress());
        employee.setEmployeePhone(employeeDto.getEmployeePhone());
        employee.setEmployeeSalary(employeeDto.getEmployeeSalary());
        employee.setUrlImage(employeeDto.getUrlImage());
        employee.setDeleteFlag(false);

        Position poEntity = new Position();
        poEntity.setPositionId(employeeDto.getPosition().getPositionId());
        employee.setPosition(poEntity);

        employee.setAccount(account);
        System.out.println(employee.getAccount().getAccountId());
        employeeRepository.createNewEmployee(employee.getEmployeeId(), employee.getEmployeeName(), employee.getEmployeeBirthday(),
                employee.getEmployeeGender(),employee.getEmployeeIdCard(), employee.getEmployeeGmail(), employee.getEmployeeAddress(),
                employee.getEmployeePhone(), employee.getEmployeeSalary(),employee.getUrlImage() ,false,
                employee.getAccount().getAccountId(), employee.getPosition().getPositionId());
//        employeeRepository.createNewEmployee(employee.getEmployeeId(), false,
//                employee.getAccount().getAccountId(), employee.getPosition().getPositionId());
    }

    @Override
    public void editEmployee(String id,EmployeeDTO employeeDto) {

        Employee employee = employeeRepository.findByEmployeeId(id);
        employee.setEmployeeName(employeeDto.getEmployeeName());
        employee.setEmployeeBirthday(employeeDto.getEmployeeBirthday());
        employee.setEmployeeGender(employeeDto.getEmployeeGender());
        employee.setEmployeeIdCard(employeeDto.getEmployeeIdCard());
        employee.setEmployeeGmail(employeeDto.getEmployeeGmail());
        employee.setEmployeeAddress(employeeDto.getEmployeeAddress());
        employee.setEmployeePhone(employeeDto.getEmployeePhone());
        employee.setEmployeeSalary(employeeDto.getEmployeeSalary());
        employee.setUrlImage(employeeDto.getUrlImage());

        Account account = employee.getAccount();
        account.setEmail(employee.getEmployeeGmail()); // cập nhật lại email cho account
//        account.setEncryptPw(encoder.encode(employee.getAccount().getEncryptPw()));
        accountService.updateAccount(account.getEmail(), account.getUserName());

        Position poEntity = new Position();
        poEntity.setPositionId(employeeDto.getPosition().getPositionId());
        employee.setPosition(poEntity);

        System.out.println(employee);
        employeeRepository.editEmployee(employee.getEmployeeName(), employee.getEmployeeBirthday(),
                employee.getEmployeeGender(),employee.getEmployeeIdCard(), employee.getEmployeeGmail(), employee.getEmployeeAddress(),
                employee.getEmployeePhone(), employee.getEmployeeSalary(), employee.getUrlImage(),employee.getDeleteFlag(),
                employee.getAccount().getAccountId(), employee.getPosition().getPositionId(),id);
    }

}
