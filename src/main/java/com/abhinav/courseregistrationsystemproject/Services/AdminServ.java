package com.abhinav.courseregistrationsystemproject.Services;

import com.abhinav.courseregistrationsystemproject.DTOS.AdminRequestDTO;
import com.abhinav.courseregistrationsystemproject.DTOS.AdminResponseDTO;
import com.abhinav.courseregistrationsystemproject.Exceptions.AdminAbsent;
import com.abhinav.courseregistrationsystemproject.Exceptions.InvalidRequest;
import com.abhinav.courseregistrationsystemproject.Models.Admin;
import com.abhinav.courseregistrationsystemproject.Repositories.AdminRepoInt;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AdminServ implements AdminServInt{
    private final AdminRepoInt adminRepository;
    public AdminServ(AdminRepoInt adminRepository) {
        this.adminRepository = adminRepository;
    }
    @Override
    public AdminResponseDTO createAdmin(AdminRequestDTO admin) {
        if(!admin.check()){
            throw new InvalidRequest("Send all the admin details");
        }

        Admin adminEntity = new Admin();
        adminEntity.setAdmin_Email(admin.getAdmin_Email());
        adminEntity.setAdmin_UserName(admin.getAdmin_UserName());
        adminEntity.setAdmin_Password(admin.getAdmin_Password());
        adminEntity.setAdmin_FirstName(admin.getAdmin_FirstName());
        adminEntity.setAdmin_LastName(admin.getAdmin_LastName());
        Admin admin1 = adminRepository.save(adminEntity);
        return new AdminResponseDTO(admin1);
    }

    @Override
    public AdminResponseDTO updateAdmin(AdminRequestDTO admin) {
        if(!admin.check()){
            throw new InvalidRequest("Send all the admin details");
        }
        Optional<Admin> admin1 = adminRepository.findById(admin.getAdmin_UserName());
        if(admin1.isEmpty()){
            throw new AdminAbsent(admin.getAdmin_UserName(), "Admin not found");
        }
        Admin admin2 = admin1.get();
        if(admin2.getAdmin_Password().equals(admin.getAdmin_Password())) {
            admin2.setAdmin_Email(admin.getAdmin_Email());
            admin2.setAdmin_UserName(admin.getAdmin_UserName());
            admin2.setAdmin_FirstName(admin.getAdmin_FirstName());
            admin2.setAdmin_LastName(admin.getAdmin_LastName());
            return new AdminResponseDTO(admin2);
        }else{
            throw new AdminAbsent(admin.getAdmin_UserName(), "Wrong Admin Password");
        }
    }

    @Override
    public void deleteAdmin(AdminRequestDTO admin) {
        Optional<Admin> admin1 = adminRepository.findById(admin.getAdmin_UserName());
        if(admin1.isEmpty()){
            throw new AdminAbsent(admin.getAdmin_UserName(), "Admin not found");
        }
        Admin admin2 = admin1.get();
        if(admin2.getAdmin_UserName().equals(admin.getAdmin_UserName()) && admin2.getAdmin_Password().equals(admin.getAdmin_Password())){
            adminRepository.deleteById(admin.getAdmin_UserName());
        }else{
            throw new AdminAbsent(admin.getAdmin_UserName(), "Wrong Admin Username or Password");
        }
        adminRepository.deleteById(admin.getAdmin_UserName());
    }

    @Override
    public AdminResponseDTO getAdmin(String username) {
        Optional<Admin> admin1 = adminRepository.findById(username);
        if(admin1.isEmpty()){
            throw new AdminAbsent(username, "Admin not found");
        }
        return new AdminResponseDTO(admin1.get());
    }
}