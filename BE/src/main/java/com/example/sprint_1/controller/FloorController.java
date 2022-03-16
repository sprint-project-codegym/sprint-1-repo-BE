package com.example.sprint_1.controller;

import com.example.sprint_1.entity.ground.Building;
import com.example.sprint_1.entity.ground.Floor;
import com.example.sprint_1.service.ground.BuildingService;
import com.example.sprint_1.service.ground.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FloorController {
    // PhuocDD code chuc nang xoa tang

    @Autowired
    FloorService floorService;
    @Autowired
    BuildingService buildingService;

    @ModelAttribute("buildings")
    public  Iterable<Building> buildings(Pageable pageable){
        return buildingService.findAllBuildingWithPagination(pageable);
    }


    @RequestMapping(value = "/floors", method = RequestMethod.GET)
    public ResponseEntity<? extends Iterable<Floor>> listAllFloors(Pageable pageable) {
        Page<Floor> floors = floorService.findAllFloorWithPagination(pageable);
        if (floors.isEmpty()) {
            return new ResponseEntity<Page<Floor>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Page<Floor>>((Page<Floor>) floors, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete-floor/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteFloor(@PathVariable("id") String id) {
        floorService.deleteFloor(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
    @GetMapping("/delete-floor/{id}")
    public ResponseEntity<String> deleteFloorById ( @PathVariable("id") String id){
        floorService.deleteFloor(id);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}
