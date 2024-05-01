package com.abhinav.courseregistrationsystemproject.Controllers;

import com.abhinav.courseregistrationsystemproject.DTOS.DepartmentRequestDTO;
import com.abhinav.courseregistrationsystemproject.DTOS.DepartmentResponseDTO;
import com.abhinav.courseregistrationsystemproject.Models.Department;
import com.abhinav.courseregistrationsystemproject.Services.DepartmentServInt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentCon {
    private DepartmentServInt departmentService;
    public DepartmentCon(DepartmentServInt departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}")
    public DepartmentResponseDTO getDepartment(@PathVariable Long id) {
        return null;
    }

    @PostMapping("/")
    public DepartmentResponseDTO addDepartment(@RequestBody DepartmentRequestDTO requestDto) {
        return null;
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