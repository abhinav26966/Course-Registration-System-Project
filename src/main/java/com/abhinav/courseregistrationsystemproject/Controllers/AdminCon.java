package com.abhinav.courseregistrationsystemproject.Controllers;
import com.abhinav.courseregistrationsystemproject.DTOS.AdminRequestDTO;
import com.abhinav.courseregistrationsystemproject.DTOS.AdminResponseDTO;
import com.abhinav.courseregistrationsystemproject.Services.AdminServ;
import com.abhinav.courseregistrationsystemproject.Services.AdminServInt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminCon {
    private final AdminServInt adminService;
    public AdminCon(AdminServ adminService) {
        this.adminService = adminService;
    }
    @PostMapping("/")
    public AdminResponseDTO createAdmin(@RequestBody AdminRequestDTO admin) {
        return adminService.createAdmin(admin);
    }

    @PatchMapping("/")
    public AdminResponseDTO updateAdmin(@RequestBody AdminRequestDTO admin) {
        return adminService.updateAdmin(admin);
    }

    @DeleteMapping("/")
    public void deleteAdmin(@RequestBody AdminRequestDTO admin) {
        adminService.deleteAdmin(admin);
    }

    @GetMapping("/{id}")
    public AdminResponseDTO getAdmin(@PathVariable String username) {
        return adminService.getAdmin(username);
    }
}