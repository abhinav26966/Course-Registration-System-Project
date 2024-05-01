package com.abhinav.courseregistrationsystemproject.DTOS;

import com.abhinav.courseregistrationsystemproject.Models.Course;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class StudentRequestDTO {
    private Long studentId;
    private String name;
    private String email;
    private Date dateOfEnrollment;
    private List<Course> courses;
    private String adminUsername;
    private String password;
}