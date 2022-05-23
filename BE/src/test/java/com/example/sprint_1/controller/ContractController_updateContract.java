//package com.example.sprint_1.controller;
//
//import com.example.sprint_1.dto.contract.ContractDTO;
//import com.example.sprint_1.dto.customer.CustomerDTO;
//import com.example.sprint_1.dto.employee.EmployeeDTO;
//import com.example.sprint_1.dto.ground.GroundDTO;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebAppConfiguration
//@SpringBootTest
//@AutoConfigureMockMvc
//public class ContractController_updateContract {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    ObjectMapper objectMapper;
//
//    //Test items null - 19
//
//
//    @Test
//    public void edit_contract_contractId_19() throws Exception {
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setEmployeeId("E001");
//        employeeDTO.setEmployeeName("Nguyễn Thái Học");
//        employeeDTO.setEmployeeBirthday("2000-05-06");
//        employeeDTO.setEmployeeGender(true);
//        employeeDTO.setEmployeeIdCard("236568986");
//        employeeDTO.setEmployeeGmail("nthaihoc@gmail.com");
//        employeeDTO.setEmployeeAddress("Quảng Nam");
//        employeeDTO.setEmployeePhone("0365635686");
//        employeeDTO.setEmployeeSalary(1500.0);
//        employeeDTO.setDeleteFlag(true);
//
//        GroundDTO groundDTO = new GroundDTO();
//        groundDTO.setGroundId("1");
//        groundDTO.setGroundType("Normal");
//        groundDTO.setArea(100.0);
//        groundDTO.setImage("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.agiusa.com%2Fhow-to-test-for-land-subsidence-before-breaking-ground&psig=AOvVaw1Y54PIx8yoUsaxPjao-7IG&ust=1647396516755000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKCUqbqEx_YCFQAAAAAdAAAAABAU");
//        groundDTO.setStatus("stutas");
//        groundDTO.setRentCost(1000.0);
//        groundDTO.setManageCost(1000.0);
//        groundDTO.setNote("note");
//        groundDTO.setVersion(1);
//        groundDTO.setDeleteFlag(true);
//
//        CustomerDTO customerDTO = new CustomerDTO();
//        customerDTO.setCustomerId("C002");
//        customerDTO.setCustomerName("Nguyễn Thái Học");
//        customerDTO.setCustomerBirthday("2000-05-06");
//        customerDTO.setCustomerIdCard("236568986");
//        customerDTO.setCustomerEmail("nthaihoc@gmail.com");
//        customerDTO.setCustomerAddress("Quảng Nam");
//        customerDTO.setCustomerPhone("0365635686");
//        customerDTO.setCustomerCompany("Codegym");
//        customerDTO.setStatus("Đang thuê");
//        customerDTO.setDeleteFlag(true);
//
//        ContractDTO contractDTO = new ContractDTO();
//        contractDTO.setContractId(null);
//        contractDTO.setStartDate("2022-03-30");
//        contractDTO.setEndDate("2022-03-30");
//        contractDTO.setContractDate("2022-03-30");
//        contractDTO.setRentCost(10000.0);
//        contractDTO.setTotalCost(10000.0);
//        contractDTO.setContractContent("gggg");
//        contractDTO.setDeleteFlag(true);
//
//        contractDTO.setCustomer(customerDTO);
//
//        contractDTO.setEmployee(employeeDTO);
//
//        contractDTO.setGround(groundDTO);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/contract/edit")
//                        .content(this.objectMapper.writeValueAsString(contractDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void edit_contract_startDate_19() throws Exception {
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setEmployeeId("E001");
//        employeeDTO.setEmployeeName("Nguyễn Thái Học");
//        employeeDTO.setEmployeeBirthday("2000-05-06");
//        employeeDTO.setEmployeeGender(true);
//        employeeDTO.setEmployeeIdCard("236568986");
//        employeeDTO.setEmployeeGmail("nthaihoc@gmail.com");
//        employeeDTO.setEmployeeAddress("Quảng Nam");
//        employeeDTO.setEmployeePhone("0365635686");
//        employeeDTO.setEmployeeSalary(1500.0);
//        employeeDTO.setDeleteFlag(true);
//
//        GroundDTO groundDTO = new GroundDTO();
//        groundDTO.setGroundId("1");
//        groundDTO.setGroundType("Normal");
//        groundDTO.setArea(100.0);
//        groundDTO.setImage("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.agiusa.com%2Fhow-to-test-for-land-subsidence-before-breaking-ground&psig=AOvVaw1Y54PIx8yoUsaxPjao-7IG&ust=1647396516755000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKCUqbqEx_YCFQAAAAAdAAAAABAU");
//        groundDTO.setStatus("stutas");
//        groundDTO.setRentCost(1000.0);
//        groundDTO.setManageCost(1000.0);
//        groundDTO.setNote("note");
//        groundDTO.setVersion(1);
//        groundDTO.setDeleteFlag(true);
//
//        CustomerDTO customerDTO = new CustomerDTO();
//        customerDTO.setCustomerId("C002");
//        customerDTO.setCustomerName("Nguyễn Thái Học");
//        customerDTO.setCustomerBirthday("2000-05-06");
//        customerDTO.setCustomerIdCard("236568986");
//        customerDTO.setCustomerEmail("nthaihoc@gmail.com");
//        customerDTO.setCustomerAddress("Quảng Nam");
//        customerDTO.setCustomerPhone("0365635686");
//        customerDTO.setCustomerCompany("Codegym");
//        customerDTO.setStatus("Đang thuê");
//        customerDTO.setDeleteFlag(true);
//
//        ContractDTO contractDTO = new ContractDTO();
//        contractDTO.setContractId("E001");
//        contractDTO.setStartDate(null);
//        contractDTO.setEndDate("2022-03-30");
//        contractDTO.setContractDate("2022-03-30");
//        contractDTO.setRentCost(10000.0);
//        contractDTO.setTotalCost(10000.0);
//        contractDTO.setContractContent("gggg");
//        contractDTO.setDeleteFlag(true);
//
//        contractDTO.setCustomer(customerDTO);
//
//        contractDTO.setEmployee(employeeDTO);
//
//        contractDTO.setGround(groundDTO);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/contract/edit")
//                        .content(this.objectMapper.writeValueAsString(contractDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void edit_contract_endDate_19() throws Exception {
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setEmployeeId("E001");
//        employeeDTO.setEmployeeName("Nguyễn Thái Học");
//        employeeDTO.setEmployeeBirthday("2000-05-06");
//        employeeDTO.setEmployeeGender(true);
//        employeeDTO.setEmployeeIdCard("236568986");
//        employeeDTO.setEmployeeGmail("nthaihoc@gmail.com");
//        employeeDTO.setEmployeeAddress("Quảng Nam");
//        employeeDTO.setEmployeePhone("0365635686");
//        employeeDTO.setEmployeeSalary(1500.0);
//        employeeDTO.setDeleteFlag(true);
//
//        GroundDTO groundDTO = new GroundDTO();
//        groundDTO.setGroundId("1");
//        groundDTO.setGroundType("Normal");
//        groundDTO.setArea(100.0);
//        groundDTO.setImage("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.agiusa.com%2Fhow-to-test-for-land-subsidence-before-breaking-ground&psig=AOvVaw1Y54PIx8yoUsaxPjao-7IG&ust=1647396516755000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKCUqbqEx_YCFQAAAAAdAAAAABAU");
//        groundDTO.setStatus("stutas");
//        groundDTO.setRentCost(1000.0);
//        groundDTO.setManageCost(1000.0);
//        groundDTO.setNote("note");
//        groundDTO.setVersion(1);
//        groundDTO.setDeleteFlag(true);
//
//        CustomerDTO customerDTO = new CustomerDTO();
//        customerDTO.setCustomerId("C002");
//        customerDTO.setCustomerName("Nguyễn Thái Học");
//        customerDTO.setCustomerBirthday("2000-05-06");
//        customerDTO.setCustomerIdCard("236568986");
//        customerDTO.setCustomerEmail("nthaihoc@gmail.com");
//        customerDTO.setCustomerAddress("Quảng Nam");
//        customerDTO.setCustomerPhone("0365635686");
//        customerDTO.setCustomerCompany("Codegym");
//        customerDTO.setStatus("Đang thuê");
//        customerDTO.setDeleteFlag(true);
//
//        ContractDTO contractDTO = new ContractDTO();
//        contractDTO.setContractId("E001");
//        contractDTO.setStartDate("2022-03-30");
//        contractDTO.setEndDate(null);
//        contractDTO.setContractDate("2022-03-30");
//        contractDTO.setRentCost(10000.0);
//        contractDTO.setTotalCost(10000.0);
//        contractDTO.setContractContent("gggg");
//        contractDTO.setDeleteFlag(true);
//
//        contractDTO.setCustomer(customerDTO);
//
//        contractDTO.setEmployee(employeeDTO);
//
//        contractDTO.setGround(groundDTO);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/contract/edit")
//                        .content(this.objectMapper.writeValueAsString(contractDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//    @Test
//    public void edit_contract_contractDate_19() throws Exception {
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setEmployeeId("E001");
//        employeeDTO.setEmployeeName("Nguyễn Thái Học");
//        employeeDTO.setEmployeeBirthday("2000-05-06");
//        employeeDTO.setEmployeeGender(true);
//        employeeDTO.setEmployeeIdCard("236568986");
//        employeeDTO.setEmployeeGmail("nthaihoc@gmail.com");
//        employeeDTO.setEmployeeAddress("Quảng Nam");
//        employeeDTO.setEmployeePhone("0365635686");
//        employeeDTO.setEmployeeSalary(1500.0);
//        employeeDTO.setDeleteFlag(true);
//
//        GroundDTO groundDTO = new GroundDTO();
//        groundDTO.setGroundId("1");
//        groundDTO.setGroundType("Normal");
//        groundDTO.setArea(100.0);
//        groundDTO.setImage("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.agiusa.com%2Fhow-to-test-for-land-subsidence-before-breaking-ground&psig=AOvVaw1Y54PIx8yoUsaxPjao-7IG&ust=1647396516755000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKCUqbqEx_YCFQAAAAAdAAAAABAU");
//        groundDTO.setStatus("stutas");
//        groundDTO.setRentCost(1000.0);
//        groundDTO.setManageCost(1000.0);
//        groundDTO.setNote("note");
//        groundDTO.setVersion(1);
//        groundDTO.setDeleteFlag(true);
//
//        CustomerDTO customerDTO = new CustomerDTO();
//        customerDTO.setCustomerId("C002");
//        customerDTO.setCustomerName("Nguyễn Thái Học");
//        customerDTO.setCustomerBirthday("2000-05-06");
//        customerDTO.setCustomerIdCard("236568986");
//        customerDTO.setCustomerEmail("nthaihoc@gmail.com");
//        customerDTO.setCustomerAddress("Quảng Nam");
//        customerDTO.setCustomerPhone("0365635686");
//        customerDTO.setCustomerCompany("Codegym");
//        customerDTO.setStatus("Đang thuê");
//        customerDTO.setDeleteFlag(true);
//
//        ContractDTO contractDTO = new ContractDTO();
//        contractDTO.setContractId(null);
//        contractDTO.setStartDate("2022-03-30");
//        contractDTO.setEndDate("2022-03-30");
//        contractDTO.setContractDate(null);
//        contractDTO.setRentCost(10000.0);
//        contractDTO.setTotalCost(10000.0);
//        contractDTO.setContractContent("gggg");
//        contractDTO.setDeleteFlag(true);
//
//        contractDTO.setCustomer(customerDTO);
//
//        contractDTO.setEmployee(employeeDTO);
//
//        contractDTO.setGround(groundDTO);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/contract/edit")
//                        .content(this.objectMapper.writeValueAsString(contractDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void edit_contract_rentCost_19() throws Exception {
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setEmployeeId("E001");
//        employeeDTO.setEmployeeName("Nguyễn Thái Học");
//        employeeDTO.setEmployeeBirthday("2000-05-06");
//        employeeDTO.setEmployeeGender(true);
//        employeeDTO.setEmployeeIdCard("236568986");
//        employeeDTO.setEmployeeGmail("nthaihoc@gmail.com");
//        employeeDTO.setEmployeeAddress("Quảng Nam");
//        employeeDTO.setEmployeePhone("0365635686");
//        employeeDTO.setEmployeeSalary(1500.0);
//        employeeDTO.setDeleteFlag(true);
//
//        GroundDTO groundDTO = new GroundDTO();
//        groundDTO.setGroundId("1");
//        groundDTO.setGroundType("Normal");
//        groundDTO.setArea(100.0);
//        groundDTO.setImage("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.agiusa.com%2Fhow-to-test-for-land-subsidence-before-breaking-ground&psig=AOvVaw1Y54PIx8yoUsaxPjao-7IG&ust=1647396516755000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKCUqbqEx_YCFQAAAAAdAAAAABAU");
//        groundDTO.setStatus("stutas");
//        groundDTO.setRentCost(1000.0);
//        groundDTO.setManageCost(1000.0);
//        groundDTO.setNote("note");
//        groundDTO.setVersion(1);
//        groundDTO.setDeleteFlag(true);
//
//        CustomerDTO customerDTO = new CustomerDTO();
//        customerDTO.setCustomerId("C002");
//        customerDTO.setCustomerName("Nguyễn Thái Học");
//        customerDTO.setCustomerBirthday("2000-05-06");
//        customerDTO.setCustomerIdCard("236568986");
//        customerDTO.setCustomerEmail("nthaihoc@gmail.com");
//        customerDTO.setCustomerAddress("Quảng Nam");
//        customerDTO.setCustomerPhone("0365635686");
//        customerDTO.setCustomerCompany("Codegym");
//        customerDTO.setStatus("Đang thuê");
//        customerDTO.setDeleteFlag(true);
//
//        ContractDTO contractDTO = new ContractDTO();
//        contractDTO.setContractId("CT001");
//        contractDTO.setStartDate("2022-03-30");
//        contractDTO.setEndDate("2022-03-30");
//        contractDTO.setContractDate("2022-03-30");
//        contractDTO.setRentCost(null);
//        contractDTO.setTotalCost(10000.0);
//        contractDTO.setContractContent("gggg");
//        contractDTO.setDeleteFlag(true);
//
//        contractDTO.setCustomer(customerDTO);
//
//        contractDTO.setEmployee(employeeDTO);
//
//        contractDTO.setGround(groundDTO);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/contract/edit")
//                        .content(this.objectMapper.writeValueAsString(contractDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void edit_contract_totalCost_19() throws Exception {
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setEmployeeId("E001");
//        employeeDTO.setEmployeeName("Nguyễn Thái Học");
//        employeeDTO.setEmployeeBirthday("2000-05-06");
//        employeeDTO.setEmployeeGender(true);
//        employeeDTO.setEmployeeIdCard("236568986");
//        employeeDTO.setEmployeeGmail("nthaihoc@gmail.com");
//        employeeDTO.setEmployeeAddress("Quảng Nam");
//        employeeDTO.setEmployeePhone("0365635686");
//        employeeDTO.setEmployeeSalary(1500.0);
//        employeeDTO.setDeleteFlag(true);
//
//        GroundDTO groundDTO = new GroundDTO();
//        groundDTO.setGroundId("1");
//        groundDTO.setGroundType("Normal");
//        groundDTO.setArea(100.0);
//        groundDTO.setImage("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.agiusa.com%2Fhow-to-test-for-land-subsidence-before-breaking-ground&psig=AOvVaw1Y54PIx8yoUsaxPjao-7IG&ust=1647396516755000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKCUqbqEx_YCFQAAAAAdAAAAABAU");
//        groundDTO.setStatus("stutas");
//        groundDTO.setRentCost(1000.0);
//        groundDTO.setManageCost(1000.0);
//        groundDTO.setNote("note");
//        groundDTO.setVersion(1);
//        groundDTO.setDeleteFlag(true);
//
//        CustomerDTO customerDTO = new CustomerDTO();
//        customerDTO.setCustomerId("C002");
//        customerDTO.setCustomerName("Nguyễn Thái Học");
//        customerDTO.setCustomerBirthday("2000-05-06");
//        customerDTO.setCustomerIdCard("236568986");
//        customerDTO.setCustomerEmail("nthaihoc@gmail.com");
//        customerDTO.setCustomerAddress("Quảng Nam");
//        customerDTO.setCustomerPhone("0365635686");
//        customerDTO.setCustomerCompany("Codegym");
//        customerDTO.setStatus("Đang thuê");
//        customerDTO.setDeleteFlag(true);
//
//        ContractDTO contractDTO = new ContractDTO();
//        contractDTO.setContractId("CT001");
//        contractDTO.setStartDate(null);
//        contractDTO.setEndDate("2022-03-30");
//        contractDTO.setContractDate("2022-03-30");
//        contractDTO.setRentCost(10000.0);
//        contractDTO.setTotalCost(null);
//        contractDTO.setContractContent("gggg");
//        contractDTO.setDeleteFlag(true);
//
//        contractDTO.setCustomer(customerDTO);
//
//        contractDTO.setEmployee(employeeDTO);
//
//        contractDTO.setGround(groundDTO);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/contract/edit")
//                        .content(this.objectMapper.writeValueAsString(contractDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void edit_contract_contractContent_19() throws Exception {
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setEmployeeId("E001");
//        employeeDTO.setEmployeeName("Nguyễn Thái Học");
//        employeeDTO.setEmployeeBirthday("2000-05-06");
//        employeeDTO.setEmployeeGender(true);
//        employeeDTO.setEmployeeIdCard("236568986");
//        employeeDTO.setEmployeeGmail("nthaihoc@gmail.com");
//        employeeDTO.setEmployeeAddress("Quảng Nam");
//        employeeDTO.setEmployeePhone("0365635686");
//        employeeDTO.setEmployeeSalary(1500.0);
//        employeeDTO.setDeleteFlag(true);
//
//        GroundDTO groundDTO = new GroundDTO();
//        groundDTO.setGroundId("1");
//        groundDTO.setGroundType("Normal");
//        groundDTO.setArea(100.0);
//        groundDTO.setImage("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.agiusa.com%2Fhow-to-test-for-land-subsidence-before-breaking-ground&psig=AOvVaw1Y54PIx8yoUsaxPjao-7IG&ust=1647396516755000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKCUqbqEx_YCFQAAAAAdAAAAABAU");
//        groundDTO.setStatus("stutas");
//        groundDTO.setRentCost(1000.0);
//        groundDTO.setManageCost(1000.0);
//        groundDTO.setNote("note");
//        groundDTO.setVersion(1);
//        groundDTO.setDeleteFlag(true);
//
//        CustomerDTO customerDTO = new CustomerDTO();
//        customerDTO.setCustomerId("C002");
//        customerDTO.setCustomerName("Nguyễn Thái Học");
//        customerDTO.setCustomerBirthday("2000-05-06");
//        customerDTO.setCustomerIdCard("236568986");
//        customerDTO.setCustomerEmail("nthaihoc@gmail.com");
//        customerDTO.setCustomerAddress("Quảng Nam");
//        customerDTO.setCustomerPhone("0365635686");
//        customerDTO.setCustomerCompany("Codegym");
//        customerDTO.setStatus("Đang thuê");
//        customerDTO.setDeleteFlag(true);
//
//        ContractDTO contractDTO = new ContractDTO();
//        contractDTO.setContractId("E001");
//        contractDTO.setStartDate("2022-03-30");
//        contractDTO.setEndDate("2022-03-30");
//        contractDTO.setContractDate("2022-03-30");
//        contractDTO.setRentCost(10000.0);
//        contractDTO.setTotalCost(10000.0);
//        contractDTO.setContractContent(null);
//        contractDTO.setDeleteFlag(true);
//
//        contractDTO.setCustomer(customerDTO);
//
//        contractDTO.setEmployee(employeeDTO);
//
//        contractDTO.setGround(groundDTO);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/contract/edit")
//                        .content(this.objectMapper.writeValueAsString(contractDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//    //Test items "" - 20
//
//
//    @Test
//    public void edit_contract_contractId_20() throws Exception {
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setEmployeeId("E001");
//        employeeDTO.setEmployeeName("Nguyễn Thái Học");
//        employeeDTO.setEmployeeBirthday("2000-05-06");
//        employeeDTO.setEmployeeGender(true);
//        employeeDTO.setEmployeeIdCard("236568986");
//        employeeDTO.setEmployeeGmail("nthaihoc@gmail.com");
//        employeeDTO.setEmployeeAddress("Quảng Nam");
//        employeeDTO.setEmployeePhone("0365635686");
//        employeeDTO.setEmployeeSalary(1500.0);
//        employeeDTO.setDeleteFlag(true);
//
//        GroundDTO groundDTO = new GroundDTO();
//        groundDTO.setGroundId("1");
//        groundDTO.setGroundType("Normal");
//        groundDTO.setArea(100.0);
//        groundDTO.setImage("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.agiusa.com%2Fhow-to-test-for-land-subsidence-before-breaking-ground&psig=AOvVaw1Y54PIx8yoUsaxPjao-7IG&ust=1647396516755000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKCUqbqEx_YCFQAAAAAdAAAAABAU");
//        groundDTO.setStatus("stutas");
//        groundDTO.setRentCost(1000.0);
//        groundDTO.setManageCost(1000.0);
//        groundDTO.setNote("note");
//        groundDTO.setVersion(1);
//        groundDTO.setDeleteFlag(true);
//
//        CustomerDTO customerDTO = new CustomerDTO();
//        customerDTO.setCustomerId("C002");
//        customerDTO.setCustomerName("Nguyễn Thái Học");
//        customerDTO.setCustomerBirthday("2000-05-06");
//        customerDTO.setCustomerIdCard("236568986");
//        customerDTO.setCustomerEmail("nthaihoc@gmail.com");
//        customerDTO.setCustomerAddress("Quảng Nam");
//        customerDTO.setCustomerPhone("0365635686");
//        customerDTO.setCustomerCompany("Codegym");
//        customerDTO.setStatus("Đang thuê");
//        customerDTO.setDeleteFlag(true);
//
//        ContractDTO contractDTO = new ContractDTO();
//        contractDTO.setContractId("");
//        contractDTO.setStartDate("2022-03-30");
//        contractDTO.setEndDate("2022-03-30");
//        contractDTO.setContractDate("2022-03-30");
//        contractDTO.setRentCost(10000.0);
//        contractDTO.setTotalCost(10000.0);
//        contractDTO.setContractContent("gggg");
//        contractDTO.setDeleteFlag(true);
//
//        contractDTO.setCustomer(customerDTO);
//
//        contractDTO.setEmployee(employeeDTO);
//
//        contractDTO.setGround(groundDTO);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/contract/edit")
//                        .content(this.objectMapper.writeValueAsString(contractDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void edit_contract_startDate_20() throws Exception {
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setEmployeeId("E001");
//        employeeDTO.setEmployeeName("Nguyễn Thái Học");
//        employeeDTO.setEmployeeBirthday("2000-05-06");
//        employeeDTO.setEmployeeGender(true);
//        employeeDTO.setEmployeeIdCard("236568986");
//        employeeDTO.setEmployeeGmail("nthaihoc@gmail.com");
//        employeeDTO.setEmployeeAddress("Quảng Nam");
//        employeeDTO.setEmployeePhone("0365635686");
//        employeeDTO.setEmployeeSalary(1500.0);
//        employeeDTO.setDeleteFlag(true);
//
//        GroundDTO groundDTO = new GroundDTO();
//        groundDTO.setGroundId("1");
//        groundDTO.setGroundType("Normal");
//        groundDTO.setArea(100.0);
//        groundDTO.setImage("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.agiusa.com%2Fhow-to-test-for-land-subsidence-before-breaking-ground&psig=AOvVaw1Y54PIx8yoUsaxPjao-7IG&ust=1647396516755000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKCUqbqEx_YCFQAAAAAdAAAAABAU");
//        groundDTO.setStatus("stutas");
//        groundDTO.setRentCost(1000.0);
//        groundDTO.setManageCost(1000.0);
//        groundDTO.setNote("note");
//        groundDTO.setVersion(1);
//        groundDTO.setDeleteFlag(true);
//
//        CustomerDTO customerDTO = new CustomerDTO();
//        customerDTO.setCustomerId("C002");
//        customerDTO.setCustomerName("Nguyễn Thái Học");
//        customerDTO.setCustomerBirthday("2000-05-06");
//        customerDTO.setCustomerIdCard("236568986");
//        customerDTO.setCustomerEmail("nthaihoc@gmail.com");
//        customerDTO.setCustomerAddress("Quảng Nam");
//        customerDTO.setCustomerPhone("0365635686");
//        customerDTO.setCustomerCompany("Codegym");
//        customerDTO.setStatus("Đang thuê");
//        customerDTO.setDeleteFlag(true);
//
//        ContractDTO contractDTO = new ContractDTO();
//        contractDTO.setContractId("CT001");
//        contractDTO.setStartDate("");
//        contractDTO.setEndDate("2022-03-30");
//        contractDTO.setContractDate("2022-03-30");
//        contractDTO.setRentCost(10000.0);
//        contractDTO.setTotalCost(10000.0);
//        contractDTO.setContractContent("gggg");
//        contractDTO.setDeleteFlag(true);
//
//        contractDTO.setCustomer(customerDTO);
//
//        contractDTO.setEmployee(employeeDTO);
//
//        contractDTO.setGround(groundDTO);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/contract/edit")
//                        .content(this.objectMapper.writeValueAsString(contractDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void edit_contract_endDate_20() throws Exception {
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setEmployeeId("E001");
//        employeeDTO.setEmployeeName("Nguyễn Thái Học");
//        employeeDTO.setEmployeeBirthday("2000-05-06");
//        employeeDTO.setEmployeeGender(true);
//        employeeDTO.setEmployeeIdCard("236568986");
//        employeeDTO.setEmployeeGmail("nthaihoc@gmail.com");
//        employeeDTO.setEmployeeAddress("Quảng Nam");
//        employeeDTO.setEmployeePhone("0365635686");
//        employeeDTO.setEmployeeSalary(1500.0);
//        employeeDTO.setDeleteFlag(true);
//
//        GroundDTO groundDTO = new GroundDTO();
//        groundDTO.setGroundId("1");
//        groundDTO.setGroundType("Normal");
//        groundDTO.setArea(100.0);
//        groundDTO.setImage("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.agiusa.com%2Fhow-to-test-for-land-subsidence-before-breaking-ground&psig=AOvVaw1Y54PIx8yoUsaxPjao-7IG&ust=1647396516755000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKCUqbqEx_YCFQAAAAAdAAAAABAU");
//        groundDTO.setStatus("stutas");
//        groundDTO.setRentCost(1000.0);
//        groundDTO.setManageCost(1000.0);
//        groundDTO.setNote("note");
//        groundDTO.setVersion(1);
//        groundDTO.setDeleteFlag(true);
//
//        CustomerDTO customerDTO = new CustomerDTO();
//        customerDTO.setCustomerId("C002");
//        customerDTO.setCustomerName("Nguyễn Thái Học");
//        customerDTO.setCustomerBirthday("2000-05-06");
//        customerDTO.setCustomerIdCard("236568986");
//        customerDTO.setCustomerEmail("nthaihoc@gmail.com");
//        customerDTO.setCustomerAddress("Quảng Nam");
//        customerDTO.setCustomerPhone("0365635686");
//        customerDTO.setCustomerCompany("Codegym");
//        customerDTO.setStatus("Đang thuê");
//        customerDTO.setDeleteFlag(true);
//
//        ContractDTO contractDTO = new ContractDTO();
//        contractDTO.setContractId("CT001");
//        contractDTO.setStartDate("2022-03-30");
//        contractDTO.setEndDate("2022-03-30");
//        contractDTO.setContractDate("");
//        contractDTO.setRentCost(10000.0);
//        contractDTO.setTotalCost(10000.0);
//        contractDTO.setContractContent("gggg");
//        contractDTO.setDeleteFlag(true);
//
//        contractDTO.setCustomer(customerDTO);
//
//        contractDTO.setEmployee(employeeDTO);
//
//        contractDTO.setGround(groundDTO);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/contract/edit")
//                        .content(this.objectMapper.writeValueAsString(contractDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void edit_contract_contractDate_20() throws Exception {
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setEmployeeId("E001");
//        employeeDTO.setEmployeeName("Nguyễn Thái Học");
//        employeeDTO.setEmployeeBirthday("2000-05-06");
//        employeeDTO.setEmployeeGender(true);
//        employeeDTO.setEmployeeIdCard("236568986");
//        employeeDTO.setEmployeeGmail("nthaihoc@gmail.com");
//        employeeDTO.setEmployeeAddress("Quảng Nam");
//        employeeDTO.setEmployeePhone("0365635686");
//        employeeDTO.setEmployeeSalary(1500.0);
//        employeeDTO.setDeleteFlag(true);
//
//        GroundDTO groundDTO = new GroundDTO();
//        groundDTO.setGroundId("1");
//        groundDTO.setGroundType("Normal");
//        groundDTO.setArea(100.0);
//        groundDTO.setImage("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.agiusa.com%2Fhow-to-test-for-land-subsidence-before-breaking-ground&psig=AOvVaw1Y54PIx8yoUsaxPjao-7IG&ust=1647396516755000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKCUqbqEx_YCFQAAAAAdAAAAABAU");
//        groundDTO.setStatus("stutas");
//        groundDTO.setRentCost(1000.0);
//        groundDTO.setManageCost(1000.0);
//        groundDTO.setNote("note");
//        groundDTO.setVersion(1);
//        groundDTO.setDeleteFlag(true);
//
//        CustomerDTO customerDTO = new CustomerDTO();
//        customerDTO.setCustomerId("C002");
//        customerDTO.setCustomerName("Nguyễn Thái Học");
//        customerDTO.setCustomerBirthday("2000-05-06");
//        customerDTO.setCustomerIdCard("236568986");
//        customerDTO.setCustomerEmail("nthaihoc@gmail.com");
//        customerDTO.setCustomerAddress("Quảng Nam");
//        customerDTO.setCustomerPhone("0365635686");
//        customerDTO.setCustomerCompany("Codegym");
//        customerDTO.setStatus("Đang thuê");
//        customerDTO.setDeleteFlag(true);
//
//        ContractDTO contractDTO = new ContractDTO();
//        contractDTO.setContractId("CT001");
//        contractDTO.setStartDate("2022-03-30");
//        contractDTO.setEndDate("2022-03-30");
//        contractDTO.setContractDate("");
//        contractDTO.setRentCost(10000.0);
//        contractDTO.setTotalCost(10000.0);
//        contractDTO.setContractContent("gggg");
//        contractDTO.setDeleteFlag(true);
//
//        contractDTO.setCustomer(customerDTO);
//
//        contractDTO.setEmployee(employeeDTO);
//
//        contractDTO.setGround(groundDTO);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/contract/edit")
//                        .content(this.objectMapper.writeValueAsString(contractDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void edit_contract_contractContent_20() throws Exception {
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setEmployeeId("E001");
//        employeeDTO.setEmployeeName("Nguyễn Thái Học");
//        employeeDTO.setEmployeeBirthday("2000-05-06");
//        employeeDTO.setEmployeeGender(true);
//        employeeDTO.setEmployeeIdCard("236568986");
//        employeeDTO.setEmployeeGmail("nthaihoc@gmail.com");
//        employeeDTO.setEmployeeAddress("Quảng Nam");
//        employeeDTO.setEmployeePhone("0365635686");
//        employeeDTO.setEmployeeSalary(1500.0);
//        employeeDTO.setDeleteFlag(true);
//
//        GroundDTO groundDTO = new GroundDTO();
//        groundDTO.setGroundId("1");
//        groundDTO.setGroundType("Normal");
//        groundDTO.setArea(100.0);
//        groundDTO.setImage("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.agiusa.com%2Fhow-to-test-for-land-subsidence-before-breaking-ground&psig=AOvVaw1Y54PIx8yoUsaxPjao-7IG&ust=1647396516755000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKCUqbqEx_YCFQAAAAAdAAAAABAU");
//        groundDTO.setStatus("stutas");
//        groundDTO.setRentCost(1000.0);
//        groundDTO.setManageCost(1000.0);
//        groundDTO.setNote("note");
//        groundDTO.setVersion(1);
//        groundDTO.setDeleteFlag(true);
//
//        CustomerDTO customerDTO = new CustomerDTO();
//        customerDTO.setCustomerId("C002");
//        customerDTO.setCustomerName("Nguyễn Thái Học");
//        customerDTO.setCustomerBirthday("2000-05-06");
//        customerDTO.setCustomerIdCard("236568986");
//        customerDTO.setCustomerEmail("nthaihoc@gmail.com");
//        customerDTO.setCustomerAddress("Quảng Nam");
//        customerDTO.setCustomerPhone("0365635686");
//        customerDTO.setCustomerCompany("Codegym");
//        customerDTO.setStatus("Đang thuê");
//        customerDTO.setDeleteFlag(true);
//
//        ContractDTO contractDTO = new ContractDTO();
//        contractDTO.setContractId("CT001");
//        contractDTO.setStartDate("2022-03-30");
//        contractDTO.setEndDate("2022-03-30");
//        contractDTO.setContractDate("2022-03-30");
//        contractDTO.setRentCost(10000.0);
//        contractDTO.setTotalCost(10000.0);
//        contractDTO.setContractContent("");
//        contractDTO.setDeleteFlag(true);
//
//        contractDTO.setCustomer(customerDTO);
//
//        contractDTO.setEmployee(employeeDTO);
//
//        contractDTO.setGround(groundDTO);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/contract/edit")
//                        .content(this.objectMapper.writeValueAsString(contractDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//    //test items sai format - 21
//
//
//    @Test
//    public void edit_contract_startDate_21() throws Exception {
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setEmployeeId("E001");
//        employeeDTO.setEmployeeName("Nguyễn Thái Học");
//        employeeDTO.setEmployeeBirthday("2000-05-06");
//        employeeDTO.setEmployeeGender(true);
//        employeeDTO.setEmployeeIdCard("236568986");
//        employeeDTO.setEmployeeGmail("nthaihoc@gmail.com");
//        employeeDTO.setEmployeeAddress("Quảng Nam");
//        employeeDTO.setEmployeePhone("0365635686");
//        employeeDTO.setEmployeeSalary(1500.0);
//        employeeDTO.setDeleteFlag(true);
//
//        GroundDTO groundDTO = new GroundDTO();
//        groundDTO.setGroundId("1");
//        groundDTO.setGroundType("Normal");
//        groundDTO.setArea(100.0);
//        groundDTO.setImage("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.agiusa.com%2Fhow-to-test-for-land-subsidence-before-breaking-ground&psig=AOvVaw1Y54PIx8yoUsaxPjao-7IG&ust=1647396516755000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKCUqbqEx_YCFQAAAAAdAAAAABAU");
//        groundDTO.setStatus("stutas");
//        groundDTO.setRentCost(1000.0);
//        groundDTO.setManageCost(1000.0);
//        groundDTO.setNote("note");
//        groundDTO.setVersion(1);
//        groundDTO.setDeleteFlag(true);
//
//        CustomerDTO customerDTO = new CustomerDTO();
//        customerDTO.setCustomerId("C002");
//        customerDTO.setCustomerName("Nguyễn Thái Học");
//        customerDTO.setCustomerBirthday("2000-05-06");
//        customerDTO.setCustomerIdCard("236568986");
//        customerDTO.setCustomerEmail("nthaihoc@gmail.com");
//        customerDTO.setCustomerAddress("Quảng Nam");
//        customerDTO.setCustomerPhone("0365635686");
//        customerDTO.setCustomerCompany("Codegym");
//        customerDTO.setStatus("Đang thuê");
//        customerDTO.setDeleteFlag(true);
//
//        ContractDTO contractDTO = new ContractDTO();
//        contractDTO.setContractId("CT001");
//        contractDTO.setStartDate("2022-03");
//        contractDTO.setEndDate("2022-03-30");
//        contractDTO.setContractDate("2022-03-30");
//        contractDTO.setRentCost(10000.0);
//        contractDTO.setTotalCost(10000.0);
//        contractDTO.setContractContent("gggg");
//        contractDTO.setDeleteFlag(true);
//
//        contractDTO.setCustomer(customerDTO);
//
//        contractDTO.setEmployee(employeeDTO);
//
//        contractDTO.setGround(groundDTO);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/contract/edit")
//                        .content(this.objectMapper.writeValueAsString(contractDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void edit_contract_endDate_21() throws Exception {
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setEmployeeId("E001");
//        employeeDTO.setEmployeeName("Nguyễn Thái Học");
//        employeeDTO.setEmployeeBirthday("2000-05-06");
//        employeeDTO.setEmployeeGender(true);
//        employeeDTO.setEmployeeIdCard("236568986");
//        employeeDTO.setEmployeeGmail("nthaihoc@gmail.com");
//        employeeDTO.setEmployeeAddress("Quảng Nam");
//        employeeDTO.setEmployeePhone("0365635686");
//        employeeDTO.setEmployeeSalary(-78.0);
//        employeeDTO.setDeleteFlag(true);
//
//        GroundDTO groundDTO = new GroundDTO();
//        groundDTO.setGroundId("1");
//        groundDTO.setGroundType("Normal");
//        groundDTO.setArea(100.0);
//        groundDTO.setImage("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.agiusa.com%2Fhow-to-test-for-land-subsidence-before-breaking-ground&psig=AOvVaw1Y54PIx8yoUsaxPjao-7IG&ust=1647396516755000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKCUqbqEx_YCFQAAAAAdAAAAABAU");
//        groundDTO.setStatus("stutas");
//        groundDTO.setRentCost(1000.0);
//        groundDTO.setManageCost(1000.0);
//        groundDTO.setNote("note");
//        groundDTO.setVersion(1);
//        groundDTO.setDeleteFlag(true);
//
//        CustomerDTO customerDTO = new CustomerDTO();
//        customerDTO.setCustomerId("C002");
//        customerDTO.setCustomerName("Nguyễn Thái Học");
//        customerDTO.setCustomerBirthday("2000-05-06");
//        customerDTO.setCustomerIdCard("236568986");
//        customerDTO.setCustomerEmail("nthaihoc@gmail.com");
//        customerDTO.setCustomerAddress("Quảng Nam");
//        customerDTO.setCustomerPhone("0365635686");
//        customerDTO.setCustomerCompany("Codegym");
//        customerDTO.setStatus("Đang thuê");
//        customerDTO.setDeleteFlag(true);
//
//        ContractDTO contractDTO = new ContractDTO();
//        contractDTO.setContractId("CT001");
//        contractDTO.setStartDate("2022-03-30");
//        contractDTO.setEndDate("2022-03");
//        contractDTO.setContractDate("2022-03-30");
//        contractDTO.setRentCost(10000.0);
//        contractDTO.setTotalCost(10000.0);
//        contractDTO.setContractContent("gggg");
//        contractDTO.setDeleteFlag(true);
//
//        contractDTO.setCustomer(customerDTO);
//
//        contractDTO.setEmployee(employeeDTO);
//
//        contractDTO.setGround(groundDTO);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/contract/edit")
//                        .content(this.objectMapper.writeValueAsString(contractDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void edit_contract_contractDate_21() throws Exception {
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setEmployeeId("E001");
//        employeeDTO.setEmployeeName("Nguyễn Thái Học");
//        employeeDTO.setEmployeeBirthday("2000-05-06");
//        employeeDTO.setEmployeeGender(true);
//        employeeDTO.setEmployeeIdCard("236568986");
//        employeeDTO.setEmployeeGmail("nthaihoc@gmail.com");
//        employeeDTO.setEmployeeAddress("Quảng Nam");
//        employeeDTO.setEmployeePhone("0365635686");
//        employeeDTO.setEmployeeSalary(1500.0);
//        employeeDTO.setDeleteFlag(true);
//
//        GroundDTO groundDTO = new GroundDTO();
//        groundDTO.setGroundId("1");
//        groundDTO.setGroundType("Normal");
//        groundDTO.setArea(100.0);
//        groundDTO.setImage("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.agiusa.com%2Fhow-to-test-for-land-subsidence-before-breaking-ground&psig=AOvVaw1Y54PIx8yoUsaxPjao-7IG&ust=1647396516755000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKCUqbqEx_YCFQAAAAAdAAAAABAU");
//        groundDTO.setStatus("stutas");
//        groundDTO.setRentCost(1000.0);
//        groundDTO.setManageCost(1000.0);
//        groundDTO.setNote("note");
//        groundDTO.setVersion(1);
//        groundDTO.setDeleteFlag(true);
//
//        CustomerDTO customerDTO = new CustomerDTO();
//        customerDTO.setCustomerId("C002");
//        customerDTO.setCustomerName("Nguyễn Thái Học");
//        customerDTO.setCustomerBirthday("2000-05-06");
//        customerDTO.setCustomerIdCard("236568986");
//        customerDTO.setCustomerEmail("nthaihoc@gmail.com");
//        customerDTO.setCustomerAddress("Quảng Nam");
//        customerDTO.setCustomerPhone("0365635686");
//        customerDTO.setCustomerCompany("Codegym");
//        customerDTO.setStatus("Đang thuê");
//        customerDTO.setDeleteFlag(true);
//
//        ContractDTO contractDTO = new ContractDTO();
//        contractDTO.setContractId("CT001");
//        contractDTO.setStartDate("2022-03-30");
//        contractDTO.setEndDate("2022-03-30");
//        contractDTO.setContractDate("2022-03");
//        contractDTO.setRentCost(10000.0);
//        contractDTO.setTotalCost(10000.0);
//        contractDTO.setContractContent("gggg");
//        contractDTO.setDeleteFlag(true);
//
//        contractDTO.setCustomer(customerDTO);
//
//        contractDTO.setEmployee(employeeDTO);
//
//        contractDTO.setGround(groundDTO);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/contract/edit")
//                        .content(this.objectMapper.writeValueAsString(contractDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void edit_contract_rentCost_21() throws Exception {
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setEmployeeId("E001");
//        employeeDTO.setEmployeeName("Nguyễn Thái Học");
//        employeeDTO.setEmployeeBirthday("2000-05-06");
//        employeeDTO.setEmployeeGender(true);
//        employeeDTO.setEmployeeIdCard("236568986");
//        employeeDTO.setEmployeeGmail("nthaihoc@gmail.com");
//        employeeDTO.setEmployeeAddress("Quảng Nam");
//        employeeDTO.setEmployeePhone("0365635686");
//        employeeDTO.setEmployeeSalary(1500.0);
//        employeeDTO.setDeleteFlag(true);
//
//        GroundDTO groundDTO = new GroundDTO();
//        groundDTO.setGroundId("1");
//        groundDTO.setGroundType("Normal");
//        groundDTO.setArea(100.0);
//        groundDTO.setImage("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.agiusa.com%2Fhow-to-test-for-land-subsidence-before-breaking-ground&psig=AOvVaw1Y54PIx8yoUsaxPjao-7IG&ust=1647396516755000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKCUqbqEx_YCFQAAAAAdAAAAABAU");
//        groundDTO.setStatus("stutas");
//        groundDTO.setRentCost(1000.0);
//        groundDTO.setManageCost(1000.0);
//        groundDTO.setNote("note");
//        groundDTO.setVersion(1);
//        groundDTO.setDeleteFlag(true);
//
//        CustomerDTO customerDTO = new CustomerDTO();
//        customerDTO.setCustomerId("C002");
//        customerDTO.setCustomerName("Nguyễn Thái Học");
//        customerDTO.setCustomerBirthday("2000-05-06");
//        customerDTO.setCustomerIdCard("236568986");
//        customerDTO.setCustomerEmail("nthaihoc@gmail.com");
//        customerDTO.setCustomerAddress("Quảng Nam");
//        customerDTO.setCustomerPhone("0365635686");
//        customerDTO.setCustomerCompany("Codegym");
//        customerDTO.setStatus("Đang thuê");
//        customerDTO.setDeleteFlag(true);
//
//        ContractDTO contractDTO = new ContractDTO();
//        contractDTO.setContractId("CT001");
//        contractDTO.setStartDate("2022-04-08");
//        contractDTO.setEndDate("2022-03-30");
//        contractDTO.setContractDate("2022-03-30");
//        contractDTO.setRentCost(1.0);
//        contractDTO.setTotalCost(100000.0);
//        contractDTO.setContractContent("ccccccc");
//        contractDTO.setDeleteFlag(true);
//
//        contractDTO.setCustomer(customerDTO);
//
//        contractDTO.setEmployee(employeeDTO);
//
//        contractDTO.setGround(groundDTO);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/contract/edit")
//                        .content(this.objectMapper.writeValueAsString(contractDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void edit_contract_totalCost_21() throws Exception {
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setEmployeeId("E001");
//        employeeDTO.setEmployeeName("Nguyễn Thái Học");
//        employeeDTO.setEmployeeBirthday("2000-05-06");
//        employeeDTO.setEmployeeGender(true);
//        employeeDTO.setEmployeeIdCard("236568986");
//        employeeDTO.setEmployeeGmail("nthaihoc@gmail.com");
//        employeeDTO.setEmployeeAddress("Quảng Nam");
//        employeeDTO.setEmployeePhone("0365635686");
//        employeeDTO.setEmployeeSalary(1500.0);
//        employeeDTO.setDeleteFlag(true);
//
//        GroundDTO groundDTO = new GroundDTO();
//        groundDTO.setGroundId("1");
//        groundDTO.setGroundType("Normal");
//        groundDTO.setArea(100.0);
//        groundDTO.setImage("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.agiusa.com%2Fhow-to-test-for-land-subsidence-before-breaking-ground&psig=AOvVaw1Y54PIx8yoUsaxPjao-7IG&ust=1647396516755000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKCUqbqEx_YCFQAAAAAdAAAAABAU");
//        groundDTO.setStatus("stutas");
//        groundDTO.setRentCost(1000.0);
//        groundDTO.setManageCost(1000.0);
//        groundDTO.setNote("note");
//        groundDTO.setVersion(1);
//        groundDTO.setDeleteFlag(true);
//
//        CustomerDTO customerDTO = new CustomerDTO();
//        customerDTO.setCustomerId("C002");
//        customerDTO.setCustomerName("Nguyễn Thái Học");
//        customerDTO.setCustomerBirthday("2000-05-06");
//        customerDTO.setCustomerIdCard("236568986");
//        customerDTO.setCustomerEmail("nthaihoc@gmail.com");
//        customerDTO.setCustomerAddress("Quảng Nam");
//        customerDTO.setCustomerPhone("0365635686");
//        customerDTO.setCustomerCompany("Codegym");
//        customerDTO.setStatus("Đang thuê");
//        customerDTO.setDeleteFlag(true);
//
//        ContractDTO contractDTO = new ContractDTO();
//        contractDTO.setContractId("CT001");
//        contractDTO.setStartDate("2022-04-08");
//        contractDTO.setEndDate("2022-03-30");
//        contractDTO.setContractDate("2022-03-30");
//        contractDTO.setRentCost(100000.0);
//        contractDTO.setTotalCost(1.0);
//        contractDTO.setContractContent("ccccccc");
//        contractDTO.setDeleteFlag(true);
//
//        contractDTO.setCustomer(customerDTO);
//
//        contractDTO.setEmployee(employeeDTO);
//
//        contractDTO.setGround(groundDTO);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/contract/edit")
//                        .content(this.objectMapper.writeValueAsString(contractDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//    // test items không >= minlength - 22
//
//
//    @Test
//    public void edit_contract_contractContent_22() throws Exception {
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setEmployeeId("E001");
//        employeeDTO.setEmployeeName("Nguyễn Thái Học");
//        employeeDTO.setEmployeeBirthday("2000-05-06");
//        employeeDTO.setEmployeeGender(true);
//        employeeDTO.setEmployeeIdCard("236568986");
//        employeeDTO.setEmployeeGmail("nthaihoc@gmail.com");
//        employeeDTO.setEmployeeAddress("Quảng Nam");
//        employeeDTO.setEmployeePhone("0365635686");
//        employeeDTO.setEmployeeSalary(1500.0);
//        employeeDTO.setDeleteFlag(true);
//
//        GroundDTO groundDTO = new GroundDTO();
//        groundDTO.setGroundId("1");
//        groundDTO.setGroundType("Normal");
//        groundDTO.setArea(100.0);
//        groundDTO.setImage("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.agiusa.com%2Fhow-to-test-for-land-subsidence-before-breaking-ground&psig=AOvVaw1Y54PIx8yoUsaxPjao-7IG&ust=1647396516755000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKCUqbqEx_YCFQAAAAAdAAAAABAU");
//        groundDTO.setStatus("stutas");
//        groundDTO.setRentCost(1000.0);
//        groundDTO.setManageCost(1000.0);
//        groundDTO.setNote("note");
//        groundDTO.setVersion(1);
//        groundDTO.setDeleteFlag(true);
//
//        CustomerDTO customerDTO = new CustomerDTO();
//        customerDTO.setCustomerId("C002");
//        customerDTO.setCustomerName("Nguyễn Thái Học");
//        customerDTO.setCustomerBirthday("2000-05-06");
//        customerDTO.setCustomerIdCard("236568986");
//        customerDTO.setCustomerEmail("nthaihoc@gmail.com");
//        customerDTO.setCustomerAddress("Quảng Nam");
//        customerDTO.setCustomerPhone("0365635686");
//        customerDTO.setCustomerCompany("Codegym");
//        customerDTO.setStatus("Đang thuê");
//        customerDTO.setDeleteFlag(true);
//
//        ContractDTO contractDTO = new ContractDTO();
//        contractDTO.setContractId("CT001");
//        contractDTO.setStartDate("2022-04-08");
//        contractDTO.setEndDate("2022-03-30");
//        contractDTO.setContractDate("2022-03-30");
//        contractDTO.setRentCost(100000.0);
//        contractDTO.setTotalCost(1.0);
//        contractDTO.setContractContent("cc");
//        contractDTO.setDeleteFlag(true);
//
//        contractDTO.setCustomer(customerDTO);
//
//        contractDTO.setEmployee(employeeDTO);
//
//        contractDTO.setGround(groundDTO);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/contract/edit")
//                        .content(this.objectMapper.writeValueAsString(contractDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//    // test items không <= maxlength - 23
//
//
//    @Test
//    public void edit_contract_contractContent_23() throws Exception {
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setEmployeeId("E001");
//        employeeDTO.setEmployeeName("Nguyễn Thái Học");
//        employeeDTO.setEmployeeBirthday("2000-05-06");
//        employeeDTO.setEmployeeGender(true);
//        employeeDTO.setEmployeeIdCard("236568986");
//        employeeDTO.setEmployeeGmail("nthaihoc@gmail.com");
//        employeeDTO.setEmployeeAddress("Quảng Nam");
//        employeeDTO.setEmployeePhone("0365635686");
//        employeeDTO.setEmployeeSalary(1500.0);
//        employeeDTO.setDeleteFlag(true);
//
//        GroundDTO groundDTO = new GroundDTO();
//        groundDTO.setGroundId("1");
//        groundDTO.setGroundType("Normal");
//        groundDTO.setArea(100.0);
//        groundDTO.setImage("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.agiusa.com%2Fhow-to-test-for-land-subsidence-before-breaking-ground&psig=AOvVaw1Y54PIx8yoUsaxPjao-7IG&ust=1647396516755000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKCUqbqEx_YCFQAAAAAdAAAAABAU");
//        groundDTO.setStatus("stutas");
//        groundDTO.setRentCost(1000.0);
//        groundDTO.setManageCost(1000.0);
//        groundDTO.setNote("note");
//        groundDTO.setVersion(1);
//        groundDTO.setDeleteFlag(true);
//
//        CustomerDTO customerDTO = new CustomerDTO();
//        customerDTO.setCustomerId("C002");
//        customerDTO.setCustomerName("Nguyễn Thái Học");
//        customerDTO.setCustomerBirthday("2000-05-06");
//        customerDTO.setCustomerIdCard("236568986");
//        customerDTO.setCustomerEmail("nthaihoc@gmail.com");
//        customerDTO.setCustomerAddress("Quảng Nam");
//        customerDTO.setCustomerPhone("0365635686");
//        customerDTO.setCustomerCompany("Codegym");
//        customerDTO.setStatus("Đang thuê");
//        customerDTO.setDeleteFlag(true);
//
//        ContractDTO contractDTO = new ContractDTO();
//        contractDTO.setContractId("CT001");
//        contractDTO.setStartDate("2022-04-08");
//        contractDTO.setEndDate("2022-03-30");
//        contractDTO.setContractDate("2022-03-30");
//        contractDTO.setRentCost(100000.0);
//        contractDTO.setTotalCost(10000000.0);
//        contractDTO.setContractContent("ccccccccccccccccccccccccccccccccccccccccc");
//        contractDTO.setDeleteFlag(true);
//
//        contractDTO.setCustomer(customerDTO);
//
//        contractDTO.setEmployee(employeeDTO);
//
//        contractDTO.setGround(groundDTO);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/contract/edit")
//                        .content(this.objectMapper.writeValueAsString(contractDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//    //test all hợp lệ - 24
//
//
//    @Test
//    public void edit_contract_available_24() throws Exception {
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setEmployeeId("E001");
//        employeeDTO.setEmployeeName("Nguyễn Thái Học");
//        employeeDTO.setEmployeeBirthday("2000-05-06");
//        employeeDTO.setEmployeeGender(true);
//        employeeDTO.setEmployeeIdCard("236568986");
//        employeeDTO.setEmployeeGmail("nthaihoc@gmail.com");
//        employeeDTO.setEmployeeAddress("Quảng Nam");
//        employeeDTO.setEmployeePhone("0365635686");
//        employeeDTO.setEmployeeSalary(1500.0);
//        employeeDTO.setDeleteFlag(true);
//
//        GroundDTO groundDTO = new GroundDTO();
//        groundDTO.setGroundId("1");
//        groundDTO.setGroundType("Normal");
//        groundDTO.setArea(100.0);
//        groundDTO.setImage("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.agiusa.com%2Fhow-to-test-for-land-subsidence-before-breaking-ground&psig=AOvVaw1Y54PIx8yoUsaxPjao-7IG&ust=1647396516755000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKCUqbqEx_YCFQAAAAAdAAAAABAU");
//        groundDTO.setStatus("stutas");
//        groundDTO.setRentCost(1000.0);
//        groundDTO.setManageCost(1000.0);
//        groundDTO.setNote("note");
//        groundDTO.setVersion(1);
//        groundDTO.setDeleteFlag(true);
//
//        CustomerDTO customerDTO = new CustomerDTO();
//        customerDTO.setCustomerId("C002");
//        customerDTO.setCustomerName("Nguyễn Thái Học");
//        customerDTO.setCustomerBirthday("2000-05-06");
//        customerDTO.setCustomerIdCard("236568986");
//        customerDTO.setCustomerEmail("nthaihoc@gmail.com");
//        customerDTO.setCustomerAddress("Quảng Nam");
//        customerDTO.setCustomerPhone("0365635686");
//        customerDTO.setCustomerCompany("Codegym");
//        customerDTO.setStatus("Đang thuê");
//        customerDTO.setDeleteFlag(true);
//
//        ContractDTO contractDTO = new ContractDTO();
//        contractDTO.setContractId("CT001");
//        contractDTO.setStartDate("2022-04-08");
//        contractDTO.setEndDate("2022-04-30");
//        contractDTO.setContractDate("2022-03-30");
//        contractDTO.setRentCost(100000.0);
//        contractDTO.setTotalCost(10000.0);
//        contractDTO.setContractContent("ccccccccccc");
//        contractDTO.setDeleteFlag(true);
//
//        contractDTO.setCustomer(customerDTO);
//
//        contractDTO.setEmployee(employeeDTO);
//
//        contractDTO.setGround(groundDTO);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/contract/edit")
//                        .content(this.objectMapper.writeValueAsString(contractDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//}
