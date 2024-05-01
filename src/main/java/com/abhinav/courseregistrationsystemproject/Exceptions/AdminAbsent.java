package com.abhinav.courseregistrationsystemproject.Exceptions;

import lombok.Getter;

@Getter
public class AdminAbsent extends RuntimeException {
    private final String id;
    public AdminAbsent(String id, String message) {
        super(message);
        this.id = id;
    }
}