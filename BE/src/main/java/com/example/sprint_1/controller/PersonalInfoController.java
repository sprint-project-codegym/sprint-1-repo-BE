package com.example.sprint_1.controller;

import com.example.sprint_1.dto.employee.EmployeeAcountDTO;
import com.example.sprint_1.dto.employee.PasswordDTO;
import com.example.sprint_1.dto.security.payload.reponse.MessageResponse;
import com.example.sprint_1.entity.employee.Employee;
import com.example.sprint_1.entity.security.Account;
import com.example.sprint_1.service.employee.PersonalInfoService;
import com.example.sprint_1.service.security.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//Controller của Nhung -- làm chức năng chỉnh sửa Thông tin cá nhân

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/home")
public class PersonalInfoController {

    @Autowired
    private PersonalInfoService personalInfoService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private PasswordEncoder encoder;

    //NhungHTC - Show thông tin cá nhân
    @GetMapping("/personal-info/{id}")
    public ResponseEntity<Employee> showInfo(@PathVariable("id") Integer id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (personalInfoService.findEmployeeByAccountId(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Employee employee = personalInfoService.findEmployeeByAccountId(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    //NhungHTC - Edit thông tin cá nhân

    @RequestMapping(value = "/personal-info/edit", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateEmployee(@Valid @RequestBody EmployeeAcountDTO employeeAcountDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String message = "Lỗi định dạng";
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
        personalInfoService.updateInfoEmployeeDTO(employeeAcountDTO);
        return new ResponseEntity<>(employeeAcountDTO, HttpStatus.OK);
    }

    //NhungHTC - Đổi mật khẩu
    @PutMapping("/personal-info/change-password/{id}")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<MessageResponse> changeUserPassword(@PathVariable("id") Integer id, @RequestBody PasswordDTO passwordDTO) {
        String oldPassword = passwordDTO.getOldPassword();
        String newPassword = passwordDTO.getNewPassword();
        Account account = accountService.findByAccountId(id);
        if (!userPasswordCheck(oldPassword, account)) {
            return ResponseEntity.badRequest().body(new MessageResponse("Mật khẩu cũ không đúng. Vui lòng nhập lại."));
//            return new ResponseEntity<>(new MessageResponse("1"), HttpStatus.OK);
        } else {
            accountService.saveNewPassword_Nhung(encoder.encode(newPassword), id);
//            return new ResponseEntity<>(new MessageResponse("2"), HttpStatus.OK);
            return ResponseEntity.ok().body(new MessageResponse("Đổi mật khẩu thành công"));
        }
    }

    public boolean userPasswordCheck(String password, Account account) {
        PasswordEncoder passencoder = new BCryptPasswordEncoder();
        String encodedPassword = account.getEncryptPw();
        return passencoder.matches(password, encodedPassword);
//          return password.equals(account.getEncryptPw());
    }
}
