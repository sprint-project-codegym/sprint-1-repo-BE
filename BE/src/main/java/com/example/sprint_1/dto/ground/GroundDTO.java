package com.example.sprint_1.dto.ground;

import lombok.Data;

import javax.persistence.Id;
@Data
public class GroundDTO {
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

    private FloorDTO floor;

    public String getGroundId() {
        return groundId;
    }

    public void setGroundId(String groundId) {
        this.groundId = groundId;
    }

    public String getGroundType() {
        return groundType;
    }

    public void setGroundType(String groundType) {
        this.groundType = groundType;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getRentCost() {
        return rentCost;
    }

    public void setRentCost(Double rentCost) {
        this.rentCost = rentCost;
    }

    public Double getManageCost() {
        return manageCost;
    }

    public void setManageCost(Double manageCost) {
        this.manageCost = manageCost;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public FloorDTO getFloor() {
        return floor;
    }

    public void setFloor(FloorDTO floor) {
        this.floor = floor;
    }
}
