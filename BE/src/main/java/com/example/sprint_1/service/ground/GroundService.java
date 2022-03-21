package com.example.sprint_1.service.ground;

import com.example.sprint_1.entity.ground.Ground;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GroundService {

    Page<Ground> findALl(Pageable pageable);

    void deleteGround(String id);

    Ground findById(String id);

    Page<Ground> findByIdAndGroundType(Pageable pageable, String id, String groundType);
}
