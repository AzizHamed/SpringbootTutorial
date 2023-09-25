package com.dailtcodebuffer.springboottutorialaziz.controller;

import com.dailtcodebuffer.springboottutorialaziz.entity.Department;
import com.dailtcodebuffer.springboottutorialaziz.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
class DepartmentControllerTest {
    @MockBean
    private DepartmentService departmentService;
    @Autowired
    private MockMvc mockMvc;

    private Department department;
    @BeforeEach
    void setUp() {
        department = new Department("IT",1L,"KfarYasif","1234");
    }

    @Test
    void saveDepartmentTestCase_ShouldSuccess() throws Exception {
        Department input = new Department("IT","KfarYasif","1234");
        Mockito.when(departmentService.saveDepartment(input)).thenReturn(department);
        mockMvc.perform(MockMvcRequestBuilders.post("/departments").contentType(MediaType.APPLICATION_JSON).content("{\n" +
                "   \"departmentName\": \"It\",\n" +
                "    \"departmentAddress\": \"KfarYasif\",\n" +
                "    \"departmentCode\": \"1234\"\n" +
                "}")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @Disabled
    void getDepartmentById() throws Exception {
        Mockito.when(departmentService.getDepartmentById(1L)).thenReturn(department);
        mockMvc.perform(MockMvcRequestBuilders.get("/department").contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
    }
}