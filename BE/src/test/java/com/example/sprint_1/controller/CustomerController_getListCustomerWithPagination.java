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
public class CustomerController_getListCustomerWithPagination {

    @Autowired
    private MockMvc mockMvc;

    // get list theo điều kiện search theo id = "null", name = "null"
    @Test
    public void getListCustomerWithPagination_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/public/customer/list/?id={id}&name={name}", "null", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // get list theo điều kiện search theo id = "null"
    @Test
    public void getListCustomerWithPagination_1_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/public/customer/list/?id={id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // get list theo điều kiện  search theo name = "null"
    @Test
    public void getListCustomerWithPagination_1_2() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/public/customer/list/?name={name}",  "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // get list theo điều kiện search theo id = "null", name = "Dũng", name tồn tại trong DB
    @Test
    public void getListCustomerWithPagination_1_3() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/public/customer/list/?id={id}&name={name}", "null","Dũng"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // get list theo điều kiện search theo id = "C001" name = "null", id tồn tại trong DB
    @Test
    public void getListCustomerWithPagination_1_4() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/public/customer/list/?id={id}&name={name}", "C001","null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // get list theo điều kiện  search theo id = "", name = ""
    @Test
    public void getListCustomerWithPagination_2() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/public/customer/list/?id={id}&name={name}", "", ""))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    // get list theo điều kiện search theo id= "", name = "Dũng", name có tồn tại trong DB
    @Test
    public void getListCustomerWithPagination_2_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/public/customer/list/?id={id}&name={name}", "", "Dũng"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    // get list theo điều kiện  search theo id= "C001", name = "", id có tồn tại trong DB
    @Test
    public void getListCustomerWithPagination_2_2() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/public/customer/list/?id={id}&name={name}", "C001", ""))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    // get list theo điều kiện  search theo id= "C0068", name = "", id không tồn tại trong DB
    @Test
    public void getListCustomerWithPagination_2_3() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/public/customer/list/?id={id}&name={name}", "C0068", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // get list theo điều kiện search theo id= "C001", name = "Bình", name không tồn tại trong DB
    @Test
    public void getListCustomerWithPagination_2_4() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/public/customer/list/?id={id}&name={name}", "C001", "Bình"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    // get list theo điều kiện search id = "C006",name = "Bình" cả id và name không tồn tại trong DB
    @Test
    public void getListCustomerWithPagination_3() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/public/customer/list/?id={id}&name={name}", "C006", "Bình"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // get list theo điều kiện search id = "C005",name = "Bình", id tồn tại trong DB nhưng name không tồn tại trong DB
    @Test
    public void getListCustomerWithPagination_3_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/public/customer/list/?id={id}&name={name}", "C005", "Bình"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //  get list theo điều kiện  search id = "C0068",name = "Dũng", id không tồn tại trong DB nhưng name tồn tại trong DB
    @Test
    public void getListCustomerWithPagination_3_2() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/public/customer/list/?id={id}&name={name}", "C005", "Dũng"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    // get list theo điều kiện không nhập trường search
    @Test
    public void getListCustomerWithPagination_4() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/public/customer/list"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    //  get list theo điều kiện search id = "C005",name = "Dũng", cả id và name tồn tại trong DB (tìm kiếm đúng)
    @Test
    public void getListCustomerWithPagination_4_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/public/customer/list/?id={id}&name={name}", "C005", "Mạnh"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    //  get list theo điều kiện search id = "C00",name = "n", (tìm kiếm gần đúng)
    @Test
    public void getListCustomerWithPagination_4_2() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/public/customer/list/?id={id}&name={name}", "C00", "n"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
