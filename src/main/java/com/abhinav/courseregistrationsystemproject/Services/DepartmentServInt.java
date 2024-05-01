package com.abhinav.courseregistrationsystemproject.Services;

import com.abhinav.courseregistrationsystemproject.DTOS.DepartmentRequestDTO;
import com.abhinav.courseregistrationsystemproject.Models.Department;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface DepartmentServInt {
    Department getDepartment(@PathVariable Long id);
    Department addDepartment(@RequestBody DepartmentRequestDTO requestDto);
    Department updateDepartment(@RequestBody DepartmentRequestDTO requestDto);
    String deleteDepartment(Long id);
}