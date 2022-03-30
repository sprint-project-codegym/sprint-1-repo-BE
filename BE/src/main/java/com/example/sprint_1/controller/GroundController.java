package com.example.sprint_1.controller;

import com.example.sprint_1.dto.ground.FloorListDTO;
import com.example.sprint_1.dto.ground.GroundCreateDTO;
import com.example.sprint_1.dto.ground.GroundViewDTO;
import com.example.sprint_1.entity.ground.Floor;
import com.example.sprint_1.entity.ground.Ground;
import com.example.sprint_1.service.ground.FloorService;
import com.example.sprint_1.service.ground.GroundService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/manager/ground")
public class GroundController {
    @Autowired
    private GroundService groundService;

    @Autowired
    private FloorService floorService;

    //LuanVT: add new ground
    @PostMapping("/create")
    @Transactional
    public ResponseEntity<List<FieldError>> createGround(@Validated @RequestBody GroundCreateDTO groundCreateDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.NOT_ACCEPTABLE);
        }
        if (this.groundService.findGroundById(groundCreateDTO.getGroundId()) != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Ground groundEntity = new Ground();
        BeanUtils.copyProperties(groundCreateDTO, groundEntity);
        Floor floorEntity = new Floor();
        floorEntity.setFloorId(groundCreateDTO.getFloorDTO().getFloorId());
        groundEntity.setFloor(floorEntity);
        groundEntity.setDeleteFlag(true);

        this.groundService.save(groundEntity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/listFloor")
    public ResponseEntity<List<FloorListDTO>> getAllFloor() {
        List<FloorListDTO> floorDTOList = this.floorService.getAllFloor();
        if (floorDTOList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(floorDTOList, HttpStatus.OK);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<GroundViewDTO> getGroundEntity(@PathVariable("id") String id) {
        GroundViewDTO ground = groundService.findGroundById(id);
        if (ground == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ground, HttpStatus.OK);
    }
}
