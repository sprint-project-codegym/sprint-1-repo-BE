package com.example.sprint_1.service.impl.employee;

import com.example.sprint_1.dto.employee.EmployeeAcountDTO;
import com.example.sprint_1.entity.employee.Employee;
import com.example.sprint_1.entity.security.Account;
import com.example.sprint_1.repository.employee.EmployeeRepository;
import com.example.sprint_1.repository.employee.PersonalInfoRepository;
import com.example.sprint_1.repository.security.AccountRepository;
import com.example.sprint_1.service.employee.PersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonalInfoServiceImpl implements PersonalInfoService {

    //Nhung - Chức năng sửa thông tin cá nhân

    @Autowired
    private PersonalInfoRepository personalInfoRepository;

//    @Autowired
//    private PasswordEncoder encoder;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee findEmployeeById(String id) {
        return personalInfoRepository.findEmployeeByEmployeeId(id);
    }

    @Override
    public Account findAccountById(String id) {
        return null;
    }


    @Override
    public void saveEmployee(String id,EmployeeAcountDTO employeeAcountDTO) {
        Employee e = employeeRepository.findEmployeeByEmployeeId(id);
        Account account = e.getAccount();
        accountRepository.saveNewPassword(account.getUserName(), employeeAcountDTO.getEmployeeAccountPw());
    }


//    @Override
//    public boolean checkPass(String id, String encrypt_pw) {
//        Account account = personalInfoRepository.findAccountByAccountId(id);
//        return encoder.matches(encrypt_pw, account.getEncryptPw());
//    }


    @Override
    public void saveAccount(String id, String encrypt_pw) {
        this.personalInfoRepository.saveAccount(id, encrypt_pw);
    }
}
