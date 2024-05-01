package com.abhinav.courseregistrationsystemproject.Exceptions;

import lombok.Getter;

@Getter
public class DepartmentAbsent extends RuntimeException{
    public Long id;
    public DepartmentAbsent(Long id,String message){
        super(message);
        this.id= id;
    }
}