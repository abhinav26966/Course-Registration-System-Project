package com.abhinav.courseregistrationsystemproject.DTOS;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
public class StudentRequestDTO {
    private Long studentId;
    private String name;
    private String email;
    private String adminUsername;
    private String password;
}