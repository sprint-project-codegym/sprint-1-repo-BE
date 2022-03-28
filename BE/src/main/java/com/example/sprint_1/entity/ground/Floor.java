package com.example.sprint_1.entity.ground;

import com.fasterxml.jackson.annotation.JsonBackReference;
<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
=======
import lombok.*;
>>>>>>> origin/contract

import javax.persistence.*;
import java.util.List;

<<<<<<< HEAD
=======
@Data
>>>>>>> origin/contract
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
