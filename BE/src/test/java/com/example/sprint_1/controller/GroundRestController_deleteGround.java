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
public class GroundRestController_deleteGround {
    @Autowired
    private MockMvc mockMvc;

    // delete list theo id = "null"
    @Test
    public void deleteGround_25() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/public/ground/delete/{id}","null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    // delete list theo id = ""
    @Test
    public void deleteGround_26() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/public/ground/delete/{id}",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    // delete list theo id = "MB-111"
    @Test
    public void deleteGround_27() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/public/ground/delete/{id}","MB-111"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    // delete list theo id = "1"
    @Test
    public void deleteGround_28() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/public/ground/delete/{id}","1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
