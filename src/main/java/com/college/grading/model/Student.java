package com.college.grading.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

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
}
