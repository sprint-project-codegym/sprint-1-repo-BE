package com.example.sprint_1.controller;

import com.example.sprint_1.entity.ground.Ground;
import com.example.sprint_1.service.ground.GroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.sprint_1.dto.ground.GroundDTO;

import org.springframework.http.MediaType;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;

@RestController
@CrossOrigin("*")
public class GroundController {
    @Autowired
    GroundService groundService;

    @PutMapping(value = "api/ground/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> editGround(@PathVariable("id") String id, @Validated @RequestBody GroundDTO groundDTO, BindingResult bindingResult) throws MethodArgumentNotValidException {
        if (bindingResult.hasErrors()) {
            throw new MethodArgumentNotValidException(null, bindingResult);
        }

        groundService.updateGround(id, groundDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // HungLM get list and search ground
    @GetMapping("api/ground/list")
    public ResponseEntity<Page<Ground>> getGround(@RequestParam(value = "id", defaultValue = "") String id,
                                                  @RequestParam(value = "groundType", defaultValue = "") String groundType,
                                                  @RequestParam(value = "page", defaultValue = "0") Integer page,
                                                  @RequestParam(value = "size", defaultValue = "5") Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Ground> grounds = groundService.findByIdAndGroundType(pageable, id, groundType);
        if (grounds.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(grounds, HttpStatus.OK);
    }

    //HungLM delete ground
    @DeleteMapping("api/ground/delete/{id}")
    public ResponseEntity<String> deleteGround(@PathVariable("id") String id) {
        Ground ground = groundService.findById(id);
        if (ground == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        groundService.deleteGround(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
