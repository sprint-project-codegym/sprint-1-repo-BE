package com.example.sprint_1.controller;

import com.example.sprint_1.dto.ground.GroundCreateDTO;
import com.example.sprint_1.service.ground.GroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroundController {
    @Autowired
    private GroundService groundService;

    //LuanVT: add new ground
    @PostMapping("/api/manager/ground/create")
    @Transactional
    public ResponseEntity<?> createGround(@RequestBody GroundCreateDTO groundCreateDTO) {
        groundService.createGround(groundCreateDTO.getGroundId(), groundCreateDTO.getGroundType(), groundCreateDTO.getArea(),
                groundCreateDTO.getImage(), groundCreateDTO.getStatus(), groundCreateDTO.getRentCost(), groundCreateDTO.getManageCost(),
                groundCreateDTO.getNote(), groundCreateDTO.getVersion(), groundCreateDTO.getFloorId());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
