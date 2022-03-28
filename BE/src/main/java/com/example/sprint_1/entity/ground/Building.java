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

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

<<<<<<< HEAD
=======
@Data
>>>>>>> origin/contract
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
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
