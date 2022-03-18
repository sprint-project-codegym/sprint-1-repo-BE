package com.example.sprint_1.controller;

import com.example.sprint_1.dto.ground.GroundCreateDTO;
import com.example.sprint_1.entity.ground.Floor;
import com.example.sprint_1.entity.ground.Ground;
import com.example.sprint_1.service.ground.GroundService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
    public ResponseEntity<?> createGround(@Validated @RequestBody GroundCreateDTO groundCreateDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.NOT_ACCEPTABLE);
        }

        Ground groundEntity = new Ground();
        BeanUtils.copyProperties(groundCreateDTO, groundEntity);
        Floor floorEntity = new Floor();
        floorEntity.setFloorId(groundCreateDTO.getFloorDTO().getFloorId());
        groundEntity.setFloor(floorEntity);

        this.groundService.save(groundEntity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
