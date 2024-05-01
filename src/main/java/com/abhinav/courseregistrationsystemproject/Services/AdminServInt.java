package com.abhinav.courseregistrationsystemproject.Services;

import com.abhinav.courseregistrationsystemproject.DTOS.AdminRequestDTO;
import com.abhinav.courseregistrationsystemproject.DTOS.AdminResponseDTO;
import org.springframework.web.bind.annotation.*;

public interface AdminServInt {
    public AdminResponseDTO createAdmin(@RequestBody AdminRequestDTO admin);

    public AdminResponseDTO updateAdmin(@RequestBody AdminRequestDTO admin);

    public void deleteAdmin(@RequestBody AdminRequestDTO admin);

    public AdminResponseDTO getAdmin(@PathVariable Long id);
}