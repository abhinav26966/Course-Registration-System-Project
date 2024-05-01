package com.abhinav.courseregistrationsystemproject.Controllers;

import com.abhinav.courseregistrationsystemproject.Models.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class StudentCon {
    @PostMapping
    public Student AddStudent(@ModelAttribute("student") Student student) {
        System.out.println(student);
        return null;
    }

    @GetMapping("/{id}")
    public Student GetStudentById(@PathVariable Long id) {
        return null;
    }

    @GetMapping("/course/{id}")
    public List<Student> getStudentsByCourseId(@PathVariable("id") Long id) {
        return null;
    }

    @PutMapping
    public Student UpdateStudent(@RequestBody Student student){
        return null;
    }

    @DeleteMapping("/{id}")
    public void DeleteStudent(@PathVariable Long id) {
        return;
    }

}
