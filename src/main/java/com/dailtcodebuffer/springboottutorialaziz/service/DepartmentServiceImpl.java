package com.dailtcodebuffer.springboottutorialaziz.service;

import com.dailtcodebuffer.springboottutorialaziz.entity.Department;
import com.dailtcodebuffer.springboottutorialaziz.error.DepartmentNotFoundException;
import com.dailtcodebuffer.springboottutorialaziz.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department) ;
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if(!department.isPresent())
            throw new DepartmentNotFoundException("Department Not Found");

        return department.get();
    }

    @Override
    public void deleteDepartmentbyId(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department depDB = departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName()))
            depDB.setDepartmentName(department.getDepartmentName());

        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress()))
            depDB.setDepartmentAddress(department.getDepartmentAddress());

        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode()))
            depDB.setDepartmentCode(department.getDepartmentCode());


        departmentRepository.save(depDB);

        return depDB;


    }

    @Override
    public Department getDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }


}
