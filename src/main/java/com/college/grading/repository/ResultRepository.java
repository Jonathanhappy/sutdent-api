package com.college.grading.repository;

import com.college.grading.model.Course;
import com.college.grading.model.Result;
import com.college.grading.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface ResultRepository extends JpaRepository<Result, Integer> {
    Optional<Result> findByStudent(Optional<Student> student);
    Optional<Result> findByCourse(Optional<Course> course);
}
