package com.abhinav.courseregistrationsystemproject.DTOS;

import com.abhinav.courseregistrationsystemproject.Models.Course;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class DepartmentResponseDTO{
    private Long departmentId;
    private String name;
    private List<Course> courses;
}