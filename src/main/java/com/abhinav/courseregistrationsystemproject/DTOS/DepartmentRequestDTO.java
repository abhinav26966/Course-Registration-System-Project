package com.abhinav.courseregistrationsystemproject.DTOS;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DepartmentRequestDTO {
    private Long departmentId;
    private String name;
    private String adminUsername;
    private String password;
}