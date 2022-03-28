package com.example.sprint_1.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerController_deleteCustomerById {
    @Autowired
    private MockMvc mockMvc;

    // xóa customer với id = "null"
    @Test
    public void deleteCustomerById_25() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.delete("/api/public/customer/delete/{id}","null"))
                        .andDo(print())
                        .andExpect(status().is4xxClientError());
    }

    //xóa customer với id = ""
    @Test
    public void deleteCustomerById_26() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.delete("/api/public/customer/delete/{id}",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //xóa customer với id ="C0068" không tồn tại trong DB
    @Test
    public void deleteCustomerById_27() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.delete("/api/public/customer/delete/{id}","C0068"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //xóa customer với id = "C003" tồn tại trong DB
    @Test
    public void deleteCustomerById_28() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.delete("/api/public/customer/delete/{id}","C003"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
