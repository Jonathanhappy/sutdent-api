package com.college.grading.controller;

import com.college.grading.model.Course;
import com.college.grading.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@RequestMapping("/api/v1/courses")
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/course_list")
    public List<Course> getAllCourse(){
        return courseService.getAllCourse();
    }

    @PostMapping("/course_add")
    public Course createCourse(@RequestBody Course course){
        return courseService.createcourse(course);
    }

    @GetMapping("{idCourse}")
    public Course getCourseById(@PathVariable int idCourse){
        return courseService.getCourseById(idCourse);
    }

    @DeleteMapping("{idCourse}")
    public String deleteCourseById(@PathVariable int idCourse){
        return courseService.deleteCourseById(idCourse);
    }

    @PutMapping("{idCourse}")
    public Course editCourseById(@PathVariable int idCourse, @RequestBody Course newcourse){
        return courseService.editCourseById(idCourse, newcourse);
    }
}
