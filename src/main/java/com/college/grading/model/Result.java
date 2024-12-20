package com.college.grading.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "result")
public class Result {


    @Id
    @GeneratedValue
    private int idResult;

    @ManyToOne
    @JoinColumn(name = "idStudent")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "idCourse")
    private Course course;

    private String session;
    private long mark;
    
}
