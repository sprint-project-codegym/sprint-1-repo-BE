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

@RestController
@RequestMapping("api/public/ground")
public class GroundController {
    @Autowired
    GroundService groundService;
    // HungLM get list and search ground
    @GetMapping("/list")
    public ResponseEntity<Page<Ground>> getGround(@RequestParam(value = "id", defaultValue = "") String id,
                                                     @RequestParam(value = "groundType", defaultValue = "") String groundType,
                                                     @RequestParam(value = "page", defaultValue = "0") Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Ground> grounds = groundService.findByIdAndGroundType(pageable , id, groundType);
        if (grounds.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(grounds, HttpStatus.OK);
    }
    //HungLM delete ground
    @PatchMapping("/delete/{id}")
    public ResponseEntity<String> deleteGround(@PathVariable("id") String id) {
        Ground ground = groundService.findById(id);
        if (ground == null) {
            return new ResponseEntity<>("Không tìm thấy ground", HttpStatus.NOT_FOUND);
        }
        groundService.deleteGround(id);
        return new ResponseEntity<>("xóa thành công", HttpStatus.OK);
    }
}
