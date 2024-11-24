package com.college.grading.controller;

import com.college.grading.model.Student;
import com.college.grading.service.StudentService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/students")
public class StudentController {
    private final StudentService studentservice;

    @GetMapping("/hello")
    public String sayHallo(){
        return "Hallo Student";
    }

    @GetMapping("/allStudent")
    public List<Student> getAllStudents(){
        return studentservice.getAllStudents();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentservice.createStudent(student);
    }

    @GetMapping("{idStudent}")
    public Student getStudentById(@PathVariable int idStudent){
        return studentservice.getStudentById(idStudent);
    }

    @DeleteMapping("{idStudent}")
    public String deleteStudentById(@PathVariable("idStudent") int id){
        return studentservice.deletetStudentById(id);
    }

    @PutMapping("{idStudent}")
    public Student editStudentById(@PathVariable int idStudent, @RequestBody Student newstudent){
        return studentservice.editStudentById(idStudent, newstudent);
    }


}
