package com.example.sprint_1.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.JsonPath;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GroundRestController_getGround {

    @Autowired
    private GroundController groundController;

    @Autowired
    private MockMvc mockMvc;

    // get list theo điều kiện search theo id = "null", name = "null"
    @Test
    public void getListGround_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/public/ground/list?id={id}&groundType={groundType}","null","null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    // get list theo điều kiện search theo id = "null", name = "a"
    @Test
    public void getListGround_1_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/public/ground/list?id={id}&groundType={groundType}","null","a"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    // get list theo điều kiện search theo id = "1", name = "null"
    @Test
    public void getListGround_1_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/public/ground/list?id={id}&groundType={groundType}","1","null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    // get list theo điều kiện search theo id = "", name = ""
    @Test
    public void getListGround_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/public/ground/list?id={id}&groundType={groundType}","",""))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    // get list theo điều kiện search theo id = "1", name = ""
    @Test
    public void getListGround_2_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/public/ground/list?id={id}&groundType={groundType}","1",""))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    // get list theo điều kiện search theo id = "", name = "a"
    @Test
    public void getListGround_2_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/public/ground/list?id={id}&groundType={groundType}","","a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    // get list theo điều kiện search theo id = "1", name = "a"
    @Test
    public void getListGround_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/public/ground/list?id={id}&groundType={groundType}","1","a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}