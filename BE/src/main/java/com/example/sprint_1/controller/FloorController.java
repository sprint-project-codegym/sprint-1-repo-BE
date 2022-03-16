package com.example.sprint_1.controller;

import com.example.sprint_1.entity.ground.Floor;
import com.example.sprint_1.service.ground.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/public/floor")
@CrossOrigin(origins = "*")
public class FloorController {
    // PhuocDD code chuc nang xoa tang

    @Autowired
    FloorService floorService;

    // PhuocDD hien thi danh sach tang
    @GetMapping("/list")
    public ResponseEntity<List<Floor>> getAllGround(@RequestParam("id") Optional<String> id) {
        List<Floor> floors = floorService.findAllFloor();
        if(floors.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(floors, HttpStatus.OK);
    }


    // PhuocDD xoa tang
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteCustomerById (@PathVariable("id") String id){
        Floor floor = floorService.findFloorByFloorId(id);
        if(floor == null) {
            return new ResponseEntity<>("Delete fail",HttpStatus.NOT_FOUND);
        }else {
            floorService.deleteFloor(id);
            return new ResponseEntity<>("Delete success", HttpStatus.OK);
        }

    }
}
