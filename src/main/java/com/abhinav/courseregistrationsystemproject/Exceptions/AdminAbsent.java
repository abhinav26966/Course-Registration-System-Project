package com.abhinav.courseregistrationsystemproject.Exceptions;

public class AdminAbsent extends RuntimeException {
    private Long id;
    public AdminAbsent(Long id, String message) {
        super(message);
        this.id = id;
    }
}