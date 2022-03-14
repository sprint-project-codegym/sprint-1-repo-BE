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


import java.util.List;

@RestController
public class FloorController {
    @Autowired
    FloorService floorService;
    @Autowired
    BuildingService buildingService;

    @ModelAttribute("buildings")
    public  Iterable<Building> buildings(Pageable pageable){
        return buildingService.findAllBuildingWithPagination(pageable);
    }


    @RequestMapping(value = "/floors/", method = RequestMethod.GET)
    public ResponseEntity<List<Floor>> listAllFloors(Pageable pageable) {
        Page<Floor> floors = floorService.findAllFloorWithPaginationn(pageable);
        if (floors.isEmpty()) {
            return new ResponseEntity<List<Floor>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Floor>>((List<Floor>) floors, HttpStatus.OK);
    }

    @PostMapping("/delete-floor")
    public String deleteFloor(@ModelAttribute("floor") Floor floor){
        floorService.deleteFloor(floor.getFloorId());
        return "redirect:floors";
    }
}
