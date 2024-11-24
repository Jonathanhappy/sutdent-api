package com.college.grading.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Course {
    @Id
    @GeneratedValue
    private int idCourse;
    private String courseName;
    private int creditNumber;
}
