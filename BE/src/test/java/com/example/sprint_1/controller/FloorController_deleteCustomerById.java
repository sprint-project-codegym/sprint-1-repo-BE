package com.example.sprint_1.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FloorController_deleteCustomerById {

    @Autowired
    private MockMvc mockMvc;

    // PhuocDD test chuc nang xoa tang truong hop id la null
    @Test
    public void deleteFloor_25() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/delete/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // PhuocDD test chuc nang xoa tang truong hop id la rong
    @Test
    public void deleteFloor_26() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/delete/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // PhuocDD test chuc nang xoa tang truong hop id khong ton tai trong database
    @Test
    public void deleteFloor_27() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/delete/{id}", "T1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // PhuocDD test chuc nang xoa tang truong hop thanh cong co id ton tai trong database
    @Test
    public void deleteFloor_28() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/delete/{id}", "MTL0014"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.floorId").value("MTL0014"))
                .andExpect(jsonPath("$.floorName").value("Tầng 14"))
                .andExpect(jsonPath("$.area").value(350))
                .andExpect(jsonPath("$.capacity").value(20))
                .andExpect(jsonPath("$.status").value("Đang vào ở"))
                .andExpect(jsonPath("$.floorType").value("tầng 14"))
                .andExpect(jsonPath("$.building.buildingId").value(1));
    }
}
