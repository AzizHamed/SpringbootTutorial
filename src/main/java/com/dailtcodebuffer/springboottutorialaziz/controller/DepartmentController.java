package com.dailtcodebuffer.springboottutorialaziz.controller;

import com.dailtcodebuffer.springboottutorialaziz.entity.Department;
import com.dailtcodebuffer.springboottutorialaziz.error.DepartmentNotFoundException;
import com.dailtcodebuffer.springboottutorialaziz.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class DepartmentController {

    //private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService; // Autowired : tells spring to give me the object from your container of this specific class

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){ // RequestBody convert json object to entity object (department in this case)
        //logger.info("Inside Post");
        return departmentService.saveDepartment(department);   }

    @GetMapping("/departments")
    public List<Department> getDepartments(){
       return departmentService.getDepartments();
    }
    @GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.getDepartmentById(departmentId);
    }
    @DeleteMapping("departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){

        departmentService.deleteDepartmentbyId(departmentId);
        return "Department deleted successfully";

    }

    @PutMapping("departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){

        return departmentService.updateDepartment(departmentId,department);

    }
    @GetMapping("departments/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName){

        return departmentService.getDepartmentByName(departmentName);
    }


}
