package com.dailtcodebuffer.springboottutorialaziz.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
@Entity
public class Department {

    @NotBlank(message = "name cannot be blank")
    private String departmentName;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;
    private String departmentAddress;

    private String departmentCode;

    public Department(String departmentName, Long departmentId, String departmentAddress, String departmentCode) {
        this.departmentName = departmentName;
        this.departmentId = departmentId;
        this.departmentAddress = departmentAddress;
        this.departmentCode = departmentCode;
    }

    public Department() {
    }

    public Department(String departmentName, String departmentAddress, String departmentCode) {
        this.departmentName = departmentName;
        this.departmentAddress = departmentAddress;
        this.departmentCode = departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentAddress() {
        return departmentAddress;
    }

    public void setDepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }
}
