package com.example.sprint_1.repository.ground;

import com.example.sprint_1.entity.ground.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository extends JpaRepository<Building, String> {
}
