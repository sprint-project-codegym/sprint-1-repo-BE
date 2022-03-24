package com.example.sprint_1.repository.ground;

import com.example.sprint_1.entity.ground.Ground;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GroundRepository extends JpaRepository<Ground, String> {
    //Đông xin ké 1 method
    @Query(value = "SELECT * FROM sprint_1.ground", nativeQuery = true)
    List<Ground> getAllGround();
}
