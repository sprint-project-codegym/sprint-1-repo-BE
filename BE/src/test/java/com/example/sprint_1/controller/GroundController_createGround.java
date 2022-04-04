package com.example.sprint_1.controller;

import com.example.sprint_1.dto.ground.GroundCreateDTO;
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
class GroundController_createGround {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    //id = null
    @Test
    void createGround_id_13() throws Exception {
        GroundCreateDTO groundCreateDTO = new GroundCreateDTO();
        groundCreateDTO.setGroundId(null);
        groundCreateDTO.setGroundType("Mặt tiền");
        groundCreateDTO.setArea(50.0);
        groundCreateDTO.setImage("image/ground1.jpg");
        groundCreateDTO.setStatus("Chưa bàn giao");
        groundCreateDTO.setRentCost(1000.0);
        groundCreateDTO.setManageCost(100.0);
        groundCreateDTO.setNote("abc");
        groundCreateDTO.setVersion(0);

        FloorDTO floorDTO = new FloorDTO();
        floorDTO.setFloorId("FL-0001");
        groundCreateDTO.setFloorDTO(floorDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager/ground/create")
                        .content(this.objectMapper.writeValueAsString(groundCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //id = ""
    @Test
    void createGround_id_14() throws Exception {
        GroundCreateDTO groundCreateDTO = new GroundCreateDTO();
        groundCreateDTO.setGroundId("");
        groundCreateDTO.setGroundType("Mặt tiền");
        groundCreateDTO.setArea(50.0);
        groundCreateDTO.setImage("image/ground1.jpg");
        groundCreateDTO.setStatus("Chưa bàn giao");
        groundCreateDTO.setRentCost(1000.0);
        groundCreateDTO.setManageCost(100.0);
        groundCreateDTO.setNote("abc");
        groundCreateDTO.setVersion(0);

        FloorDTO floorDTO = new FloorDTO();
        floorDTO.setFloorId("FL-0001");
        groundCreateDTO.setFloorDTO(floorDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager/ground/create")
                        .content(this.objectMapper.writeValueAsString(groundCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    //id invalid format
    @Test
    void createGround_id_15() throws Exception {
        GroundCreateDTO groundCreateDTO = new GroundCreateDTO();
        groundCreateDTO.setGroundId("abcde");
        groundCreateDTO.setGroundType("Mặt tiền");
        groundCreateDTO.setArea(50.0);
        groundCreateDTO.setImage("image/ground1.jpg");
        groundCreateDTO.setStatus("Chưa bàn giao");
        groundCreateDTO.setRentCost(1000.0);
        groundCreateDTO.setManageCost(100.0);
        groundCreateDTO.setNote("abc");
        groundCreateDTO.setVersion(0);

        FloorDTO floorDTO = new FloorDTO();
        floorDTO.setFloorId("FL-0001");
        groundCreateDTO.setFloorDTO(floorDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager/ground/create")
                        .content(this.objectMapper.writeValueAsString(groundCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //type = null
    @Test
    void createGround_type_13() throws Exception {
        GroundCreateDTO groundCreateDTO = new GroundCreateDTO();
        groundCreateDTO.setGroundId("MB-0001");
        groundCreateDTO.setGroundType(null);
        groundCreateDTO.setArea(50.0);
        groundCreateDTO.setImage("image/ground1.jpg");
        groundCreateDTO.setStatus("Chưa bàn giao");
        groundCreateDTO.setRentCost(1000.0);
        groundCreateDTO.setManageCost(100.0);
        groundCreateDTO.setNote("abc");
        groundCreateDTO.setVersion(0);

        FloorDTO floorDTO = new FloorDTO();
        floorDTO.setFloorId("FL-0001");
        groundCreateDTO.setFloorDTO(floorDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager/ground/create")
                        .content(this.objectMapper.writeValueAsString(groundCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //type = ""
    @Test
    void createGround_type_14() throws Exception {
        GroundCreateDTO groundCreateDTO = new GroundCreateDTO();
        groundCreateDTO.setGroundId("MB-0001");
        groundCreateDTO.setGroundType("");
        groundCreateDTO.setArea(50.0);
        groundCreateDTO.setImage("image/ground1.jpg");
        groundCreateDTO.setStatus("Chưa bàn giao");
        groundCreateDTO.setRentCost(1000.0);
        groundCreateDTO.setManageCost(100.0);
        groundCreateDTO.setNote("abc");
        groundCreateDTO.setVersion(0);

        FloorDTO floorDTO = new FloorDTO();
        floorDTO.setFloorId("FL-0001");
        groundCreateDTO.setFloorDTO(floorDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager/ground/create")
                        .content(this.objectMapper.writeValueAsString(groundCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //type <= min length
    @Test
    void createGround_type_16() throws Exception {
        GroundCreateDTO groundCreateDTO = new GroundCreateDTO();
        groundCreateDTO.setGroundId("MB-0001");
        groundCreateDTO.setGroundType("z");
        groundCreateDTO.setArea(50.0);
        groundCreateDTO.setImage("image/ground1.jpg");
        groundCreateDTO.setStatus("Chưa bàn giao");
        groundCreateDTO.setRentCost(1000.0);
        groundCreateDTO.setManageCost(100.0);
        groundCreateDTO.setNote("abc");
        groundCreateDTO.setVersion(0);

        FloorDTO floorDTO = new FloorDTO();
        floorDTO.setFloorId("FL-0001");
        groundCreateDTO.setFloorDTO(floorDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager/ground/create")
                        .content(this.objectMapper.writeValueAsString(groundCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //type >= min length
    @Test
    void createGround_type_17() throws Exception {
        GroundCreateDTO groundCreateDTO = new GroundCreateDTO();
        groundCreateDTO.setGroundId("MB-0001");
        groundCreateDTO.setGroundType("abcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabc");
        groundCreateDTO.setArea(50.0);
        groundCreateDTO.setImage("image/ground1.jpg");
        groundCreateDTO.setStatus("Chưa bàn giao");
        groundCreateDTO.setRentCost(1000.0);
        groundCreateDTO.setManageCost(100.0);
        groundCreateDTO.setNote("abc");
        groundCreateDTO.setVersion(0);

        FloorDTO floorDTO = new FloorDTO();
        floorDTO.setFloorId("FL-0001");
        groundCreateDTO.setFloorDTO(floorDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager/ground/create")
                        .content(this.objectMapper.writeValueAsString(groundCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //area = null
    @Test
    void createGround_area_13() throws Exception {
        GroundCreateDTO groundCreateDTO = new GroundCreateDTO();
        groundCreateDTO.setGroundId("MB-0001");
        groundCreateDTO.setGroundType("Mặt tiền");
        groundCreateDTO.setArea(null);
        groundCreateDTO.setImage("image/ground1.jpg");
        groundCreateDTO.setStatus("Chưa bàn giao");
        groundCreateDTO.setRentCost(1000.0);
        groundCreateDTO.setManageCost(100.0);
        groundCreateDTO.setNote("abc");
        groundCreateDTO.setVersion(0);

        FloorDTO floorDTO = new FloorDTO();
        floorDTO.setFloorId("FL-0001");
        groundCreateDTO.setFloorDTO(floorDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager/ground/create")
                        .content(this.objectMapper.writeValueAsString(groundCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //area < 0
    @Test
    void createGround_area_15() throws Exception {
        GroundCreateDTO groundCreateDTO = new GroundCreateDTO();
        groundCreateDTO.setGroundId("MB-0001");
        groundCreateDTO.setGroundType("Mặt tiền");
        groundCreateDTO.setArea(-3.0);
        groundCreateDTO.setImage("image/ground1.jpg");
        groundCreateDTO.setStatus("Chưa bàn giao");
        groundCreateDTO.setRentCost(1000.0);
        groundCreateDTO.setManageCost(100.0);
        groundCreateDTO.setNote("abc");
        groundCreateDTO.setVersion(0);

        FloorDTO floorDTO = new FloorDTO();
        floorDTO.setFloorId("FL-0001");
        groundCreateDTO.setFloorDTO(floorDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager/ground/create")
                        .content(this.objectMapper.writeValueAsString(groundCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //image = null
    @Test
    void createGround_image_13() throws Exception {
        GroundCreateDTO groundCreateDTO = new GroundCreateDTO();
        groundCreateDTO.setGroundId("MB-0001");
        groundCreateDTO.setGroundType("Mặt tiền");
        groundCreateDTO.setArea(50.0);
        groundCreateDTO.setImage(null);
        groundCreateDTO.setStatus("Chưa bàn giao");
        groundCreateDTO.setRentCost(1000.0);
        groundCreateDTO.setManageCost(100.0);
        groundCreateDTO.setNote("abc");
        groundCreateDTO.setVersion(0);

        FloorDTO floorDTO = new FloorDTO();
        floorDTO.setFloorId("FL-0001");
        groundCreateDTO.setFloorDTO(floorDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager/ground/create")
                        .content(this.objectMapper.writeValueAsString(groundCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    //image = ""
    @Test
    void createGround_image_14() throws Exception {
        GroundCreateDTO groundCreateDTO = new GroundCreateDTO();
        groundCreateDTO.setGroundId("MB-0001");
        groundCreateDTO.setGroundType("Mặt tiền");
        groundCreateDTO.setArea(50.0);
        groundCreateDTO.setImage("");
        groundCreateDTO.setStatus("Chưa bàn giao");
        groundCreateDTO.setRentCost(1000.0);
        groundCreateDTO.setManageCost(100.0);
        groundCreateDTO.setNote("abc");
        groundCreateDTO.setVersion(0);

        FloorDTO floorDTO = new FloorDTO();
        floorDTO.setFloorId("FL-0001");
        groundCreateDTO.setFloorDTO(floorDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager/ground/create")
                        .content(this.objectMapper.writeValueAsString(groundCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //status = null
    @Test
    void createGround_status_13() throws Exception {
        GroundCreateDTO groundCreateDTO = new GroundCreateDTO();
        groundCreateDTO.setGroundId("MB-0001");
        groundCreateDTO.setGroundType("Mặt tiền");
        groundCreateDTO.setArea(50.0);
        groundCreateDTO.setImage("image/ground1.jpg");
        groundCreateDTO.setStatus(null);
        groundCreateDTO.setRentCost(1000.0);
        groundCreateDTO.setManageCost(100.0);
        groundCreateDTO.setNote("abc");
        groundCreateDTO.setVersion(0);

        FloorDTO floorDTO = new FloorDTO();
        floorDTO.setFloorId("FL-0001");
        groundCreateDTO.setFloorDTO(floorDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager/ground/create")
                        .content(this.objectMapper.writeValueAsString(groundCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //status = ""
    @Test
    void createGround_status_14() throws Exception {
        GroundCreateDTO groundCreateDTO = new GroundCreateDTO();
        groundCreateDTO.setGroundId("MB-0001");
        groundCreateDTO.setGroundType("Mặt tiền");
        groundCreateDTO.setArea(50.0);
        groundCreateDTO.setImage("image/ground1.jpg");
        groundCreateDTO.setStatus("");
        groundCreateDTO.setRentCost(1000.0);
        groundCreateDTO.setManageCost(100.0);
        groundCreateDTO.setNote("abc");
        groundCreateDTO.setVersion(0);

        FloorDTO floorDTO = new FloorDTO();
        floorDTO.setFloorId("FL-0001");
        groundCreateDTO.setFloorDTO(floorDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager/ground/create")
                        .content(this.objectMapper.writeValueAsString(groundCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //rentCost = null
    @Test
    void createGround_rentCost_13() throws Exception {
        GroundCreateDTO groundCreateDTO = new GroundCreateDTO();
        groundCreateDTO.setGroundId("MB-0001");
        groundCreateDTO.setGroundType("Mặt tiền");
        groundCreateDTO.setArea(50.0);
        groundCreateDTO.setImage("image/ground1.jpg");
        groundCreateDTO.setStatus("Chưa bàn giao");
        groundCreateDTO.setRentCost(null);
        groundCreateDTO.setManageCost(100.0);
        groundCreateDTO.setNote("abc");
        groundCreateDTO.setVersion(0);

        FloorDTO floorDTO = new FloorDTO();
        floorDTO.setFloorId("FL-0001");
        groundCreateDTO.setFloorDTO(floorDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager/ground/create")
                        .content(this.objectMapper.writeValueAsString(groundCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //rentCost < 0
    @Test
    void createGround_rentCost_15() throws Exception {
        GroundCreateDTO groundCreateDTO = new GroundCreateDTO();
        groundCreateDTO.setGroundId("MB-0001");
        groundCreateDTO.setGroundType("Mặt tiền");
        groundCreateDTO.setArea(50.0);
        groundCreateDTO.setImage("image/ground1.jpg");
        groundCreateDTO.setStatus("Chưa bàn giao");
        groundCreateDTO.setRentCost(-10.0);
        groundCreateDTO.setManageCost(100.0);
        groundCreateDTO.setNote("abc");
        groundCreateDTO.setVersion(0);

        FloorDTO floorDTO = new FloorDTO();
        floorDTO.setFloorId("FL-0001");
        groundCreateDTO.setFloorDTO(floorDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager/ground/create")
                        .content(this.objectMapper.writeValueAsString(groundCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //mamageCost = null
    @Test
    void createGround_manageCost_13() throws Exception {
        GroundCreateDTO groundCreateDTO = new GroundCreateDTO();
        groundCreateDTO.setGroundId("MB-0001");
        groundCreateDTO.setGroundType("Mặt tiền");
        groundCreateDTO.setArea(50.0);
        groundCreateDTO.setImage("image/ground1.jpg");
        groundCreateDTO.setStatus("Chưa bàn giao");
        groundCreateDTO.setRentCost(1000.0);
        groundCreateDTO.setManageCost(null);
        groundCreateDTO.setNote("abc");
        groundCreateDTO.setVersion(0);

        FloorDTO floorDTO = new FloorDTO();
        floorDTO.setFloorId("FL-0001");
        groundCreateDTO.setFloorDTO(floorDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager/ground/create")
                        .content(this.objectMapper.writeValueAsString(groundCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //manageCost < 0
    @Test
    void createGround_manageCost_15() throws Exception {
        GroundCreateDTO groundCreateDTO = new GroundCreateDTO();
        groundCreateDTO.setGroundId("MB-0001");
        groundCreateDTO.setGroundType("Mặt tiền");
        groundCreateDTO.setArea(50.0);
        groundCreateDTO.setImage("image/ground1.jpg");
        groundCreateDTO.setStatus("Chưa bàn giao");
        groundCreateDTO.setRentCost(1000.0);
        groundCreateDTO.setManageCost(-10.0);
        groundCreateDTO.setNote("abc");
        groundCreateDTO.setVersion(0);

        FloorDTO floorDTO = new FloorDTO();
        floorDTO.setFloorId("FL-0001");
        groundCreateDTO.setFloorDTO(floorDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager/ground/create")
                        .content(this.objectMapper.writeValueAsString(groundCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //floor = null
    @Test
    void createGround_floor_13() throws Exception {
        GroundCreateDTO groundCreateDTO = new GroundCreateDTO();
        groundCreateDTO.setGroundId("MB-0001");
        groundCreateDTO.setGroundType("Mặt tiền");
        groundCreateDTO.setArea(50.0);
        groundCreateDTO.setImage("image/ground1.jpg");
        groundCreateDTO.setStatus("Chưa bàn giao");
        groundCreateDTO.setRentCost(1000.0);
        groundCreateDTO.setManageCost(100.0);
        groundCreateDTO.setNote("abc");
        groundCreateDTO.setVersion(0);

        FloorDTO floorDTO = new FloorDTO();
        floorDTO.setFloorId(null);
        groundCreateDTO.setFloorDTO(floorDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager/ground/create")
                        .content(this.objectMapper.writeValueAsString(groundCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //floor = ""
    @Test
    void createGround_floor_14() throws Exception {
        GroundCreateDTO groundCreateDTO = new GroundCreateDTO();
        groundCreateDTO.setGroundId("MB-0001");
        groundCreateDTO.setGroundType("Mặt tiền");
        groundCreateDTO.setArea(50.0);
        groundCreateDTO.setImage("image/ground1.jpg");
        groundCreateDTO.setStatus("Chưa bàn giao");
        groundCreateDTO.setRentCost(1000.0);
        groundCreateDTO.setManageCost(100.0);
        groundCreateDTO.setNote("abc");
        groundCreateDTO.setVersion(0);

        FloorDTO floorDTO = new FloorDTO();
        floorDTO.setFloorId("");
        groundCreateDTO.setFloorDTO(floorDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager/ground/create")
                        .content(this.objectMapper.writeValueAsString(groundCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //all valid item
    @Test
    void createGround_18() throws Exception {
        GroundCreateDTO groundCreateDTO = new GroundCreateDTO();
        groundCreateDTO.setGroundId("MB-0001");
        groundCreateDTO.setGroundType("Mặt tiền");
        groundCreateDTO.setArea(50.0);
        groundCreateDTO.setImage("image/ground1.jpg");
        groundCreateDTO.setStatus("Chưa bàn giao");
        groundCreateDTO.setRentCost(1000.0);
        groundCreateDTO.setManageCost(100.0);
        groundCreateDTO.setNote("abc");
        groundCreateDTO.setVersion(0);

        FloorDTO floorDTO = new FloorDTO();
        floorDTO.setFloorId("FL-0001");
        groundCreateDTO.setFloorDTO(floorDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager/ground/create")
                        .content(this.objectMapper.writeValueAsString(groundCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
