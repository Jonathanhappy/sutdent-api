package com.college.grading.service;

import com.college.grading.model.Course;
import com.college.grading.model.Result;
import com.college.grading.model.Student;
import com.college.grading.repository.CourseRepository;
import com.college.grading.repository.ResultRepository;
import com.college.grading.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResultService {
    private final ResultRepository resultrepository;
    private final StudentRepository studentrepository;
    private final CourseRepository courserepository;

    public List<Result> getAllResult() {
        return resultrepository.findAll();
    }

    public Result createResult(int idStudent, int idCourse, Long mark, String session) {
        Student etudiant = studentrepository.findById(idStudent)
                .orElseThrow(() -> new RuntimeException("Étudiant introuvable"));

        Course course = courserepository.findById(idCourse)
                .orElseThrow(() -> new RuntimeException("Cours introuvable"));

        Result result1 = Result.builder()
                .student(etudiant)
                .course(course)
                .session(session)
                .mark(mark)
                .build();
        return resultrepository.save(result1);

    }


    public String deleteResultById(int idResult) {
        Optional<Result> optionalResult = resultrepository.findById(idResult);
        if (optionalResult.isEmpty()){
            throw new RuntimeException("Can't Delete : Result don't exist");
        }
        resultrepository.delete(optionalResult.get());
        return "Student Delete successfully";
    }

    public Result getResultById(int idResult) {
        Optional<Result> optionalResult = resultrepository.findById(idResult);
        if (optionalResult.isEmpty()){
            throw new RuntimeException("Sorry student don't exist");
        }
        return optionalResult.get();
    }
}
