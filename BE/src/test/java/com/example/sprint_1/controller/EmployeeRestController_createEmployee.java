package com.example.sprint_1.controller;

import com.example.sprint_1.dto.employee.AccountDTO;
import com.example.sprint_1.dto.employee.EmployeeDTO;
import com.example.sprint_1.dto.employee.PositionDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeRestController_createEmployee {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createEmployee_name_13() throws Exception  {
        EmployeeDTO employeeDto = new EmployeeDTO();
        employeeDto.setEmployeeName("null");
        employeeDto.setEmployeeBirthday("2001-10-31");
        employeeDto.setEmployeeGender(true);
        employeeDto.setEmployeeGmail("hau@gmail.com");
        employeeDto.setEmployeeIdCard("206777555");
        employeeDto.setEmployeeAddress("Quảng Nam");
        employeeDto.setEmployeePhone("099988778");
        employeeDto.setEmployeeSalary(1000.0);

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUsername("leconghau414gr");
        accountDTO.setPassword("123456");
        employeeDto.setAccount(accountDTO);

        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setPositionId("1");
        employeeDto.setPosition(positionDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/home/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEmployee_dateOfBirth_13() throws Exception  {
        EmployeeDTO employeeDto = new EmployeeDTO();
         employeeDto.setEmployeeName("Hậu");
        employeeDto.setEmployeeBirthday("null");
        employeeDto.setEmployeeGender(true);
        employeeDto.setEmployeeGmail("hau@gmail.com");
        employeeDto.setEmployeeIdCard("206777555");
        employeeDto.setEmployeeAddress("Quảng Nam");
        employeeDto.setEmployeePhone("099988778");
        employeeDto.setEmployeeSalary(1000.0);

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUsername("leconghau4");
        accountDTO.setPassword("123456");
        employeeDto.setAccount(accountDTO);

        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setPositionId("1");
        employeeDto.setPosition(positionDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/home/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEmployee_email_13() throws Exception  {
        EmployeeDTO employeeDto = new EmployeeDTO();
         employeeDto.setEmployeeName("Hậu");
        employeeDto.setEmployeeBirthday("2001-10-31");
        employeeDto.setEmployeeGender(true);
        employeeDto.setEmployeeGmail("null");
        employeeDto.setEmployeeIdCard("206777555");
        employeeDto.setEmployeeAddress("Quảng Nam");
        employeeDto.setEmployeePhone("099988778");
        employeeDto.setEmployeeSalary(1000.0);

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUsername("leconghau689");
        accountDTO.setPassword("123456");
        employeeDto.setAccount(accountDTO);

        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setPositionId("1");
        employeeDto.setPosition(positionDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/home/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEmployee_idCard_13() throws Exception  {
        EmployeeDTO employeeDto = new EmployeeDTO();
         employeeDto.setEmployeeName("Hậu");
        employeeDto.setEmployeeBirthday("2001-10-31");
        employeeDto.setEmployeeGender(true);
        employeeDto.setEmployeeGmail("hau@gmail.com");
        employeeDto.setEmployeeIdCard("null");
        employeeDto.setEmployeeAddress("Quảng Nam");
        employeeDto.setEmployeePhone("099988778");
        employeeDto.setEmployeeSalary(1000.0);

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUsername("leconghau4");
        accountDTO.setPassword("123456");
        employeeDto.setAccount(accountDTO);

        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setPositionId("1");
        employeeDto.setPosition(positionDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/home/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEmployee_address_13() throws Exception  {
        EmployeeDTO employeeDto = new EmployeeDTO();
         employeeDto.setEmployeeName("Hậu");
        employeeDto.setEmployeeBirthday("2001-10-31");
        employeeDto.setEmployeeGender(true);
        employeeDto.setEmployeeGmail("hau@gmail.com");
        employeeDto.setEmployeeIdCard("206888999");
        employeeDto.setEmployeeAddress("null");
        employeeDto.setEmployeePhone("099988778");
        employeeDto.setEmployeeSalary(1000.0);

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUsername("leconghau4");
        accountDTO.setPassword("123456");
        employeeDto.setAccount(accountDTO);

        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setPositionId("1");
        employeeDto.setPosition(positionDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/home/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEmployee_phone_13() throws Exception  {
        EmployeeDTO employeeDto = new EmployeeDTO();
         employeeDto.setEmployeeName("Hậu");
        employeeDto.setEmployeeBirthday("2001-10-31");
        employeeDto.setEmployeeGender(true);
        employeeDto.setEmployeeGmail("hau@gmail.com");
        employeeDto.setEmployeeIdCard("206888999");
        employeeDto.setEmployeeAddress("Quảng Nam");
        employeeDto.setEmployeePhone("null");
        employeeDto.setEmployeeSalary(1000.0);

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUsername("leconghau4");
        accountDTO.setPassword("123456");
        employeeDto.setAccount(accountDTO);

        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setPositionId("1");
        employeeDto.setPosition(positionDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/home/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEmployee_salary_13() throws Exception  {
        EmployeeDTO employeeDto = new EmployeeDTO();
         employeeDto.setEmployeeName("Hậu");
        employeeDto.setEmployeeBirthday("2001-10-31");
        employeeDto.setEmployeeGender(true);
        employeeDto.setEmployeeGmail("hau@gmail.com");
        employeeDto.setEmployeeIdCard("206888999");
        employeeDto.setEmployeeAddress("Quảng Nam");
        employeeDto.setEmployeePhone("099988778");
        employeeDto.setEmployeeSalary(null);

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUsername("leconghau4");
        accountDTO.setPassword("123456");
        employeeDto.setAccount(accountDTO);

        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setPositionId("1");
        employeeDto.setPosition(positionDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/home/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEmployee_position_13() throws Exception  {
        EmployeeDTO employeeDto = new EmployeeDTO();
         employeeDto.setEmployeeName("Hậu");
        employeeDto.setEmployeeBirthday("2001-10-31");
        employeeDto.setEmployeeGender(true);
        employeeDto.setEmployeeGmail("hau@gmail.com");
        employeeDto.setEmployeeIdCard("206888999");
        employeeDto.setEmployeeAddress("Quảng Nam");
        employeeDto.setEmployeePhone("099988778");
        employeeDto.setEmployeeSalary(1000.0);

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUsername("leconghau4");
        accountDTO.setPassword("123456");
        employeeDto.setAccount(accountDTO);

        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setPositionId("null");
        employeeDto.setPosition(positionDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/home/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEmployee_account_13() throws Exception  {
        EmployeeDTO employeeDto = new EmployeeDTO();
         employeeDto.setEmployeeName("Hậu");
        employeeDto.setEmployeeBirthday("2001-10-31");
        employeeDto.setEmployeeGender(true);
        employeeDto.setEmployeeGmail("hau@gmail.com");
        employeeDto.setEmployeeIdCard("206888999");
        employeeDto.setEmployeeAddress("Quảng Nam");
        employeeDto.setEmployeePhone("099988778");
        employeeDto.setEmployeeSalary(1000.0);

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUsername("null");
        accountDTO.setPassword("123456");
        employeeDto.setAccount(accountDTO);

        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setPositionId("1");
        employeeDto.setPosition(positionDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/home/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEmployee_name_14() throws Exception  {
        EmployeeDTO employeeDto = new EmployeeDTO();
         employeeDto.setEmployeeName("");
        employeeDto.setEmployeeBirthday("2001-10-31");
        employeeDto.setEmployeeGender(true);
        employeeDto.setEmployeeGmail("hau@gmail.com");
        employeeDto.setEmployeeIdCard("206777555");
        employeeDto.setEmployeeAddress("Quảng Nam");
        employeeDto.setEmployeePhone("099988778");
        employeeDto.setEmployeeSalary(1000.0);

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUsername("leconghau414gr");
        accountDTO.setPassword("123456");
        employeeDto.setAccount(accountDTO);

        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setPositionId("1");
        employeeDto.setPosition(positionDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/home/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEmployee_dateOfBirth_14() throws Exception  {
        EmployeeDTO employeeDto = new EmployeeDTO();
         employeeDto.setEmployeeName("Hậu");
        employeeDto.setEmployeeBirthday("");
        employeeDto.setEmployeeGender(true);
        employeeDto.setEmployeeGmail("hau@gmail.com");
        employeeDto.setEmployeeIdCard("206777555");
        employeeDto.setEmployeeAddress("Quảng Nam");
        employeeDto.setEmployeePhone("099988778");
        employeeDto.setEmployeeSalary(1000.0);

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUsername("leconghau4");
        accountDTO.setPassword("123456");
        employeeDto.setAccount(accountDTO);

        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setPositionId("1");
        employeeDto.setPosition(positionDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/home/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEmployee_email_14() throws Exception  {
        EmployeeDTO employeeDto = new EmployeeDTO();
         employeeDto.setEmployeeName("Hậu");
        employeeDto.setEmployeeBirthday("2001-10-31");
        employeeDto.setEmployeeGender(true);
        employeeDto.setEmployeeGmail("");
        employeeDto.setEmployeeIdCard("206777555");
        employeeDto.setEmployeeAddress("Quảng Nam");
        employeeDto.setEmployeePhone("099988778");
        employeeDto.setEmployeeSalary(1000.0);

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUsername("leconghau689");
        accountDTO.setPassword("123456");
        employeeDto.setAccount(accountDTO);

        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setPositionId("1");
        employeeDto.setPosition(positionDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/home/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEmployee_idCard_14() throws Exception  {
        EmployeeDTO employeeDto = new EmployeeDTO();
         employeeDto.setEmployeeName("Hậu");
        employeeDto.setEmployeeBirthday("2001-10-31");
        employeeDto.setEmployeeGender(true);
        employeeDto.setEmployeeGmail("hau@gmail.com");
        employeeDto.setEmployeeIdCard("");
        employeeDto.setEmployeeAddress("Quảng Nam");
        employeeDto.setEmployeePhone("099988778");
        employeeDto.setEmployeeSalary(1000.0);

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUsername("leconghau4");
        accountDTO.setPassword("123456");
        employeeDto.setAccount(accountDTO);

        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setPositionId("1");
        employeeDto.setPosition(positionDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/home/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEmployee_address_14() throws Exception  {
        EmployeeDTO employeeDto = new EmployeeDTO();
         employeeDto.setEmployeeName("Hậu");
        employeeDto.setEmployeeBirthday("2001-10-31");
        employeeDto.setEmployeeGender(true);
        employeeDto.setEmployeeGmail("hau@gmail.com");
        employeeDto.setEmployeeIdCard("206888999");
        employeeDto.setEmployeeAddress("");
        employeeDto.setEmployeePhone("099988778");
        employeeDto.setEmployeeSalary(1000.0);

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUsername("leconghau4");
        accountDTO.setPassword("123456");
        employeeDto.setAccount(accountDTO);

        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setPositionId("1");
        employeeDto.setPosition(positionDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/home/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEmployee_phone_14() throws Exception  {
        EmployeeDTO employeeDto = new EmployeeDTO();
         employeeDto.setEmployeeName("Hậu");
        employeeDto.setEmployeeBirthday("2001-10-31");
        employeeDto.setEmployeeGender(true);
        employeeDto.setEmployeeGmail("hau@gmail.com");
        employeeDto.setEmployeeIdCard("206888999");
        employeeDto.setEmployeeAddress("Quảng Nam");
        employeeDto.setEmployeePhone("");
        employeeDto.setEmployeeSalary(1000.0);

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUsername("leconghau4");
        accountDTO.setPassword("123456");
        employeeDto.setAccount(accountDTO);

        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setPositionId("1");
        employeeDto.setPosition(positionDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/home/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEmployee_position_14() throws Exception  {
        EmployeeDTO employeeDto = new EmployeeDTO();
         employeeDto.setEmployeeName("Hậu");
        employeeDto.setEmployeeBirthday("2001-10-31");
        employeeDto.setEmployeeGender(true);
        employeeDto.setEmployeeGmail("hau@gmail.com");
        employeeDto.setEmployeeIdCard("206888999");
        employeeDto.setEmployeeAddress("Quảng Nam");
        employeeDto.setEmployeePhone("099988778");
        employeeDto.setEmployeeSalary(1000.0);

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUsername("leconghau4");
        accountDTO.setPassword("123456");
        employeeDto.setAccount(accountDTO);

        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setPositionId("");
        employeeDto.setPosition(positionDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/home/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEmployee_account_14() throws Exception  {
        EmployeeDTO employeeDto = new EmployeeDTO();
         employeeDto.setEmployeeName("Hậu");
        employeeDto.setEmployeeBirthday("2001-10-31");
        employeeDto.setEmployeeGender(true);
        employeeDto.setEmployeeGmail("hau@gmail.com");
        employeeDto.setEmployeeIdCard("206888999");
        employeeDto.setEmployeeAddress("Quảng Nam");
        employeeDto.setEmployeePhone("099988778");
        employeeDto.setEmployeeSalary(1000.0);

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUsername("");
        accountDTO.setPassword("123456");
        employeeDto.setAccount(accountDTO);

        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setPositionId("1");
        employeeDto.setPosition(positionDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/home/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee_name_15() throws Exception  {
        EmployeeDTO employeeDto = new EmployeeDTO();
         employeeDto.setEmployeeName("543");
        employeeDto.setEmployeeBirthday("2001-10-31");
        employeeDto.setEmployeeGender(true);
        employeeDto.setEmployeeGmail("hau@gmail.com");
        employeeDto.setEmployeeIdCard("206777555");
        employeeDto.setEmployeeAddress("Quảng Nam");
        employeeDto.setEmployeePhone("099988778");
        employeeDto.setEmployeeSalary(1000.0);

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUsername("leconghau414gr");
        accountDTO.setPassword("123456");
        employeeDto.setAccount(accountDTO);

        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setPositionId("1");
        employeeDto.setPosition(positionDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/home/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEmployee_dateOfBirth_15() throws Exception  {
        EmployeeDTO employeeDto = new EmployeeDTO();
         employeeDto.setEmployeeName("Hậu");
        employeeDto.setEmployeeBirthday("2001-30-30");
        employeeDto.setEmployeeGender(true);
        employeeDto.setEmployeeGmail("hau@gmail.com");
        employeeDto.setEmployeeIdCard("206777555");
        employeeDto.setEmployeeAddress("Quảng Nam");
        employeeDto.setEmployeePhone("099988778");
        employeeDto.setEmployeeSalary(1000.0);

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUsername("leconghau4");
        accountDTO.setPassword("123456");
        employeeDto.setAccount(accountDTO);

        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setPositionId("1");
        employeeDto.setPosition(positionDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/home/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEmployee_email_15() throws Exception  {
        EmployeeDTO employeeDto = new EmployeeDTO();
         employeeDto.setEmployeeName("Hậu");
        employeeDto.setEmployeeBirthday("2001-10-31");
        employeeDto.setEmployeeGender(true);
        employeeDto.setEmployeeGmail("hau@");
        employeeDto.setEmployeeIdCard("206777555");
        employeeDto.setEmployeeAddress("Quảng Nam");
        employeeDto.setEmployeePhone("099988778");
        employeeDto.setEmployeeSalary(1000.0);

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUsername("leconghau689");
        accountDTO.setPassword("123456");
        employeeDto.setAccount(accountDTO);

        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setPositionId("1");
        employeeDto.setPosition(positionDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/home/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEmployee_idCard_15() throws Exception  {
        EmployeeDTO employeeDto = new EmployeeDTO();
         employeeDto.setEmployeeName("Hậu");
        employeeDto.setEmployeeBirthday("2001-10-31");
        employeeDto.setEmployeeGender(true);
        employeeDto.setEmployeeGmail("hau@gmail.com");
        employeeDto.setEmployeeIdCard("");
        employeeDto.setEmployeeAddress("Quảng Nam");
        employeeDto.setEmployeePhone("00");
        employeeDto.setEmployeeSalary(1000.0);

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUsername("leconghau4");
        accountDTO.setPassword("123456");
        employeeDto.setAccount(accountDTO);

        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setPositionId("1");
        employeeDto.setPosition(positionDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/home/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEmployee_address_15() throws Exception  {
        EmployeeDTO employeeDto = new EmployeeDTO();
         employeeDto.setEmployeeName("Hậu");
        employeeDto.setEmployeeBirthday("2001-10-31");
        employeeDto.setEmployeeGender(true);
        employeeDto.setEmployeeGmail("hau@gmail.com");
        employeeDto.setEmployeeIdCard("206888999");
        employeeDto.setEmployeeAddress("");
        employeeDto.setEmployeePhone("099988778");
        employeeDto.setEmployeeSalary(1000.0);

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUsername("leconghau4");
        accountDTO.setPassword("123456");
        employeeDto.setAccount(accountDTO);

        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setPositionId("1");
        employeeDto.setPosition(positionDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/home/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEmployee_phone_15() throws Exception  {
        EmployeeDTO employeeDto = new EmployeeDTO();
         employeeDto.setEmployeeName("Hậu");
        employeeDto.setEmployeeBirthday("2001-10-31");
        employeeDto.setEmployeeGender(true);
        employeeDto.setEmployeeGmail("hau@gmail.com");
        employeeDto.setEmployeeIdCard("206888999");
        employeeDto.setEmployeeAddress("Quảng Nam");
        employeeDto.setEmployeePhone("abc");
        employeeDto.setEmployeeSalary(1000.0);

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUsername("leconghau4");
        accountDTO.setPassword("123456");
        employeeDto.setAccount(accountDTO);

        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setPositionId("1");
        employeeDto.setPosition(positionDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/home/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEmployee_position_15() throws Exception  {
        EmployeeDTO employeeDto = new EmployeeDTO();
         employeeDto.setEmployeeName("Hậu");
        employeeDto.setEmployeeBirthday("2001-10-31");
        employeeDto.setEmployeeGender(true);
        employeeDto.setEmployeeGmail("hau@gmail.com");
        employeeDto.setEmployeeIdCard("206888999");
        employeeDto.setEmployeeAddress("Quảng Nam");
        employeeDto.setEmployeePhone("099988778");
        employeeDto.setEmployeeSalary(1000.0);

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUsername("leconghau4");
        accountDTO.setPassword("123456");
        employeeDto.setAccount(accountDTO);

        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setPositionId("p");
        employeeDto.setPosition(positionDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/home/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEmployee_account_15() throws Exception  {
        EmployeeDTO employeeDto = new EmployeeDTO();
         employeeDto.setEmployeeName("Hậu");
        employeeDto.setEmployeeBirthday("2001-10-31");
        employeeDto.setEmployeeGender(true);
        employeeDto.setEmployeeGmail("hau@gmail.com");
        employeeDto.setEmployeeIdCard("206888999");
        employeeDto.setEmployeeAddress("Quảng Nam");
        employeeDto.setEmployeePhone("099988778");
        employeeDto.setEmployeeSalary(1000.0);

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUsername("");
        accountDTO.setPassword("123456");
        employeeDto.setAccount(accountDTO);

        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setPositionId("1");
        employeeDto.setPosition(positionDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/home/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee_account_16() throws Exception  {
        EmployeeDTO employeeDto = new EmployeeDTO();
         employeeDto.setEmployeeName("Hậu");
        employeeDto.setEmployeeBirthday("2001-10-31");
        employeeDto.setEmployeeGender(true);
        employeeDto.setEmployeeGmail("hau@gmail.com");
        employeeDto.setEmployeeIdCard("206888999");
        employeeDto.setEmployeeAddress("Quảng Nam");
        employeeDto.setEmployeePhone("099988778");
        employeeDto.setEmployeeSalary(1000.0);

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUsername("");
        accountDTO.setPassword("1");
        employeeDto.setAccount(accountDTO);

        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setPositionId("1");
        employeeDto.setPosition(positionDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/home/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEmployee_account_17() throws Exception  {
        EmployeeDTO employeeDto = new EmployeeDTO();
         employeeDto.setEmployeeName("Hậu");
        employeeDto.setEmployeeBirthday("2001-10-31");
        employeeDto.setEmployeeGender(true);
        employeeDto.setEmployeeGmail("hau@gmail.com");
        employeeDto.setEmployeeIdCard("206888999");
        employeeDto.setEmployeeAddress("Quảng Nam");
        employeeDto.setEmployeePhone("099988778");
        employeeDto.setEmployeeSalary(1000.0);

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUsername("abccc");
        accountDTO.setPassword("112122222222211111111111111111111111111222222");
        employeeDto.setAccount(accountDTO);

        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setPositionId("1");
        employeeDto.setPosition(positionDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/home/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee_all_18() throws Exception  {
        EmployeeDTO employeeDto = new EmployeeDTO();
         employeeDto.setEmployeeName("Hậu");
        employeeDto.setEmployeeBirthday("2001-10-31");
        employeeDto.setEmployeeGender(true);
        employeeDto.setEmployeeGmail("leconghau095@gmail.com");
        employeeDto.setEmployeeIdCard("206888999");
        employeeDto.setEmployeeAddress("Quảng Nam");
        employeeDto.setEmployeePhone("099988778");
        employeeDto.setEmployeeSalary(1000.0);

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUsername("leconghau");
        accountDTO.setPassword("123456");
        employeeDto.setAccount(accountDTO);

        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setPositionId("1");
        employeeDto.setPosition(positionDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/home/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
