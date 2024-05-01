package com.abhinav.courseregistrationsystemproject.Exceptions;

public class InstructorAbsent extends RuntimeException {
    public InstructorAbsent(Long id, String message) {
        super(message);
    }
}