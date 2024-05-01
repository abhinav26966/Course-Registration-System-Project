package com.abhinav.courseregistrationsystemproject.DTOS;

import com.abhinav.courseregistrationsystemproject.Models.Course;
import com.abhinav.courseregistrationsystemproject.Models.Department;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class InstructorResponseDTO {
    private Long instructorId;
    private String name;
    private String title;
    private Department department;
    private List<Course> courses;
}