package com.abhinav.courseregistrationsystemproject.DTOS;

import com.abhinav.courseregistrationsystemproject.Models.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class CourseResponseDTO{
    private Long courseId;
    private String name;
    private String description;
    private int credits;
    private String department;
    private List<String> students;
    private String instructor;

    public CourseResponseDTO(Course course){
        this.courseId = course.getCourseId();
        this.name = course.getName();
        this.credits = course.getCredits();
        this.description = course.getDescription();
        if(course.getDepartment() != null) {
            this.department = course.getDepartment().getName();
        }
        this.students = new ArrayList<>();
        if(course.getStudents() != null){
            for(Student student : course.getStudents()){
                this.students.add(student.getName());
            }
        }
        if(course.getInstructor() != null){
            this.instructor = course.getInstructor().getName();
        }else{
            this.instructor = "NO INSTRUCTOR";
        }
    }
}