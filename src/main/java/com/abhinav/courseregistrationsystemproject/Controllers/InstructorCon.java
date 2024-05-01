package com.abhinav.courseregistrationsystemproject.Controllers;

import com.abhinav.courseregistrationsystemproject.DTOS.InstructorRequestDTO;
import com.abhinav.courseregistrationsystemproject.DTOS.InstructorResponseDTO;
import com.abhinav.courseregistrationsystemproject.Services.InstructorServInt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructor")
public class InstructorCon {
    private InstructorServInt instructorService;
    public InstructorCon(InstructorServInt instructorService){
        this.instructorService = instructorService;
    }
    @GetMapping("/{id}")
    public InstructorResponseDTO getInstructorById(@PathVariable Long id) {
        return instructorService.getInstructorById(id);
    }

    @GetMapping
    public List<InstructorResponseDTO> getAllInstructors() {
        return instructorService.getAllInstructors();
    }

    @GetMapping("/courses/{id}")
    public InstructorResponseDTO getInstructorByCourseId(@PathVariable Long id) {
        return instructorService.getInstructorByCourseId(id);
    }
    @GetMapping("/department/{id}")
    public List<InstructorResponseDTO> getInstructorByDepartmentId(@PathVariable Long id) {
        return instructorService.getInstructorByDepartmentId(id);
    }

    @PostMapping
    public InstructorResponseDTO createInstructor(@RequestBody InstructorRequestDTO instructor) {
        return instructorService.createInstructor(instructor);
    }

    @PutMapping
    public InstructorResponseDTO updateInstructor(@RequestBody InstructorRequestDTO instructor) {
        return instructorService.updateInstructor(instructor);
    }

    @DeleteMapping("")
    public void deleteInstructor(@RequestBody InstructorRequestDTO instructor) {
        return;
    }
}