package com.example.sprint_1.service.ground;

public interface GroundService {
    void createGround(String groundId, String groundType, Double area, String image, String status,
                      Double rentCost, Double manageCost, String note, Integer version, String floorId);
}
