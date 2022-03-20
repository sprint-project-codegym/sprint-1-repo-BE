package com.example.sprint_1.controller;

import com.example.sprint_1.dto.employee.EmployeeAcountDTO;
import com.example.sprint_1.dto.security.AccountDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
@SpringBootTest
@AutoConfigureMockMvc
public class PersonalInfoController_ChangePassword {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    //No.19 - Test items null
    @Test
    public void change_user_password_19() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountId(1);
        accountDTO.setUserName("admin");
        accountDTO.setEmail("khoa4755@gmail.com");
        accountDTO.setEncryptPw(null);
        accountDTO.setEnable(true);

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/user-change-password/{id}", 1)
                .content(this.objectMapper.writeValueAsString(accountDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //No.20 - Test items ""
    @Test
    public void change_user_password_20() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountId(1);
        accountDTO.setUserName("admin");
        accountDTO.setEmail("khoa4755@gmail.com");
        accountDTO.setEncryptPw("");
        accountDTO.setEnable(true);

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/user-change-password/{id}", 1)
                .content(this.objectMapper.writeValueAsString(accountDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //No.24 - Test all items hợp lệ
    @Test
    public void change_user_password_24() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountId(1);
        accountDTO.setUserName("admin");
        accountDTO.setEmail("khoa4755@gmail.com");
        accountDTO.setEncryptPw("$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu");
        accountDTO.setEnable(true);

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/user-change-password/{id}", 1)
                .content(this.objectMapper.writeValueAsString(accountDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


}
