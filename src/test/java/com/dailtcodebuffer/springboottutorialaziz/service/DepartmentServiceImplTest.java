package com.dailtcodebuffer.springboottutorialaziz.service;

import com.dailtcodebuffer.springboottutorialaziz.entity.Department;
import com.dailtcodebuffer.springboottutorialaziz.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentServiceImplTest {


    @Autowired
    private DepartmentService departmentService;
    @MockBean
    private DepartmentRepository departmentRepository;
    @BeforeEach
    void setUp() {
        Department dep = new Department("IT", 1L, "Nazareth", "1234");
        Mockito.when(departmentRepository.findByDepartmentName("IT")).thenReturn(dep);
    }

    @Test
    //@DisplayName("Aziz")
    void getDepartmentByNameTestCase_ShouldFound() {

        String depName  = "IT" ;
        Department dep = departmentService.getDepartmentByName(depName);
        assertEquals(depName,dep.getDepartmentName());


    }
}