package com.college.grading.controller;

import com.college.grading.dto.ResultRequest;
import com.college.grading.model.Result;
import com.college.grading.service.ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@RequestMapping("/api/v1/result")
public class ResultController {
    private final ResultService resultService;

    @GetMapping("/result_list")
    public List<Result> getAllResult(){
        return resultService.getAllResult();
    }

    @PostMapping("/result_add")
    public Result createResult(@RequestBody ResultRequest result){
        return resultService.createResult(result.getIdStudent(), result.getIdCourse(), result.getMark(),result.getSession());
    }

    @DeleteMapping("{idResult}")
    public String deleteResultById(@PathVariable int idResult){
        return resultService.deleteResultById(idResult);
    }

    @GetMapping("{idResult}")
    public Result getResultById(@PathVariable int idResult){
        return resultService.getResultById(idResult);
    }

    /*@GetMapping("{idResult}")
    public Course getResultById(@PathVariable int idResult){
        return resultService.getResultById(idResult);
    }

    @DeleteMapping("{idResult}")
    public String deleteResultById(@PathVariable int idResult){
        return resultService.deleteResultById(idResult);
    }

    @PutMapping("{idResult}")
    public Result editResultById(@PathVariable int idResult, @RequestBody Result newresult){
        return resultService.editResultById(idResult, newresult);
    }*/
}
