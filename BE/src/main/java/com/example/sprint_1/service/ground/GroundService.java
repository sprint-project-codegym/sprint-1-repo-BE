package com.example.sprint_1.service.ground;

import com.example.sprint_1.dto.ground.GroundDTO;
import com.example.sprint_1.dto.ground.GroundViewDTO;
import com.example.sprint_1.entity.ground.Ground;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public interface GroundService {

    Page<Ground> findALl(Pageable pageable);

    void deleteGround(String id);

    GroundViewDTO findById(String id);

    Page<Ground> findByIdAndGroundType(Pageable pageable, String id, String groundType);

    void updateGround(String id, GroundDTO groundDTO);

}
