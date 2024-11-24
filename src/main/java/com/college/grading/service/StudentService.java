package com.college.grading.service;

import com.college.grading.model.Student;
import com.college.grading.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentrepository;

    public List<Student> getAllStudents() {
        return studentrepository.findAll();
    }

    public Student createStudent(Student student) {
        return studentrepository.save(student);
    }
}
