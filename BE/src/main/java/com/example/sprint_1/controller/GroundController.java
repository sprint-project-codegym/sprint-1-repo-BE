package com.example.sprint_1.controller;

import com.example.sprint_1.entity.ground.Ground;
import com.example.sprint_1.service.ground.GroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class GroundController {
    @Autowired
    GroundService groundService;

    @GetMapping(value = "/ground/detail")
    public ResponseEntity<List<Ground>> findAllGround() {
        List<Ground> groundList = groundService.getAllGround();
        return new ResponseEntity(groundList, HttpStatus.OK);
    }
}
