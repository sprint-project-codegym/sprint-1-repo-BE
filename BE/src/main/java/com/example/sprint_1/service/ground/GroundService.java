package com.example.sprint_1.service.ground;

import com.example.sprint_1.entity.ground.Ground;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GroundService {

    List<Ground> findALl();

    void deleteGround(String id);

    Ground findById(String id);

    List<Ground> findByIdAndGroundType(String id, String groundType);

    List<Ground> findByIdContaining(String id);

    List<Ground> findByGroundType(String groundType);
}
