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
    public void authenticateUser_username_13() throws Exception {
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
    public void authenticateUser_password_13() throws Exception {
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

    //username= "null" and password= "null"
    @Test
    public void authenticateUser_username_password_13() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("null");
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
    public void authenticateUser_username_14() throws Exception {
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
    public void authenticateUser_password_14() throws Exception {
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

    //username= "" and password= ""
    @Test
    public void authenticateUser_username_password_14() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("");
        loginRequest.setPassword("");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/home/login")
                        .content(this.objectMapper.writeValueAsString(loginRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //username không chứa ký tự đặc biệt(trừ . và @)
    @Test
    public void authenticateUser_username_15_1() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("minh%!kh@a.tr");
        loginRequest.setPassword("123");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/home/login")
                        .content(this.objectMapper.writeValueAsString(loginRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //username không chứa khoảng trắng
    @Test
    public void authenticateUser_username_15_2() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("minh khoa");
        loginRequest.setPassword("123");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/home/login")
                        .content(this.objectMapper.writeValueAsString(loginRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // username tối thiểu 4 ký tự
    @Test
    public void authenticateUser_username_16() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("min");
        loginRequest.setPassword("123");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/home/login")
                        .content(this.objectMapper.writeValueAsString(loginRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //password tối thiểu 3 ký tự
    @Test
    public void authenticateUser_password_16() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("admin");
        loginRequest.setPassword("12");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/home/login")
                        .content(this.objectMapper.writeValueAsString(loginRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //username tối đa 30 ký tự
    @Test
    public void authenticateUser_username_17() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("tranminhkhoadev06102000@gmail.com");
        loginRequest.setPassword("123");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/home/login")
                        .content(this.objectMapper.writeValueAsString(loginRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //password tối đa 15 ký tự
    @Test
    public void authenticateUser_password_17() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("admin");
        loginRequest.setPassword("123456789101112131415");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/home/login")
                        .content(this.objectMapper.writeValueAsString(loginRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // username and password correct
    @Test
    public void authenticateUser_18() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("admin");
        loginRequest.setPassword("123");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/home/login")
                        .content(this.objectMapper.writeValueAsString(loginRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
