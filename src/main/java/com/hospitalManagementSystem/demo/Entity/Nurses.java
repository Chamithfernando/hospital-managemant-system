package com.hospitalManagementSystem.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Nurses {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long nursesId;
    private String nurseName;
    private Long NurseRegNumber;
    private Long wardNumber;

    public Long getNursesId() {
        return nursesId;
    }

    public void setNursesId(Long nursesId) {
        this.nursesId = nursesId;
    }

    public String getNurseName() {
        return nurseName;
    }

    public void setNurseName(String nurseName) {
        this.nurseName = nurseName;
    }

    public Long getNurseRegNumber() {
        return NurseRegNumber;
    }

    public void setNurseRegNumber(Long nurseRegNumber) {
        NurseRegNumber = nurseRegNumber;
    }

    public Long getWardNumber() {
        return wardNumber;
    }

    public void setWardNumber(Long wardNumber) {
        this.wardNumber = wardNumber;
    }



    public Nurses() {
    }

    public Nurses(Long nursesId, String nurseName, Long nurseRegNumber, Long wardNumber) {
        this.nursesId = nursesId;
        this.nurseName = nurseName;
        NurseRegNumber = nurseRegNumber;
        this.wardNumber = wardNumber;
    }
}
