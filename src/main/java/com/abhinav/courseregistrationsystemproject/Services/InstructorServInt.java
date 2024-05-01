package com.abhinav.courseregistrationsystemproject.Services;

import com.abhinav.courseregistrationsystemproject.DTOS.InstructorRequestDTO;
import com.abhinav.courseregistrationsystemproject.DTOS.InstructorResponseDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface InstructorServInt {
    public InstructorResponseDTO getInstructorById(@PathVariable Long id);

    public List<InstructorResponseDTO> getAllInstructors();

    public InstructorResponseDTO getInstructorByCourseId(@PathVariable Long id);

    public List<InstructorResponseDTO> getInstructorByDepartmentId(@PathVariable Long id);

    public InstructorResponseDTO createInstructor(@RequestBody InstructorRequestDTO instructor);

    public InstructorResponseDTO updateInstructor(@RequestBody InstructorRequestDTO instructor);

    public void deleteInstructor(@RequestBody InstructorRequestDTO instructor);
}