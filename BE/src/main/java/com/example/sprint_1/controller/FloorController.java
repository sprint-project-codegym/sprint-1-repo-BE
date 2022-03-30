package com.example.sprint_1.controller;

import com.example.sprint_1.entity.ground.Floor;
import com.example.sprint_1.service.ground.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/home/floor")
@CrossOrigin(origins = "*")
public class FloorController {
    // PhuocDD code chuc nang xoa tang

    @Autowired
    FloorService floorService;

    // PhuocDD hien thi danh sach tang
    @GetMapping("/list")
    public ResponseEntity<Page<Floor>> getAllFloor(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Floor> floors = floorService.findAllFloorWithPagination(pageable);
        if(floors.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(floors, HttpStatus.OK);
    }

    // PhuocDD xoa tang
    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteFloorById (@PathVariable("id") String id){
        Floor floor = floorService.findFloorByFloorId(id);
        if(floor == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            floorService.deleteFloor(id);
            return new ResponseEntity<>( HttpStatus.OK);
        }

    }
}
