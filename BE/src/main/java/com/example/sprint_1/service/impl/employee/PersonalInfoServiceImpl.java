package com.example.sprint_1.service.impl.employee;


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
    }


//    @Override
//    public boolean checkPass(Integer id, String password) {
//        Account account = personalInfoRepository.findAccountById(id);
//        return encoder.matches(password, account.getEncryptPw());
//    }


}

