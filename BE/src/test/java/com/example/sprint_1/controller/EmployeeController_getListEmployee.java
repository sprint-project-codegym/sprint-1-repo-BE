package com.example.sprint_1.controller;

import com.example.sprint_1.entity.employee.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeController_getListEmployee {
    @Autowired
    private EmployeeController employeeController;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void getListEmployee_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/employee/?name={name}&id={id}","null","null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getListEmployee_1_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/employee/?name={name}&id={id}","c","null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getListEmployee_1_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/employee/?name={name}&id={id}","null",1))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getListEmployee_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/employee/?name={name}&id={id}","",""))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void getListEmployee_2_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/employee/?name={name}&id={id}","c",""))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void getListEmployee_2_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/employee/?name={name}&id={id}","",1))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void getListEmployee_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/employee/?name={name}&id={id}","c",1))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    
}
