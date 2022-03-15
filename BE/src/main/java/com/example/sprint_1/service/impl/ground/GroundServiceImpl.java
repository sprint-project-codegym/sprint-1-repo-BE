package com.example.sprint_1.service.impl.ground;

import com.example.sprint_1.dto.ground.GroundCreateDTO;
import com.example.sprint_1.repository.ground.GroundRepository;
import com.example.sprint_1.service.ground.GroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroundServiceImpl implements GroundService {
    @Autowired
    GroundRepository groundRepository;

    @Override
    public void createGround(GroundCreateDTO groundCreateDTO) {
        this.groundRepository.createGroundDTO(groundCreateDTO.getGroundId(), groundCreateDTO.getGroundType(), groundCreateDTO.getArea(),
                groundCreateDTO.getImage(), groundCreateDTO.getStatus(), groundCreateDTO.getRentCost(), groundCreateDTO.getManageCost(),
                groundCreateDTO.getNote(), groundCreateDTO.getVersion(), groundCreateDTO.getFloorId());
    }
}
