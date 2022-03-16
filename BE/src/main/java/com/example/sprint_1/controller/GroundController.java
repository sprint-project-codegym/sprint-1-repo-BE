package com.example.sprint_1.controller;

import com.example.sprint_1.entity.ground.Ground;
import com.example.sprint_1.service.ground.GroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/public/ground")
public class GroundController {
    @Autowired
    GroundService groundService;

    @GetMapping("/list")
    public ResponseEntity<List<Ground>> getAllGround(@RequestParam("id") Optional<String> id, @RequestParam("groundType") Optional<String> groundType) {
        List<Ground> grounds = groundService.findALl();
        if(id.isPresent() && !groundType.isPresent()) {
            grounds = groundService.findByIdContaining(id.get());
        } else if(!id.isPresent() && groundType.isPresent()) {
            grounds = groundService.findByGroundType(groundType.get());
        } else if(id.isPresent()) {
            grounds = groundService.findByIdAndGroundType(id.get(),groundType.get());
        }
        if(grounds.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(grounds, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteGround(@PathVariable("id") String id) {
        Ground ground = groundService.findById(id);
        if(ground == null) {
            return new ResponseEntity<>("Không tìm thấy ground" ,HttpStatus.NOT_FOUND);
        }
        groundService.deleteGround(id);
        return new ResponseEntity<>("xóa thành công" , HttpStatus.OK);
    }
}
