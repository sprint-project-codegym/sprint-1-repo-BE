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
public class ContractController_getList {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getListContract_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/list?id={id}&customerName={customerName}", "null", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListContract_1_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/list?id={id}&customerName={customerName}", "null", "a"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListContract_1_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/list?id={id}&customerName={customerName}", "1", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListContract_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/list?id={id}&customerName={customerName}", "", ""))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void getListContract_2_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/list?id={id}&customerName={customerName}", "1", ""))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void getListContract_2_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/list?id={id}&customerName={customerName}", "", "a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void getListContract_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/list?id={id}&customerName={customerName}", "1", "a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
