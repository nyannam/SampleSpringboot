package com.learnprogramming.springdatajpa.service;

import com.learnprogramming.springdatajpa.data.entities.University;
import com.learnprogramming.springdatajpa.data.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class UniversityService {

    @Autowired
    UniversityRepository repository;

    public List<University> getAllUniversities() {
        return (List<University>) repository.findAll();
    }

    public void addUniversity(University university) {
        Optional<University> universityOptional = repository.findUniversityByName(university.getName());
        if(universityOptional.isPresent()) {
            throw new IllegalStateException("university already exist");
        }
         repository.save(university);
    }

    public void removeUniversity(Long universityId) {
        Boolean exists = repository.existsById(universityId);
        if(!exists) {
            throw new IllegalStateException("University with " + universityId + " does not exist");
        }
        repository.deleteById(universityId);
    }
    @Transactional
    public void updateUniversityData(Long universityId,
                                     String name, int noOfStudents) {
        University university = repository.findById(universityId)
                .orElseThrow(() -> new IllegalStateException("University with id " + universityId + " is not exist"));

        if(name !=null &&
                name.length()>0 &&
                !Objects.equals(university.getName(), name)) {
            university.setName(name);
        }
        if(noOfStudents>0) {
            if(!Objects.equals(university.getNoofstudents(),noOfStudents)){
                university.setNoofstudents(noOfStudents);
            }
        }

    }
}
