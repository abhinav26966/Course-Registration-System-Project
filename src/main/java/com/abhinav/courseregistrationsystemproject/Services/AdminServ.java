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
        Optional<Admin> admin1 = adminRepository.findById(admin.getAdminId());
        if(admin1.isEmpty()){
            throw new AdminAbsent(admin.getAdminId(), "Admin not found");
        }
        Admin admin2 = admin1.get();
        admin2.setAdmin_Email(admin.getAdmin_Email());
        admin2.setAdmin_UserName(admin.getAdmin_UserName());
        admin2.setAdmin_FirstName(admin.getAdmin_FirstName());
        admin2.setAdmin_LastName(admin.getAdmin_LastName());
        return new AdminResponseDTO(admin2);
    }

    @Override
    public void deleteAdmin(AdminRequestDTO admin) {
        Optional<Admin> admin1 = adminRepository.findById(admin.getAdminId());
        if(admin1.isEmpty()){
            throw new AdminAbsent(admin.getAdminId(), "Admin not found");
        }
        Admin admin2 = admin1.get();
        if(admin2.getAdmin_UserName().equals(admin.getAdmin_UserName()) && admin2.getAdmin_Password().equals(admin.getAdmin_Password())){
            adminRepository.deleteById(admin.getAdminId());
        }else{
            throw new AdminAbsent(admin.getAdminId(), "Wrong Admin Username or Password");
        }
        adminRepository.deleteById(admin.getAdminId());
    }

    @Override
    public AdminResponseDTO getAdmin(Long id) {
        Optional<Admin> admin1 = adminRepository.findById(id);
        if(admin1.isEmpty()){
            throw new AdminAbsent(id, "Admin not found");
        }
        return new AdminResponseDTO(admin1.get());
    }
}