package com.dailtcodebuffer.springboottutorialaziz.service;

import com.dailtcodebuffer.springboottutorialaziz.entity.Department;
import com.dailtcodebuffer.springboottutorialaziz.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> getDepartments();

    public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentbyId(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);

    public Department getDepartmentByName(String departmentName);



}
