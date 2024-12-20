package com.college.grading.dto;

import jakarta.persistence.Entity;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResultRequest {
    private int idStudent;
    private int idCourse;
    private String session;
    private long mark;
}
