package com.example.sprint_1.entity.ground;

import com.example.sprint_1.entity.contract.Contract;
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
@Entity(name = "ground")
public class Ground {
    @Id
    private String groundId;
    private String groundType;
    private Double area;
    private String image;
    private String status;
    private Double rentCost;
    private Double manageCost;
    private String note;
    private Integer version;
    private Boolean deleteFlag;

    @ManyToOne(targetEntity = Floor.class)
    @JoinColumn(name = "floorId")
    private Floor floor;

    @OneToMany(mappedBy = "ground")
<<<<<<< HEAD
    @JsonBackReference
=======
    @JsonBackReference(value = "ground_contract")
>>>>>>> origin/contract
    public List<Contract> contractList;
}
