package com.example.sprint_1.repository.employee;

import com.example.sprint_1.entity.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, String> {
}
