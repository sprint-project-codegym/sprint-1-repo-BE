package com.example.sprint_1.controller;

import com.example.sprint_1.dto.ground.GroundDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
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
public class GroundController_editGround {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    //test id = null
    @Test
    public void editGround_id_19() throws Exception {
        GroundDTO groundDTO = new GroundDTO();
        groundDTO.setGroundId("null");
        groundDTO.setGroundType("Mặt sau");
        groundDTO.setArea(1000.0);
        groundDTO.setImage("image/ground.jpg");
        groundDTO.setStatus("Đang thuê");
        groundDTO.setRentCost(2000.0);
        groundDTO.setManageCost(200.0);
        groundDTO.setNote("ground");
        groundDTO.setVersion(0);
        groundDTO.setFloorId("FL-0001");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/ground/edit/{id}","MB-0006").content(this.objectMapper.writeValueAsString(groundDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
    //test id = rỗng
    @Test
    public void editGround_id_20() throws Exception {
        GroundDTO groundDTO = new GroundDTO();
        groundDTO.setGroundId("");
        groundDTO.setGroundType("Mặt sau");
        groundDTO.setArea(1000.0);
        groundDTO.setImage("image/ground.jpg");
        groundDTO.setStatus("Đang thuê");
        groundDTO.setRentCost(2000.0);
        groundDTO.setManageCost(200.0);
        groundDTO.setNote("ground");
        groundDTO.setVersion(0);
        groundDTO.setFloorId("FL-0001");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/ground/edit/{id}","MB-0006").content(this.objectMapper.writeValueAsString(groundDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    //test id = invalid format
    @Test
    public void editGround_id_21() throws Exception {
        GroundDTO groundDTO = new GroundDTO();
        groundDTO.setGroundId("FL-0001");
        groundDTO.setGroundType("Mặt sau");
        groundDTO.setArea(1000.0);
        groundDTO.setImage("image/ground.jpg");
        groundDTO.setStatus("Đang thuê");
        groundDTO.setRentCost(2000.0);
        groundDTO.setManageCost(200.0);
        groundDTO.setNote("ground");
        groundDTO.setVersion(0);
        groundDTO.setFloorId("FL-0001");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/ground/edit/{id}","MB-0006").content(this.objectMapper.writeValueAsString(groundDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    //test groundType = rỗng
    @Test
    public void editGround_groundType_19() throws Exception {
        GroundDTO groundDTO = new GroundDTO();
        groundDTO.setGroundId("MB-1111");
        groundDTO.setGroundType("");
        groundDTO.setArea(1000.0);
        groundDTO.setImage("image/ground.jpg");
        groundDTO.setStatus("Đang thuê");
        groundDTO.setRentCost(2000.0);
        groundDTO.setManageCost(200.0);
        groundDTO.setNote("ground");
        groundDTO.setVersion(0);
        groundDTO.setFloorId("FL-0001");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/ground/edit/{id}","MB-0006").content(this.objectMapper.writeValueAsString(groundDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    //test area = null
    @Test
    public void editGround_area_19() throws Exception {
        GroundDTO groundDTO = new GroundDTO();
        groundDTO.setGroundId("MB-1111");
        groundDTO.setGroundType("Mặt sau");
        groundDTO.setArea(null);
        groundDTO.setImage("image/ground.jpg");
        groundDTO.setStatus("Đang thuê");
        groundDTO.setRentCost(2000.0);
        groundDTO.setManageCost(200.0);
        groundDTO.setNote("ground");
        groundDTO.setVersion(0);
        groundDTO.setFloorId("FL-0001");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/ground/edit/{id}","MB-0006").content(this.objectMapper.writeValueAsString(groundDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    //test area là số âm
    @Test
    public void editGround_area_21() throws Exception {
        GroundDTO groundDTO = new GroundDTO();
        groundDTO.setGroundId("MB-1111");
        groundDTO.setGroundType("Mặt sau");
        groundDTO.setArea(-230.0);
        groundDTO.setImage("image/ground.jpg");
        groundDTO.setStatus("Đang thuê");
        groundDTO.setRentCost(2000.0);
        groundDTO.setManageCost(200.0);
        groundDTO.setNote("ground");
        groundDTO.setVersion(0);
        groundDTO.setFloorId("FL-0001");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/ground/edit/{id}","MB-0006").content(this.objectMapper.writeValueAsString(groundDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    //test image null
    @Test
    public void editGround_image_19() throws Exception {
        GroundDTO groundDTO = new GroundDTO();
        groundDTO.setGroundId("MB-1111");
        groundDTO.setGroundType("Mặt sau");
        groundDTO.setArea(500.0);
        groundDTO.setImage(null);
        groundDTO.setStatus("Đang thuê");
        groundDTO.setRentCost(2000.0);
        groundDTO.setManageCost(200.0);
        groundDTO.setNote("ground");
        groundDTO.setVersion(0);
        groundDTO.setFloorId("FL-0001");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/ground/edit/{id}","MB-0006").content(this.objectMapper.writeValueAsString(groundDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
    //test image rỗng
    @Test
    public void editGround_image_20() throws Exception {
        GroundDTO groundDTO = new GroundDTO();
        groundDTO.setGroundId("MB-1111");
        groundDTO.setGroundType("Mặt sau");
        groundDTO.setArea(500.0);
        groundDTO.setImage("");
        groundDTO.setStatus("Đang thuê");
        groundDTO.setRentCost(2000.0);
        groundDTO.setManageCost(200.0);
        groundDTO.setNote("ground");
        groundDTO.setVersion(0);
        groundDTO.setFloorId("FL-0001");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/ground/edit/{id}","MB-0006").content(this.objectMapper.writeValueAsString(groundDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
    //test status null
    @Test
    public void editGround_status_19() throws Exception {
        GroundDTO groundDTO = new GroundDTO();
        groundDTO.setGroundId("MB-1111");
        groundDTO.setGroundType("Mặt sau");
        groundDTO.setArea(500.0);
        groundDTO.setImage("image/ground.jpg");
        groundDTO.setStatus(null);
        groundDTO.setRentCost(2000.0);
        groundDTO.setManageCost(200.0);
        groundDTO.setNote("ground");
        groundDTO.setVersion(0);
        groundDTO.setFloorId("FL-0001");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/ground/edit/{id}","MB-0006").content(this.objectMapper.writeValueAsString(groundDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
    //test status rỗng
    @Test
    public void editGround_status_20() throws Exception {
        GroundDTO groundDTO = new GroundDTO();
        groundDTO.setGroundId("MB-1111");
        groundDTO.setGroundType("Mặt sau");
        groundDTO.setArea(500.0);
        groundDTO.setImage("image/ground.jpg");
        groundDTO.setStatus("");
        groundDTO.setRentCost(2000.0);
        groundDTO.setManageCost(200.0);
        groundDTO.setNote("ground");
        groundDTO.setVersion(0);
        groundDTO.setFloorId("FL-0001");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/ground/edit/{id}","MB-0006").content(this.objectMapper.writeValueAsString(groundDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    //test floorId null
    @Test
    public void editGround_floorID_19() throws Exception {
        GroundDTO groundDTO = new GroundDTO();
        groundDTO.setGroundId("MB-1111");
        groundDTO.setGroundType("Mặt sau");
        groundDTO.setArea(500.0);
        groundDTO.setImage("image/ground.jpg");
        groundDTO.setStatus("Đang thuê");
        groundDTO.setRentCost(2000.0);
        groundDTO.setManageCost(200.0);
        groundDTO.setNote("ground");
        groundDTO.setVersion(0);
        groundDTO.setFloorId(null);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/ground/edit/{id}","MB-0006").content(this.objectMapper.writeValueAsString(groundDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
    //test floorId rỗng
    @Test
    public void editGround_floorID_21() throws Exception {
        GroundDTO groundDTO = new GroundDTO();
        groundDTO.setGroundId("MB-1111");
        groundDTO.setGroundType("Mặt sau");
        groundDTO.setArea(500.0);
        groundDTO.setImage("image/ground.jpg");
        groundDTO.setStatus("Đang thuê");
        groundDTO.setRentCost(2000.0);
        groundDTO.setManageCost(200.0);
        groundDTO.setNote("ground");
        groundDTO.setVersion(0);
        groundDTO.setFloorId("");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/ground/edit/{id}","MB-0006").content(this.objectMapper.writeValueAsString(groundDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    //test rentCost null
    @Test
    public void editGround_rentCost_19() throws Exception {
        GroundDTO groundDTO = new GroundDTO();
        groundDTO.setGroundId("MB-1111");
        groundDTO.setGroundType("Mặt sau");
        groundDTO.setArea(500.0);
        groundDTO.setImage("image/ground.jpg");
        groundDTO.setStatus("Đang thuê");
        groundDTO.setRentCost(null);
        groundDTO.setManageCost(200.0);
        groundDTO.setNote("ground");
        groundDTO.setVersion(0);
        groundDTO.setFloorId("FL-0001");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/ground/edit/{id}","MB-0006").content(this.objectMapper.writeValueAsString(groundDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    //test rentCost là số âm
    @Test
    public void editGround_rentCost_21() throws Exception {
        GroundDTO groundDTO = new GroundDTO();
        groundDTO.setGroundId("MB-1111");
        groundDTO.setGroundType("Mặt sau");
        groundDTO.setArea(500.0);
        groundDTO.setImage("image/ground.jpg");
        groundDTO.setStatus("Đang thuê");
        groundDTO.setRentCost(-600.0);
        groundDTO.setManageCost(200.0);
        groundDTO.setNote("ground");
        groundDTO.setVersion(0);
        groundDTO.setFloorId("FL-0001");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/ground/edit/{id}","MB-0006").content(this.objectMapper.writeValueAsString(groundDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    //test manageCost null
    @Test
    public void editGround_manageCost_19() throws Exception {
        GroundDTO groundDTO = new GroundDTO();
        groundDTO.setGroundId("MB-1111");
        groundDTO.setGroundType("Mặt sau");
        groundDTO.setArea(500.0);
        groundDTO.setImage("image/ground.jpg");
        groundDTO.setStatus("Đang thuê");
        groundDTO.setRentCost(600.0);
        groundDTO.setManageCost(null);
        groundDTO.setNote("ground");
        groundDTO.setVersion(0);
        groundDTO.setFloorId("FL-0001");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/ground/edit/{id}","MB-0006").content(this.objectMapper.writeValueAsString(groundDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    //test manageCost là số âm
    @Test
    public void editGround_manageCost_21() throws Exception {
        GroundDTO groundDTO = new GroundDTO();
        groundDTO.setGroundId("MB-1111");
        groundDTO.setGroundType("Mặt sau");
        groundDTO.setArea(500.0);
        groundDTO.setImage("image/ground.jpg");
        groundDTO.setStatus("Đang thuê");
        groundDTO.setRentCost(600.0);
        groundDTO.setManageCost(-200.0);
        groundDTO.setNote("ground");
        groundDTO.setVersion(0);
        groundDTO.setFloorId("FL-0001");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/ground/edit/{id}","MB-0006").content(this.objectMapper.writeValueAsString(groundDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    //test all valid
    @Test
    public void editGround_24() throws Exception {
        GroundDTO groundDTO = new GroundDTO();
        groundDTO.setGroundId("MB-0132");
        groundDTO.setGroundType("Mặt sau");
        groundDTO.setArea(500.0);
        groundDTO.setImage("image/ground.jpg");
        groundDTO.setStatus("Đang thuê");
        groundDTO.setRentCost(600.0);
        groundDTO.setManageCost(200.0);
        groundDTO.setNote("ground");
        groundDTO.setVersion(0);
        groundDTO.setFloorId("FL-0001");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/ground/edit/{id}","MB-0006").content(this.objectMapper.writeValueAsString(groundDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }
}
