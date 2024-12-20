package com.college.grading.service;

import com.college.grading.model.Course;
import com.college.grading.model.Result;
import com.college.grading.repository.CourseRepository;
import com.college.grading.repository.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courserepository;
    private final ResultRepository resultrepository;

    public List<Course> getAllCourse() {
        return courserepository.findAll();
    }

    public Course createcourse(Course course) {
        return courserepository.save(course);
    }

    public Course getCourseById(int idCourse) {
        Optional<Course> optionalCourse = courserepository.findById(idCourse);
        if (optionalCourse.isEmpty()){
            throw new RuntimeException("Sorry Course don't exist");
        }
        return optionalCourse.get();
    }

    public String deleteCourseById(int idCourse) {
        Optional<Course> optionalCourse = courserepository.findById(idCourse);
        if (optionalCourse.isEmpty()){
            throw new RuntimeException("Can't Delete : Course don't exist");
        }

        Optional<Result> note = resultrepository.findByCourse(optionalCourse);
        note.ifPresent(resultrepository::delete);

        courserepository.delete(optionalCourse.get());
        return "Course Delete successfully";
    }

    public Course editCourseById(int idCourse, Course newcourse) {
        Optional<Course> optionalCourse = courserepository.findById(idCourse);
        if (optionalCourse.isEmpty()){
            throw new RuntimeException("Can't edit : Course don't exist");
        }
        Course editCourse = optionalCourse.get();
        editCourse.setCourseName(newcourse.getCourseName());
        editCourse.setCreditNumber(newcourse.getCreditNumber());

        return courserepository.save(editCourse);
    }
}
