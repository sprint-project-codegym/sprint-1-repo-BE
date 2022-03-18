package com.example.sprint_1.controller;

import com.example.sprint_1.dto.ground.GroundDTO;
import com.example.sprint_1.entity.ground.Ground;
import com.example.sprint_1.repository.ground.GroundRepository;
import com.example.sprint_1.service.ground.GroundService;
import com.example.sprint_1.service.impl.ground.GroundServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.beans.Beans;
import java.util.List;
@RestController
public class GroundController {
    @Autowired
    GroundService groundService;

    @GetMapping("/api/ground/list")
    public ResponseEntity<List<Ground>> getListGround(){
        List<Ground> groundList = groundService.findAll();
        return  new ResponseEntity<>(groundList, HttpStatus.OK);
    }

    @PutMapping(value = "api/ground/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> editGround(@PathVariable("id") String id,@Validated @RequestBody GroundDTO groundDTO, BindingResult bindingResult) throws MethodArgumentNotValidException {
        if (bindingResult.hasErrors()) {
            throw new MethodArgumentNotValidException(null, bindingResult);
        }

        groundService.updateGround(id,groundDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    }

