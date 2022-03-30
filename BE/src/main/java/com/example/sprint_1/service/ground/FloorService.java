package com.example.sprint_1.service.ground;

import com.example.sprint_1.entity.ground.Floor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface FloorService {
    //PhuocDD da code chuc nang nay de lay danh sach tang
    Page<Floor> findAllFloorWithPagination( Pageable pageable);

    //PhuocDD da code chuc nang nay de lay floor ID
    Floor findFloorByFloorId( String id);

    //PhuocDD da code chuc nang nay de xoa tang
    void deleteFloor (@Param("id") String id);
}
