package com.learnprogramming.springdatajpa.controllers;

import com.learnprogramming.springdatajpa.data.entities.University;
import com.learnprogramming.springdatajpa.service.UniversityService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@DataJpaTest
class UniversityControllerTest {

    @InjectMocks
    private final UniversityController universityController = new UniversityController();

    @Mock
    private UniversityService universityService;
    private List<University> universities;
    private University university;


    @Before
    public void setUp() throws Exception{
        when(universityService.getAllUniversities()).thenReturn(universities);
    }

    @Test
    void getAllUniversities() throws Exception {
        universityController.getAllUniversities();
        verify(universityService,times(1)).getAllUniversities();

    }

    @Test
    void addUniversity() {
        universityController.addUniversity(university);
        verify(universityService,times(1)).addUniversity(university);
    }

    @Test
    void removeUniversity() {
        universityController.removeUniversity(university.getId());
        verify(universityService,times(1)).removeUniversity(university.getId());
    }

    @Test
    void updateUniversity() {

    }
}