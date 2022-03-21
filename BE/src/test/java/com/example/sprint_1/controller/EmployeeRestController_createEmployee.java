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
    public void createEmployee_name_14() throws Exception  {
        EmployeeDTO employeeDto = new EmployeeDTO();
        employeeDto.setName(null);
        employeeDto.setDateOfBirth("2001-10-31");
        employeeDto.setGender(true);
        employeeDto.setEmail("hau@gmail.com");
        employeeDto.setIdCard("206777555");
        employeeDto.setAddress("Quảng Nam");
        employeeDto.setPhone("099988778");
        employeeDto.setSalary(1000.0);

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

    @Test
    public void createEmployee_dateOfBirth_14() throws Exception  {
        EmployeeDTO employeeDto = new EmployeeDTO();
        employeeDto.setName("Hậu");
        employeeDto.setDateOfBirth(null);
        employeeDto.setGender(true);
        employeeDto.setEmail("hau@gmail.com");
        employeeDto.setIdCard("206777555");
        employeeDto.setAddress("Quảng Nam");
        employeeDto.setPhone("099988778");
        employeeDto.setSalary(1000.0);

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
    public void createEmployee_gender_14() throws Exception  {
        EmployeeDTO employeeDto = new EmployeeDTO();
        employeeDto.setName("Hậu");
        employeeDto.setDateOfBirth("2001-10-31");
        employeeDto.setGender(null);
        employeeDto.setEmail("hau@gmail.com");
        employeeDto.setIdCard("206777555");
        employeeDto.setAddress("Quảng Nam");
        employeeDto.setPhone("099988778");
        employeeDto.setSalary(1000.0);

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
        employeeDto.setName("Hậu");
        employeeDto.setDateOfBirth("2001-10-31");
        employeeDto.setGender(true);
        employeeDto.setEmail(null);
        employeeDto.setIdCard("206777555");
        employeeDto.setAddress("Quảng Nam");
        employeeDto.setPhone("099988778");
        employeeDto.setSalary(1000.0);

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
        employeeDto.setName("Hậu");
        employeeDto.setDateOfBirth("2001-10-31");
        employeeDto.setGender(true);
        employeeDto.setEmail("hau@gmail.com");
        employeeDto.setIdCard(null);
        employeeDto.setAddress("Quảng Nam");
        employeeDto.setPhone("099988778");
        employeeDto.setSalary(1000.0);

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
}
