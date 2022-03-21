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
public class ContractController_deleteContractById {
    @Autowired
    private MockMvc mockMvc;

    // xóa contract với id = "null"
    @Test
    public void deleteCOntractById_25() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.delete("/list/delete/{id}","null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //xóa contract với id = ""
    @Test
    public void deleteCustomerById_26() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.delete("/list/delete/{id}",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //xóa contract với id ="C0068" không tồn tại trong DB
    @Test
    public void deleteContractById_27() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.delete("/list/delete/{id}","CT000"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //xóa contract với id = "CT002" tồn tại trong DB
    @Test
    public void deleteContractById_28() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.delete("/list/delete/{id}","CT005"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}