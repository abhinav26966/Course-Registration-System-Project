package com.abhinav.courseregistrationsystemproject.Exceptions;

import lombok.Getter;

@Getter
public class InstructorAbsent extends RuntimeException{
    private final Long id;
    public InstructorAbsent(Long id, String str){
        super(str);
        this.id = id;
    }
}