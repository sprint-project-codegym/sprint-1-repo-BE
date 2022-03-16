package com.example.sprint_1.repository.ground;

import com.example.sprint_1.entity.ground.Ground;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GroundRepository extends JpaRepository<Ground, String> {
    @Query(value = "SELECT * FROM `sprint-1`.ground where `ground`.`ground_id` = :groundId`", nativeQuery = true )
            Ground  findByGroundId(@Param("groundId") String groundId);
}
