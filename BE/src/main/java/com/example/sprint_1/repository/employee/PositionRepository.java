package com.example.sprint_1.repository.employee;

import com.example.sprint_1.entity.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionRepository extends JpaRepository<Position, String> {
    List<Position> findAll();

    /*
    * Haulc
    * */
    @Query(value = "select position_id, position_name from position;", nativeQuery = true)
    List<Position> getAllPosition();
}
