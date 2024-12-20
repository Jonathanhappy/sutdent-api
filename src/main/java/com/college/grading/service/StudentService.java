package com.college.grading.service;

import com.college.grading.model.Result;
import com.college.grading.model.Student;
import com.college.grading.repository.ResultRepository;
import com.college.grading.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentrepository;
    private final ResultRepository resultrepository;

    public Student getStudentById(int idStudent) {
        Optional<Student> optionalStudent = studentrepository.findById(idStudent);
        if (optionalStudent.isEmpty()){
            throw new RuntimeException("Sorry student don't exist");
        }
        return optionalStudent.get();
    }

    public String deletetStudentById(int id) {
        Optional<Student> optionalStudent = studentrepository.findById(id);
        if (optionalStudent.isEmpty()){
            throw new RuntimeException("Can't Delete : Student don't exist");
        }
        Optional<Result> note = resultrepository.findByStudent(optionalStudent);
        note.ifPresent(resultrepository::delete);

        studentrepository.delete(optionalStudent.get());
        return "Student Delete successfully";
    }

    public Student editStudentById(int idStudent, Student newstudent) {
        Optional<Student> optionalStudent = studentrepository.findById(idStudent);
        if (optionalStudent.isEmpty()){
            throw new RuntimeException("Can't edit : Student don't exist");
        }
        Student editStudent = optionalStudent.get();
        editStudent.setFirstname(newstudent.getFirstname());
        editStudent.setLastname(newstudent.getLastname());
        editStudent.setCity(newstudent.getCity());
        editStudent.setAddress(newstudent.getAddress());

        return studentrepository.save(editStudent);
    }

    public List<Student> getAllStudents() {
        return studentrepository.findAll();
    }

    public Student createStudent(Student student) {
        return studentrepository.save(student);
    }
}
