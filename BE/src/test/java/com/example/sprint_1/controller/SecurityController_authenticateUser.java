package com.example.sprint_1.controller;

import com.example.sprint_1.dto.security.payload.request.LoginRequest;
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
public class SecurityController_authenticateUser {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    //username= "null"
    @Test
    public void authenticateUser_username_15() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("null");
        loginRequest.setPassword("123");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/home/login")
                        .content(this.objectMapper.writeValueAsString(loginRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //password= "null"
    @Test
    public void authenticateUser_password_15() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("admin");
        loginRequest.setPassword("null");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/home/login")
                        .content(this.objectMapper.writeValueAsString(loginRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //username= ""
    @Test
    public void authenticateUser_username_16() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("");
        loginRequest.setPassword("123");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/home/login")
                        .content(this.objectMapper.writeValueAsString(loginRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    //password= ""
    @Test
    public void authenticateUser_password_16() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("admin");
        loginRequest.setPassword("");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/home/login")
                        .content(this.objectMapper.writeValueAsString(loginRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    // Username không được trống, tối thiểu 4 ký tự,tối đa 30 ký tự, không chứa ký tự đặc biệt(trừ . và @) và khoảng trắng
    // Mật khẩu không được trống, tối thiểu 3 ký tự,tối đa 15 ký tự
}
