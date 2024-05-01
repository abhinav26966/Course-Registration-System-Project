package com.abhinav.courseregistrationsystemproject.Services;

import com.abhinav.courseregistrationsystemproject.DTOS.DepartmentRequestDTO;
import com.abhinav.courseregistrationsystemproject.Exceptions.AdminAbsent;
import com.abhinav.courseregistrationsystemproject.Exceptions.DepartmentAbsent;
import com.abhinav.courseregistrationsystemproject.Exceptions.InvalidRequest;
import com.abhinav.courseregistrationsystemproject.Models.Admin;
import com.abhinav.courseregistrationsystemproject.Models.Department;
import com.abhinav.courseregistrationsystemproject.Repositories.AdminRepoInt;
import com.abhinav.courseregistrationsystemproject.Repositories.DepartmentRepoInt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
@Service
public class DepartmentServ implements DepartmentServInt{
    private final AdminRepoInt adminRepository;
    private final DepartmentRepoInt departmentRepository;
    public DepartmentServ(DepartmentRepoInt departmentRepository,AdminRepoInt adminRepository){
        this.departmentRepository = departmentRepository;
        this.adminRepository = adminRepository;
    }

    public Department convertDto(DepartmentRequestDTO requestDto){
        if(!requestDto.check()){
            throw new InvalidRequest("Send All Department Details");
        }
        Department department = new Department();
        department.setName(department.getName());
        Optional<Department> department1 = departmentRepository.findById(requestDto.getDepartmentId());
        if(department1.isPresent()){
            department.setDepartmentId(department1.get().getDepartmentId());
            department.setCourses(department1.get().getCourses());
        }
        return department;
    }

    @Override
    public Department getDepartment(Long id) {
        Optional<Department> department = departmentRepository.findById(id);
        if(department.isEmpty()){
            //throw exception
            throw new DepartmentAbsent(id,"Invalid Department id");

        }
        return department.get();
    }

    public boolean AdminCheck(String UserName, String password){
        Optional<Admin> admin = adminRepository.findById(UserName);
        if(admin.isEmpty()){
            throw new AdminAbsent(admin.get().getAdmin_UserName(),"Invalid User Admin");
        }
        return !password.equals(admin.get().getAdmin_Password());
    }

    @Override
    public Department addDepartment(DepartmentRequestDTO requestDto) {
        if(!requestDto.check()){
            throw new InvalidRequest("Send All Department Details");
        }
        if(AdminCheck(requestDto.getAdminUsername(), requestDto.getPassword())){
            throw new AdminAbsent(requestDto.getAdminUsername(), "Invalid User Password");
        }
        Department department = new Department();
        department.setName(requestDto.getName());
        return departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(DepartmentRequestDTO requestDto) {
        if(!requestDto.check()){
            throw new InvalidRequest("Send All Department Details");
        }
        if(AdminCheck(requestDto.getAdminUsername(), requestDto.getPassword())){
            throw new AdminAbsent(requestDto.getAdminUsername(), "Invalid User Password");
        }
        Optional<Department> department1 = departmentRepository.findById(requestDto.getDepartmentId());
        if(department1.isEmpty()){
            //throw exception
            throw new DepartmentAbsent(requestDto.getDepartmentId(),"Invalid Department id");
        }
        department1.get().setName(requestDto.getName());
        return department1.get();
    }

    @Override
    public String deleteDepartment(Long id) {
        Optional<Department> department = departmentRepository.findById(id);
        if(department.isEmpty()){
            throw new DepartmentAbsent(id,"Department does not exist");
        }
        departmentRepository.delete(department.get());
        return "Deleted the department";
    }
}