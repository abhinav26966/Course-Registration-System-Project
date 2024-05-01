package com.abhinav.courseregistrationsystemproject.DTOS;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CourseRequestDTO {
    private Long courseId;
    private String name;
    private String description;
    private int credits;
    private Long departmentId;
    private String adminUsername;
    private String password;
}