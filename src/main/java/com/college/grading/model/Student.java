package com.college.grading.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue
    private int idStudent;
    private String firstname;
    private String lastname;
    private String address;
    private String city;

   @OneToMany
   private Set<Result> resultList;
}
