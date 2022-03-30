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
class FloorController_deleteFloorById {
    @Autowired
    private MockMvc mockMvc;

    // PhuocDD test chuc nang xoa tang truong hop id la null
    @Test
    void deleteFloor_25() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .delete("/api/public/floor/delete/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // PhuocDD test chuc nang xoa tang truong hop id la rong
    @Test
    void deleteFloor_26() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/api/public/floor/delete/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // PhuocDD test chuc nang xoa tang truong hop id khong ton tai trong database
    @Test
    void deleteFloor_27() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/api/public/floor/delete/{id}", "T1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // PhuocDD test chuc nang xoa tang truong hop thanh cong co id ton tai trong database
    @Test
    void deleteFloor_28() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/api/public/floor/delete/{id}", "MTL0014"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
