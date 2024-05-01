package com.abhinav.courseregistrationsystemproject.Controllers;

import com.abhinav.courseregistrationsystemproject.DTOS.StudentRequestDTO;
import com.abhinav.courseregistrationsystemproject.DTOS.StudentResponseDTO;
import com.abhinav.courseregistrationsystemproject.Services.StudentServInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentCon {
    private final StudentServInt studentService;
    public StudentCon(StudentServInt studentService){
        this.studentService = studentService;
    }
    @PostMapping
    public StudentResponseDTO AddStudent(@RequestBody StudentRequestDTO student) {
        return studentService.AddStudent(student);
    }

    @GetMapping("/{id}")
    public StudentResponseDTO GetStudentById(@PathVariable Long id) {
        return studentService.GetStudentById(id);
    }

    @GetMapping("/course/{id}")
    public List<StudentResponseDTO> getStudentsByCourseId(@PathVariable("id") Long id) {
        return studentService.getStudentsByCourseId(id);
    }

    @PutMapping
    public StudentResponseDTO UpdateStudent(@RequestBody StudentRequestDTO student){
        return studentService.UpdateStudent(student);
    }

    @DeleteMapping("/{id}")
    public void DeleteStudent(@PathVariable Long id) {
        studentService.DeleteStudent(id);
    }

}