package com.example.sprint_1.service.impl.ground;

import com.example.sprint_1.entity.ground.Floor;
import com.example.sprint_1.repository.ground.FloorRepository;
import com.example.sprint_1.service.ground.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
public class FloorServiceImpl implements FloorService {
    // PhuocDD code chuc nang xoa tang

    @Autowired
    FloorRepository floorRepository;

    @Override
    public Page<Floor> findAllFloor(Pageable pageable) {
        return floorRepository.findAllFloor(pageable);
    }

    @Override
    public Floor findFloorByFloorId(String id) {
        return floorRepository.findFloorByFloorId(id);
    }

    @Override
    public void deleteFloor(String id) {
        floorRepository.deleteFloor(id);
    }

}
