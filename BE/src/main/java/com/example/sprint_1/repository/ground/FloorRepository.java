package com.example.sprint_1.repository.ground;

import com.example.sprint_1.entity.ground.Floor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FloorRepository extends JpaRepository<Floor, String> {
    //PhuocDD da code chuc nang nay de lay danh sach tang
    @Query(value="select floor_id, area, capacity, delete_flag, floor_name, floor_type, status, building_id from floor", nativeQuery = true)
    Page<Floor> findAllFloorWithPaginationn(Pageable pageable);

    //PhuocDD da code chuc nang nay de xoa tang
    @Query(value = "delete from floor where floor.floor_id = :id",nativeQuery = true)
    void deleteFloor (@Param("id") String id);
}
