package com.example.sprint_1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
@SpringBootTest
@AutoConfigureMockMvc
public class PersonalInfoController_showInfo {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    //Test [id] = null - 1

    @Test
    public void getInfoEmployee_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/personal-info/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test [id] = "" - 2

    @Test
    public void getInfoEmployee_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/personal-info/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test [id] không tồn tại trong db - 3

    @Test
    public void getInfoEmployee_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/personal-info/{id}", "E002"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test [id] tồn tại trong db - 4

    @Test
    public void getInfoEmployee_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/personal-info/{id}", "E001"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
