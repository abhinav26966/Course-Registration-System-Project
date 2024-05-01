package com.abhinav.courseregistrationsystemproject.DTOS;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InstructorRequestDTO {
    private Long instructorId;
    private String name;
    private String title;
    private Long  departmentId;
    private String adminUsername;
    private String password;
}