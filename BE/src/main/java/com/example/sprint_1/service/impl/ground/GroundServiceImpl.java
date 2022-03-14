package com.example.sprint_1.service.impl.ground;

import com.example.sprint_1.repository.ground.GroundRepository;
import com.example.sprint_1.service.ground.GroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroundServiceImpl implements GroundService {
    @Autowired
    GroundRepository groundRepository;

    @Override
    public void createGround(String groundId, String groundType, Double area, String image, String status, Double rentCost, Double manageCost, String note, Integer version, String floorId) {
        this.groundRepository.createGroundDTO(groundId, groundType, area, image, status, rentCost, manageCost, note, version, floorId);
    }
}
