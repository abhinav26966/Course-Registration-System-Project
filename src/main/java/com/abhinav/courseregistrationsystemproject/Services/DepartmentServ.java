package com.abhinav.courseregistrationsystemproject.Services;

import com.abhinav.courseregistrationsystemproject.DTOS.DepartmentRequestDTO;
import com.abhinav.courseregistrationsystemproject.Exceptions.DepartmentAbsent;
import com.abhinav.courseregistrationsystemproject.Models.Department;
import com.abhinav.courseregistrationsystemproject.Repositories.DepartmentRepoInt;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class DepartmentServ implements DepartmentServInt {
    private final DepartmentRepoInt departmentRepository;
    public DepartmentServ(DepartmentRepoInt departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    public Department convertDto(DepartmentRequestDTO requestDto){
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
            throw new DepartmentAbsent(id,"Invalid Department id");

        }
        return department.get();
    }


    @Override
    public Department addDepartment(DepartmentRequestDTO requestDto) {
        return departmentRepository.save(convertDto(requestDto));
    }

    @Override
    public Department updateDepartment(DepartmentRequestDTO requestDto) {
        Optional<Department> department1 = departmentRepository.findById(requestDto.getDepartmentId());
        if(department1.isEmpty()){
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