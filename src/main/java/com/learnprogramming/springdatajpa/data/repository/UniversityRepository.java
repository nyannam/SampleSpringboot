package com.learnprogramming.springdatajpa.data.repository;

import com.learnprogramming.springdatajpa.data.entities.University;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UniversityRepository extends CrudRepository<University,Long> {

    @Query("SELECT u FROM University u WHERE u.name = ?1")
    Optional<University> findUniversityByName(String name);


}
