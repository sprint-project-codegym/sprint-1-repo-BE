package com.example.sprint_1.entity.ground;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity(name = "building")
public class Building {
    @Id
    private String buildingId;
    private String buildingName;
    private String taxCode;
    private String phoneNumber;
    private String fax;
    private String email;
    private String address;

    @OneToMany(mappedBy = "building")
    @JsonBackReference
    public List<Floor> floorList;
}
