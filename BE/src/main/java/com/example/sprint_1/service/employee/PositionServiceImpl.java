package com.example.sprint_1.service.employee;

import com.example.sprint_1.entity.employee.Position;
import com.example.sprint_1.repository.employee.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionServiceImpl implements PositionService{
    @Autowired
    private PositionRepository positionRepository;
    @Override
    public List<Position> getAllPosition() {
        return positionRepository.getAllPosition();
    }
}
