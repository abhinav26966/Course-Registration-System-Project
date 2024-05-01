package com.abhinav.courseregistrationsystemproject.Services;

import com.abhinav.courseregistrationsystemproject.DTOS.StudentRequestDTO;
import com.abhinav.courseregistrationsystemproject.DTOS.StudentResponseDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface StudentServInt{
    StudentResponseDTO AddStudent(@RequestBody StudentRequestDTO studentRequestDto);
    StudentResponseDTO GetStudentById(@PathVariable Long id);
    List<StudentResponseDTO> getStudentsByCourseId(@PathVariable("id") Long id);
    StudentResponseDTO UpdateStudent(@RequestBody StudentRequestDTO studentRequestDto);
    void DeleteStudent(@PathVariable Long id);
}