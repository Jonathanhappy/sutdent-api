package com.college.grading.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue
    private int idCourse;
    private String courseName;
    private int creditNumber;

    @OneToMany
    private Set<Result> resultList;

}
