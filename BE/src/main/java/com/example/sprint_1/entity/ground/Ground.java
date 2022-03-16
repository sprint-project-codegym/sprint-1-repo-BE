package com.example.sprint_1.entity.ground;

import com.example.sprint_1.entity.contract.Contract;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
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
    @JsonBackReference(value = "ground_contract")
    public List<Contract> contractList;
}
