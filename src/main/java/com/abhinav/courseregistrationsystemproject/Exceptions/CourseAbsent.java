package com.abhinav.courseregistrationsystemproject.Exceptions;

import lombok.Getter;

@Getter

public class CourseAbsent extends RuntimeException {
    private final Long id;
    public CourseAbsent(Long id, String message){
        super(message);
        this.id = id;
    }
}