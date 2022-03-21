package com.example.sprint_1.controller;

import com.example.sprint_1.dto.contract.ContractDTO;
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
public class ContractController_createContract {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    //id = null
    @Test
    public void createContract_id_13() throws Exception {
        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setContractId(null);
        contractDTO.setStartDate("2022-03-03");
        contractDTO.setEndDate("2022-03-04");
        contractDTO.setContractDate("2022-03-03");
        contractDTO.setRentCost(200.5);
        contractDTO.setTotalCost(300.5);
        contractDTO.setContractContent("Hợp đồng");
        contractDTO.setDeleteFlag(true);
        contractDTO.setCustomerId("C001");
        contractDTO.setEmployeeId("E006");
        contractDTO.setGroundId("2");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //id = ""
    @Test
    public void createContract_id_14() throws Exception {
        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setContractId("");
        contractDTO.setStartDate("2022-03-03");
        contractDTO.setEndDate("2022-03-04");
        contractDTO.setContractDate("2022-03-03");
        contractDTO.setRentCost(200.5);
        contractDTO.setTotalCost(300.5);
        contractDTO.setContractContent("Hợp đồng");
        contractDTO.setDeleteFlag(true);
        contractDTO.setCustomerId("C001");
        contractDTO.setEmployeeId("E006");
        contractDTO.setGroundId("2");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //id khong hop le
    @Test
    public void createContract_id_15() throws Exception {
        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setContractId("aaaaa");
        contractDTO.setStartDate("2022-03-03");
        contractDTO.setEndDate("2022-03-04");
        contractDTO.setContractDate("2022-03-03");
        contractDTO.setRentCost(200.5);
        contractDTO.setTotalCost(300.5);
        contractDTO.setContractContent("Hợp đồng");
        contractDTO.setDeleteFlag(true);
        contractDTO.setCustomerId("C001");
        contractDTO.setEmployeeId("E006");
        contractDTO.setGroundId("2");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //start date = null
    @Test
    public void createContract_startDate_13() throws Exception {
        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setContractId("HD-0001");
        contractDTO.setStartDate(null);
        contractDTO.setEndDate("2022-03-04");
        contractDTO.setContractDate("2022-03-03");
        contractDTO.setRentCost(200.5);
        contractDTO.setTotalCost(300.5);
        contractDTO.setContractContent("Hợp đồng");
        contractDTO.setDeleteFlag(true);
        contractDTO.setCustomerId("C001");
        contractDTO.setEmployeeId("E006");
        contractDTO.setGroundId("2");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //start date = ""
    @Test
    public void createContract_startDate_14() throws Exception {
        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setContractId("HD-0001");
        contractDTO.setStartDate("");
        contractDTO.setEndDate("2022-03-04");
        contractDTO.setContractDate("2022-03-03");
        contractDTO.setRentCost(200.5);
        contractDTO.setTotalCost(300.5);
        contractDTO.setContractContent("Hợp đồng");
        contractDTO.setDeleteFlag(true);
        contractDTO.setCustomerId("C001");
        contractDTO.setEmployeeId("E006");
        contractDTO.setGroundId("2");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //start date khong hop le
    @Test
    public void createContract_startDate_15() throws Exception {
        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setContractId("HD-0001");
        contractDTO.setStartDate("asasd");
        contractDTO.setEndDate("2022-03-04");
        contractDTO.setContractDate("2022-03-03");
        contractDTO.setRentCost(200.5);
        contractDTO.setTotalCost(300.5);
        contractDTO.setContractContent("Hợp đồng");
        contractDTO.setDeleteFlag(true);
        contractDTO.setCustomerId("C001");
        contractDTO.setEmployeeId("E006");
        contractDTO.setGroundId("2");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //end date = null
    @Test
    public void createContract_endDate_13() throws Exception {
        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setContractId("HD-0001");
        contractDTO.setStartDate("2022-03-04");
        contractDTO.setEndDate(null);
        contractDTO.setContractDate("2022-03-03");
        contractDTO.setRentCost(200.5);
        contractDTO.setTotalCost(300.5);
        contractDTO.setContractContent("Hợp đồng");
        contractDTO.setDeleteFlag(true);
        contractDTO.setCustomerId("C001");
        contractDTO.setEmployeeId("E006");
        contractDTO.setGroundId("2");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //end date = ""
    @Test
    public void createContract_endDate_14() throws Exception {
        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setContractId("HD-0001");
        contractDTO.setStartDate("2022-03-04");
        contractDTO.setEndDate("");
        contractDTO.setContractDate("2022-03-03");
        contractDTO.setRentCost(200.5);
        contractDTO.setTotalCost(300.5);
        contractDTO.setContractContent("Hợp đồng");
        contractDTO.setDeleteFlag(true);
        contractDTO.setCustomerId("C001");
        contractDTO.setEmployeeId("E006");
        contractDTO.setGroundId("2");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //end date khong hop le
    @Test
    public void createContract_endDate_15() throws Exception {
        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setContractId("HD-0001");
        contractDTO.setStartDate("2022-03-04");
        contractDTO.setEndDate("asdasd");
        contractDTO.setContractDate("2022-03-03");
        contractDTO.setRentCost(200.5);
        contractDTO.setTotalCost(300.5);
        contractDTO.setContractContent("Hợp đồng");
        contractDTO.setDeleteFlag(true);
        contractDTO.setCustomerId("C001");
        contractDTO.setEmployeeId("E006");
        contractDTO.setGroundId("2");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //contract date = null
    @Test
    public void createContract_contractDate_13() throws Exception {
        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setContractId("HD-0001");
        contractDTO.setStartDate("2022-03-04");
        contractDTO.setEndDate("2022-04-04");
        contractDTO.setContractDate(null);
        contractDTO.setRentCost(200.5);
        contractDTO.setTotalCost(300.5);
        contractDTO.setContractContent("Hợp đồng");
        contractDTO.setDeleteFlag(true);
        contractDTO.setCustomerId("C001");
        contractDTO.setEmployeeId("E006");
        contractDTO.setGroundId("2");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //contract date = ""
    @Test
    public void createContract_contractDate_14() throws Exception {
        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setContractId("HD-0001");
        contractDTO.setStartDate("2022-03-04");
        contractDTO.setEndDate("2022-04-04");
        contractDTO.setContractDate("");
        contractDTO.setRentCost(200.5);
        contractDTO.setTotalCost(300.5);
        contractDTO.setContractContent("Hợp đồng");
        contractDTO.setDeleteFlag(true);
        contractDTO.setCustomerId("C001");
        contractDTO.setEmployeeId("E006");
        contractDTO.setGroundId("2");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //contract date khong hop le
    @Test
    public void createContract_contractDate_15() throws Exception {
        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setContractId("HD-0001");
        contractDTO.setStartDate("2022-03-04");
        contractDTO.setEndDate("2022-04-04");
        contractDTO.setContractDate("asdasd");
        contractDTO.setRentCost(200.5);
        contractDTO.setTotalCost(300.5);
        contractDTO.setContractContent("Hợp đồng");
        contractDTO.setDeleteFlag(true);
        contractDTO.setCustomerId("C001");
        contractDTO.setEmployeeId("E006");
        contractDTO.setGroundId("2");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //rent cost = null
    @Test
    public void createContract_rentCost_13() throws Exception {
        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setContractId("HD-0001");
        contractDTO.setStartDate("2022-03-04");
        contractDTO.setEndDate("2022-04-04");
        contractDTO.setContractDate("asdasd");
        contractDTO.setRentCost(null);
        contractDTO.setTotalCost(300.5);
        contractDTO.setContractContent("Hợp đồng");
        contractDTO.setDeleteFlag(true);
        contractDTO.setCustomerId("C001");
        contractDTO.setEmployeeId("E006");
        contractDTO.setGroundId("2");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //rent cost khong hop le
    @Test
    public void createContract_rentCost_15() throws Exception {
        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setContractId("HD-0001");
        contractDTO.setStartDate("2022-03-04");
        contractDTO.setEndDate("2022-04-04");
        contractDTO.setContractDate("asdasd");
        contractDTO.setRentCost(-1.2);
        contractDTO.setTotalCost(300.5);
        contractDTO.setContractContent("Hợp đồng");
        contractDTO.setDeleteFlag(true);
        contractDTO.setCustomerId("C001");
        contractDTO.setEmployeeId("E006");
        contractDTO.setGroundId("2");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //total cost = null
    @Test
    public void createContract_totalCost_13() throws Exception {
        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setContractId("HD-0001");
        contractDTO.setStartDate("2022-03-04");
        contractDTO.setEndDate("2022-04-04");
        contractDTO.setContractDate("asdasd");
        contractDTO.setRentCost(100.2);
        contractDTO.setTotalCost(null);
        contractDTO.setContractContent("Hợp đồng");
        contractDTO.setDeleteFlag(true);
        contractDTO.setCustomerId("C001");
        contractDTO.setEmployeeId("E006");
        contractDTO.setGroundId("2");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //total cost khong hop le
    @Test
    public void createContract_totalCost_15() throws Exception {
        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setContractId("HD-0001");
        contractDTO.setStartDate("2022-03-04");
        contractDTO.setEndDate("2022-04-04");
        contractDTO.setContractDate("asdasd");
        contractDTO.setRentCost(100.2);
        contractDTO.setTotalCost(-111.2);
        contractDTO.setContractContent("Hợp đồng");
        contractDTO.setDeleteFlag(true);
        contractDTO.setCustomerId("C001");
        contractDTO.setEmployeeId("E006");
        contractDTO.setGroundId("2");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
