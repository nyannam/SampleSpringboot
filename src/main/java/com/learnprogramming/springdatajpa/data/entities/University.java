package com.learnprogramming.springdatajpa.data.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@Data
@NoArgsConstructor
public class University {

    @Id
    @SequenceGenerator(
            name = "university_sequence",
            sequenceName = "university_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "university_sequence")
    private Long id;
    private String name;
    private String location;
    private LocalDate established;
    private int noofstudents;
}
