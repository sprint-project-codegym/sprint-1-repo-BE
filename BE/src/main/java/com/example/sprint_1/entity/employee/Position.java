package com.example.sprint_1.entity.employee;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "position")
public class Position {
    @Id
    private String positionId;
    private String positionName;

    @OneToMany(mappedBy = "position")
    @JsonBackReference
    public List<Employee> employeeList;
}
