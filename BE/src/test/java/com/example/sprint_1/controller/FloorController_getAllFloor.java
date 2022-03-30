package com.example.sprint_1.controller;

import com.example.sprint_1.entity.ground.Floor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class FloorController_getAllFloor {

    @Autowired
    private FloorController floorController;

    /*
    PhuocDD test chuc nang danh sach tang co phan trang truong hop that bai
    Chu y: phai qua phuong thuc getAllFloor ben FloorController sua lai size page = 0 moi ra loi
     */
    @Test
    void getListFloor_5() {
        ResponseEntity<Page<Floor>> responseEntity
                = this.floorController.getAllFloor(0, 2);

        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    // PhuocDD test chuc nang danh sach tang co phan trang truong hop thanh cong
    @Test
    void getAllFloor_6() {
        ResponseEntity<Page<Floor>> responseEntity = this.floorController.getAllFloor(0,0);

        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(2, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(14, responseEntity.getBody().getTotalElements());
    }
}
