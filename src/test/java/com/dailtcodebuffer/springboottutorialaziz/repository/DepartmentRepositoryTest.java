package com.dailtcodebuffer.springboottutorialaziz.repository;

import com.dailtcodebuffer.springboottutorialaziz.entity.Department;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class DepartmentRepositoryTest {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department = new Department("IT","KfarYasif","1234");
        entityManager.persist(department);
    }

    @Test
    void findByDepartmentIdTestCase_DepartmentShouldBeFound() {
        assertEquals(departmentRepository.findByDepartmentId(1L).getDepartmentName(), "IT");
    }
}