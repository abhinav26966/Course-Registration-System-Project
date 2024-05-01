package com.abhinav.courseregistrationsystemproject.Exceptions;

import lombok.Getter;

@Getter
public class StudentAbsent extends RuntimeException{
    private Long id;
    public StudentAbsent(Long id , String message){
        super(message);
        this.id = id;
    }
}