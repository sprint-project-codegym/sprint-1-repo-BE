package com.example.sprint_1.service.impl.employee;

<<<<<<< HEAD
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
=======

import com.example.sprint_1.dto.employee.EmployeeAcountDTO;
import com.example.sprint_1.entity.employee.Employee;
import com.example.sprint_1.entity.security.Account;
import com.example.sprint_1.repository.employee.PersonalInfoRepository;
import com.example.sprint_1.service.employee.PersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class PersonalInfoServiceImpl implements PersonalInfoService {
    @Autowired
    PersonalInfoRepository personalInfoRepository;
//
//    @Autowired
//    private PasswordEncoder encoder;


    //Nhung - Chức năng show và sửa thông tin cá nhân

    @Override
    public Employee findEmployeeByEmployeeId(String id) {
        return personalInfoRepository.getEmployeeByEmployeeId(id);
    }

    @Override
    public void updateInfoEmployeeDTO(EmployeeAcountDTO employeeAcountDTO) {
        personalInfoRepository.updateEmployeeDTO(employeeAcountDTO.getEmployeeId(), employeeAcountDTO.getEmployeeName(), employeeAcountDTO.getEmployeeGender(),
                employeeAcountDTO.getEmployeeBirthday(), employeeAcountDTO.getEmployeePhone(), employeeAcountDTO.getEmployeeGmail(), employeeAcountDTO.getEmployeeAddress());

    }

    //Chức năng đổi mật khẩu
    @Override
    public void saveAccount(Integer id, String password) {
        this.personalInfoRepository.saveAccount(id, password);
    }

    @Override
    public boolean checkPass(Integer id, String password) {
        return false;
    }

    @Override
    public Account findById(Integer id) {
        return personalInfoRepository.findById(id).orElse(null);
    }

    @Override
    public void updateAccountPassword(String encryptPw, Integer accountId) {
        personalInfoRepository.updateAccountPassword(encryptPw,accountId);
>>>>>>> 3d2b27c42e637c107910d85f75dd36f344f0ee13
    }


//    @Override
<<<<<<< HEAD
//    public boolean checkPass(String id, String encrypt_pw) {
//        Account account = personalInfoRepository.findAccountByAccountId(id);
//        return encoder.matches(encrypt_pw, account.getEncryptPw());
//    }


    @Override
    public void saveAccount(String id, String encrypt_pw) {
        this.personalInfoRepository.saveAccount(id, encrypt_pw);
    }
}
=======
//    public boolean checkPass(Integer id, String password) {
//        Account account = personalInfoRepository.findAccountById(id);
//        return encoder.matches(password, account.getEncryptPw());
//    }


}

>>>>>>> 3d2b27c42e637c107910d85f75dd36f344f0ee13
