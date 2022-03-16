package com.example.sprint_1.controller;

import com.example.sprint_1.dto.ground.GroundDTO;
import com.example.sprint_1.entity.ground.Ground;
import com.example.sprint_1.repository.ground.GroundRepository;
import com.example.sprint_1.service.ground.GroundService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class GroundController {
    @Autowired
    GroundService groundService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/api/ground/list")
    public ResponseEntity<List<Ground>> getListGround(){
        List<Ground> groundList = groundService.findAll();
        return  new ResponseEntity<>(groundList, HttpStatus.OK);
    }

    @PatchMapping(value = "api/ground/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GroundDTO> editGround(@PathVariable("id") String id, @RequestBody GroundDTO groundDTO){
        Ground groundRequest = modelMapper.map(groundDTO, Ground.class);
        Ground ground1 = groundService.updateGround(groundDTO.getGroundId(),groundRequest);
        GroundDTO groundRespone = modelMapper.map(ground1,GroundDTO.class);
        return ResponseEntity.ok().body(groundRespone);


    }

}
