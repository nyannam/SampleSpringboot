package com.learnprogramming.springdatajpa.controllers;

import com.learnprogramming.springdatajpa.data.entities.University;
import com.learnprogramming.springdatajpa.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UniversityController {

    @Autowired
    UniversityService universityService;

    @GetMapping("/UniversitiesList")
    public List<University> getAllUniversities() {
        return universityService.getAllUniversities();
    }

    @PostMapping(value = "/university")
    public void addUniversity(@RequestBody University university) {
         universityService.addUniversity(university);
    }

    @DeleteMapping("{universityId}")
    public void removeUniversity(@PathVariable("univeristyId") Long universityId) {
        universityService.removeUniversity(universityId);
    }
    @PutMapping("{universityId}")
    public void updateUniversity(@PathVariable("universityId") Long universityId,
                                 @RequestParam(required = false) String name,
                                 @RequestParam(required = false) int noOfStudents) {
        universityService.updateUniversityData(universityId,name,noOfStudents);
    }



}
