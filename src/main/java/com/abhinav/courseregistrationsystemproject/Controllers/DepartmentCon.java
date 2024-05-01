package com.abhinav.courseregistrationsystemproject.Controllers;

import com.abhinav.courseregistrationsystemproject.DTOS.DepartmentRequestDTO;
import com.abhinav.courseregistrationsystemproject.DTOS.DepartmentResponseDTO;
import com.abhinav.courseregistrationsystemproject.Models.Course;
import com.abhinav.courseregistrationsystemproject.Models.Department;
import com.abhinav.courseregistrationsystemproject.Services.DepartmentServ;
import com.abhinav.courseregistrationsystemproject.Services.DepartmentServInt;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentCon {
    private final DepartmentServInt departmentService;
    public DepartmentCon(DepartmentServInt departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}")
    public DepartmentResponseDTO getDepartment(@PathVariable Long id) {
        return null;
    }

    @PostMapping("/")
    public DepartmentResponseDTO addDepartment(@RequestBody DepartmentRequestDTO requestDto) {
        Department department = departmentService.addDepartment(requestDto);
        DepartmentResponseDTO departmentResponseDto = new DepartmentResponseDTO();
        departmentResponseDto.setDepartmentId(department.getDepartmentId());
        departmentResponseDto.setName(department.getName());
        departmentResponseDto.setCourses(new ArrayList<>());
        if(department.getCourses() != null){
            for(Course course : department.getCourses()){
                departmentResponseDto.getCourses().add(course);
            }
        }
        return departmentResponseDto;
    }

    @PutMapping("/")
    public DepartmentResponseDTO updateDepartment(@RequestBody DepartmentRequestDTO requestDto) {
        return null;
    }

    @DeleteMapping("/")
    public String deleteDepartment(@RequestBody Department department) {
        return null;
    }

}