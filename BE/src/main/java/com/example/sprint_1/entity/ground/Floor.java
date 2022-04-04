package com.example.sprint_1.entity.ground;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "floor")
public class Floor {
    @Id
    private String floorId;
    private String floorName;
    private Double area;
    private Integer capacity;
    private String status;
    private String floorType;
    private Boolean deleteFlag;

    @ManyToOne(targetEntity = Building.class)
    @JoinColumn(name = "buildingId")
    private Building building;

    @OneToMany(mappedBy = "floor")
    @JsonBackReference
    public List<Ground> groundList;
}
