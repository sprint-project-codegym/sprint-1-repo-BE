package com.example.sprint_1.repository.ground;

import com.example.sprint_1.dto.ground.FloorListDTO;
import com.example.sprint_1.entity.ground.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface FloorRepository extends JpaRepository<Floor, String> {
    @Query(value = "select floor.floor_id as floorId, floor.floor_name as floorName from floor", nativeQuery = true)
    List<FloorListDTO> findAllFloorDTO();
}
