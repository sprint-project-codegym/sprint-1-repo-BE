package com.example.sprint_1.controller;

import com.example.sprint_1.dto.employee.EmployeeAcountDTO;
import com.example.sprint_1.dto.security.AccountDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
@SpringBootTest
@AutoConfigureMockMvc
public class PersonalInfoController_updateEmployee {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    //No.19 - Test items null
    @Test
    public void edit_personalInfo_employeeGender_19() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountId(1);
        accountDTO.setUserName("admin");
        accountDTO.setEmail("khoa4755@gmail.com");
        accountDTO.setEncryptPw("$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu");
        accountDTO.setEnable(true);

        EmployeeAcountDTO employeeAcountDTO = new EmployeeAcountDTO();
        employeeAcountDTO.setEmployeeId("E001");
        employeeAcountDTO.setEmployeeName("Nguyễn Thái Học");
        employeeAcountDTO.setEmployeeBirthday("2000-05-06");
        employeeAcountDTO.setEmployeeGender(null);
        employeeAcountDTO.setEmployeeGmail("nthaihoc@gmail.com");
        employeeAcountDTO.setEmployeeAddress("Quảng Nam");
        employeeAcountDTO.setEmployeePhone("0365635686");

        employeeAcountDTO.setAccount(accountDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/personal-info/edit")
                        .content(this.objectMapper.writeValueAsString(employeeAcountDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    //No.20 - Test items ""
    @Test
    public void edit_personalInfo_employeeName_20() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountId(1);
        accountDTO.setUserName("admin");
        accountDTO.setEmail("khoa4755@gmail.com");
        accountDTO.setEncryptPw("$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu");
        accountDTO.setEnable(true);

        EmployeeAcountDTO employeeAcountDTO = new EmployeeAcountDTO();
        employeeAcountDTO.setEmployeeId("E001");
        employeeAcountDTO.setEmployeeName("");
        employeeAcountDTO.setEmployeeBirthday("2000-05-06");
        employeeAcountDTO.setEmployeeGender(true);
        employeeAcountDTO.setEmployeeGmail("nthaihoc@gmail.com");
        employeeAcountDTO.setEmployeeAddress("Quảng Nam");
        employeeAcountDTO.setEmployeePhone("0365635686");

        employeeAcountDTO.setAccount(accountDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/personal-info/edit")
                        .content(this.objectMapper.writeValueAsString(employeeAcountDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void edit_personalInfo_employeeBirthday_20() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountId(1);
        accountDTO.setUserName("admin");
        accountDTO.setEmail("khoa4755@gmail.com");
        accountDTO.setEncryptPw("$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu");
        accountDTO.setEnable(true);

        EmployeeAcountDTO employeeAcountDTO = new EmployeeAcountDTO();
        employeeAcountDTO.setEmployeeId("E001");
        employeeAcountDTO.setEmployeeName("Nguyễn Thái Học");
        employeeAcountDTO.setEmployeeBirthday("");
        employeeAcountDTO.setEmployeeGender(true);
        employeeAcountDTO.setEmployeeGmail("nthaihoc@gmail.com");
        employeeAcountDTO.setEmployeeAddress("Quảng Nam");
        employeeAcountDTO.setEmployeePhone("0365635686");

        employeeAcountDTO.setAccount(accountDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/personal-info/edit")
                        .content(this.objectMapper.writeValueAsString(employeeAcountDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void edit_personalInfo_employeeGmail_20() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountId(1);
        accountDTO.setUserName("admin");
        accountDTO.setEmail("khoa4755@gmail.com");
        accountDTO.setEncryptPw("$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu");
        accountDTO.setEnable(true);

        EmployeeAcountDTO employeeAcountDTO = new EmployeeAcountDTO();
        employeeAcountDTO.setEmployeeId("E001");
        employeeAcountDTO.setEmployeeName("Nguyễn Thái Học");
        employeeAcountDTO.setEmployeeBirthday("2000-05-06");
        employeeAcountDTO.setEmployeeGender(true);
        employeeAcountDTO.setEmployeeGmail("");
        employeeAcountDTO.setEmployeeAddress("Quảng Nam");
        employeeAcountDTO.setEmployeePhone("0365635686");

        employeeAcountDTO.setAccount(accountDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/personal-info/edit")
                        .content(this.objectMapper.writeValueAsString(employeeAcountDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void edit_personalInfo_employeeAddress_20() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountId(1);
        accountDTO.setUserName("admin");
        accountDTO.setEmail("khoa4755@gmail.com");
        accountDTO.setEncryptPw("$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu");
        accountDTO.setEnable(true);

        EmployeeAcountDTO employeeAcountDTO = new EmployeeAcountDTO();
        employeeAcountDTO.setEmployeeId("E001");
        employeeAcountDTO.setEmployeeName("Nguyễn Thái Học");
        employeeAcountDTO.setEmployeeBirthday("2000-05-06");
        employeeAcountDTO.setEmployeeGender(true);
        employeeAcountDTO.setEmployeeGmail("nthaihoc@gmail.com");
        employeeAcountDTO.setEmployeeAddress("");
        employeeAcountDTO.setEmployeePhone("0365635686");

        employeeAcountDTO.setAccount(accountDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/personal-info/edit")
                        .content(this.objectMapper.writeValueAsString(employeeAcountDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void edit_personalInfo_employeePhone_20() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountId(1);
        accountDTO.setUserName("admin");
        accountDTO.setEmail("khoa4755@gmail.com");
        accountDTO.setEncryptPw("$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu");
        accountDTO.setEnable(true);

        EmployeeAcountDTO employeeAcountDTO = new EmployeeAcountDTO();
        employeeAcountDTO.setEmployeeId("E001");
        employeeAcountDTO.setEmployeeName("Nguyễn Thái Học");
        employeeAcountDTO.setEmployeeBirthday("2000-05-06");
        employeeAcountDTO.setEmployeeGender(true);
        employeeAcountDTO.setEmployeeGmail("nthaihoc@gmail.com");
        employeeAcountDTO.setEmployeeAddress("Quảng Nam");
        employeeAcountDTO.setEmployeePhone("");

        employeeAcountDTO.setAccount(accountDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/personal-info/edit")
                        .content(this.objectMapper.writeValueAsString(employeeAcountDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }



    //No.21 - Test items sai format

    @Test
    public void edit_personalInfo_employeeGmail_21() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountId(1);
        accountDTO.setUserName("admin");
        accountDTO.setEmail("khoa4755@gmail.com");
        accountDTO.setEncryptPw("$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu");
        accountDTO.setEnable(true);

        EmployeeAcountDTO employeeAcountDTO = new EmployeeAcountDTO();
        employeeAcountDTO.setEmployeeId("E001");
        employeeAcountDTO.setEmployeeName("Nguyễn Thái Học");
        employeeAcountDTO.setEmployeeBirthday("2000-05-06");
        employeeAcountDTO.setEmployeeGender(true);
        employeeAcountDTO.setEmployeeGmail("nthaihoc");
        employeeAcountDTO.setEmployeeAddress("Quảng Nam");
        employeeAcountDTO.setEmployeePhone("0365635686");

        employeeAcountDTO.setAccount(accountDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/personal-info/edit")
                        .content(this.objectMapper.writeValueAsString(employeeAcountDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void edit_personalInfo_employeeAddress_21() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountId(1);
        accountDTO.setUserName("admin");
        accountDTO.setEmail("khoa4755@gmail.com");
        accountDTO.setEncryptPw("$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu");
        accountDTO.setEnable(true);

        EmployeeAcountDTO employeeAcountDTO = new EmployeeAcountDTO();
        employeeAcountDTO.setEmployeeId("E001");
        employeeAcountDTO.setEmployeeName("Nguyễn Thái Học");
        employeeAcountDTO.setEmployeeBirthday("2000-05-06");
        employeeAcountDTO.setEmployeeGender(true);
        employeeAcountDTO.setEmployeeGmail("nthaihoc@gmail.com");
        employeeAcountDTO.setEmployeeAddress("abc");
        employeeAcountDTO.setEmployeePhone("0365635686");

        employeeAcountDTO.setAccount(accountDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/personal-info/edit")
                        .content(this.objectMapper.writeValueAsString(employeeAcountDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void edit_personalInfo_employeePhone_21() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountId(1);
        accountDTO.setUserName("admin");
        accountDTO.setEmail("khoa4755@gmail.com");
        accountDTO.setEncryptPw("$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu");
        accountDTO.setEnable(true);

        EmployeeAcountDTO employeeAcountDTO = new EmployeeAcountDTO();
        employeeAcountDTO.setEmployeeId("E001");
        employeeAcountDTO.setEmployeeName("Nguyễn Thái Học");
        employeeAcountDTO.setEmployeeBirthday("2000-05-06");
        employeeAcountDTO.setEmployeeGender(true);
        employeeAcountDTO.setEmployeeGmail("nthaihoc@gmail.com");
        employeeAcountDTO.setEmployeeAddress("Quảng Nam");
        employeeAcountDTO.setEmployeePhone("090522221");

        employeeAcountDTO.setAccount(accountDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/personal-info/edit")
                        .content(this.objectMapper.writeValueAsString(employeeAcountDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }



    //No.22 - Test items không >= minlength
    @Test
    public void edit_personalInfo_employeeAddress_22() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountId(1);
        accountDTO.setUserName("admin");
        accountDTO.setEmail("khoa4755@gmail.com");
        accountDTO.setEncryptPw("$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu");
        accountDTO.setEnable(true);

        EmployeeAcountDTO employeeAcountDTO = new EmployeeAcountDTO();
        employeeAcountDTO.setEmployeeId("E001");
        employeeAcountDTO.setEmployeeName("Nguyễn Thái Học");
        employeeAcountDTO.setEmployeeBirthday("2000-05-06");
        employeeAcountDTO.setEmployeeGender(true);
        employeeAcountDTO.setEmployeeGmail("nthaihoc@gmail.com");
        employeeAcountDTO.setEmployeeAddress("Quảng");
        employeeAcountDTO.setEmployeePhone("0365635686");

        employeeAcountDTO.setAccount(accountDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/personal-info/edit")
                        .content(this.objectMapper.writeValueAsString(employeeAcountDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }



    //No.23 - Test items không <= maxlength
    @Test
    public void edit_personalInfo_employeeAddress_23() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountId(1);
        accountDTO.setUserName("admin");
        accountDTO.setEmail("khoa4755@gmail.com");
        accountDTO.setEncryptPw("$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu");
        accountDTO.setEnable(true);

        EmployeeAcountDTO employeeAcountDTO = new EmployeeAcountDTO();
        employeeAcountDTO.setEmployeeId("E001");
        employeeAcountDTO.setEmployeeName("Nguyễn Thái Học");
        employeeAcountDTO.setEmployeeBirthday("2000-05-06");
        employeeAcountDTO.setEmployeeGender(true);
        employeeAcountDTO.setEmployeeGmail("nthaihoc@gmail.com");
        employeeAcountDTO.setEmployeeAddress("Quảng Nam - Đà nẵng - Huế - Quảng Trị - Hà Nội - Sài Gòn - Hải Phòng - Quảng Nam - Quảng Ngãi - và hơn thế nữaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        employeeAcountDTO.setEmployeePhone("0365635686");

        employeeAcountDTO.setAccount(accountDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/personal-info/edit")
                        .content(this.objectMapper.writeValueAsString(employeeAcountDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }



    //No.24 - Test all items hợp lệ
    @Test
    public void edit_personalInfo_available_24() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountId(1);
        accountDTO.setUserName("admin");
        accountDTO.setEmail("khoa4755@gmail.com");
        accountDTO.setEncryptPw("$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu");
        accountDTO.setEnable(true);

        EmployeeAcountDTO employeeAcountDTO = new EmployeeAcountDTO();
        employeeAcountDTO.setEmployeeId("E001");
        employeeAcountDTO.setEmployeeName("Nguyễn Thái Học");
        employeeAcountDTO.setEmployeeBirthday("2000-05-06");
        employeeAcountDTO.setEmployeeGender(true);
        employeeAcountDTO.setEmployeeGmail("nthaihoc@gmail.com");
        employeeAcountDTO.setEmployeeAddress("bbbbbbbbbbbbbbbbbbbbb");
        employeeAcountDTO.setEmployeePhone("0905789789");

        employeeAcountDTO.setAccount(accountDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/personal-info/edit")
                        .content(this.objectMapper.writeValueAsString(employeeAcountDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
