package com.abhinav.courseregistrationsystemproject.Services;

import com.abhinav.courseregistrationsystemproject.DTOS.InstructorRequestDTO;
import com.abhinav.courseregistrationsystemproject.DTOS.InstructorResponseDTO;
import com.abhinav.courseregistrationsystemproject.Exceptions.*;
import com.abhinav.courseregistrationsystemproject.Models.Admin;
import com.abhinav.courseregistrationsystemproject.Models.Course;
import com.abhinav.courseregistrationsystemproject.Models.Department;
import com.abhinav.courseregistrationsystemproject.Models.Instructor;
import com.abhinav.courseregistrationsystemproject.Repositories.AdminRepoInt;
import com.abhinav.courseregistrationsystemproject.Repositories.CourseRepoInt;
import com.abhinav.courseregistrationsystemproject.Repositories.DepartmentRepoInt;
import com.abhinav.courseregistrationsystemproject.Repositories.InstructorRepoInt;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InstructorServ implements InstructorServInt{
    private final DepartmentRepoInt departmentRepository;
    private final InstructorRepoInt InstructorRepository;
    private final CourseRepoInt CourseRepository;
    private final AdminRepoInt AdminRepository;
    private DepartmentRepoInt DepartmentRepository;
    public InstructorServ(InstructorRepoInt InstructorRepository, CourseRepoInt CourseRepository, AdminRepoInt repo, DepartmentRepoInt departmentRepository){
        this.InstructorRepository = InstructorRepository;
        this.CourseRepository = CourseRepository;
        this.AdminRepository = repo;
        this.departmentRepository = departmentRepository;
    }
    @Override
    public InstructorResponseDTO getInstructorById(Long id) {
        Optional<Instructor> instr =  InstructorRepository.findById(id);
        if(instr.isEmpty()){
            throw new InstructorAbsent(id, "instructor not found");
        }
        return new InstructorResponseDTO(instr.get());
    }

    @Override
    public List<InstructorResponseDTO> getAllInstructors() {
        List<Instructor> instr =  InstructorRepository.findAll();
        List<InstructorResponseDTO> instructorResponseDtos = new ArrayList<>();
        for(Instructor i : instr){
            instructorResponseDtos.add(new InstructorResponseDTO(i));
        }
        return instructorResponseDtos;
    }

    @Override
    public InstructorResponseDTO getInstructorByCourseId(Long id) {
        Optional<Course> course = CourseRepository.findById(id);
        if(course.isEmpty()){
            throw new CourseAbsent(id, "Course Not found");
        }
        return new InstructorResponseDTO(course.get().getInstructor());
    }

    @Override
    public List<InstructorResponseDTO> getInstructorByDepartmentId(Long id) {
        Optional<Department> department = DepartmentRepository.findById(id);
        if(department.isEmpty()){
            throw new DepartmentAbsent(id, "Department Not found");
        }
        List<Course> course = department.get().getCourses();
        List<InstructorResponseDTO> list = new ArrayList<>();
        for(Course i : course){
            list.add(getInstructorByCourseId(i.getCourseId()));
        }
        return list;
    }

    @Override
    public InstructorResponseDTO createInstructor(InstructorRequestDTO instructor) {
        if(!instructor.check()){
            throw new InvalidRequest("Please Send all the details correctly");
        }
        Instructor inst = new Instructor();
        Optional<Department> dpr = departmentRepository.findById(instructor.getDepartmentId());
        if(dpr.isEmpty()){
            throw new DepartmentAbsent(instructor.getInstructorId(), " Department not found");
        }
        inst.setDepartment(dpr.get());
        inst.setName(instructor.getName());
        inst.setTitle(instructor.getTitle());
        InstructorRepository.save(inst);
        return new InstructorResponseDTO(inst);
    }

    @Override
    public InstructorResponseDTO updateInstructor(InstructorRequestDTO instructor) {
        if(!instructor.check()){
            throw new InvalidRequest("Please Send all the details correctly");
        }
        Optional<Admin> admin = AdminRepository.findById(instructor.getAdminUsername());
        if(admin.isEmpty()){
            throw new AdminAbsent(instructor.getAdminUsername(), "No admin with this username");
        }
        Admin admin2 = admin.get();
        if(admin2.getAdmin_Password()!=instructor.getPassword()){
            throw new AdminAbsent(instructor.getAdminUsername(), "Wrong password");
        }
        Optional<Instructor> instruct = InstructorRepository.findById(instructor.getInstructorId());
        if(instruct.isEmpty()){
            throw new InstructorAbsent(instructor.getInstructorId(), "wrong id");
        }
        Instructor inst = new Instructor();
        Optional<Department> dpr = departmentRepository.findById(instructor.getDepartmentId());
        if(dpr.isEmpty()){
            throw new DepartmentAbsent(instructor.getInstructorId(), " Department not found");
        }
        inst.setDepartment(dpr.get());
        inst.setName(instructor.getName());
        inst.setTitle(instructor.getTitle());
        return null;
    }

    @Override
    public void deleteInstructor(@RequestBody InstructorRequestDTO instructor) {
        Optional<Instructor> inst = InstructorRepository.findById(instructor.getInstructorId());
        if(inst.isEmpty()){
            throw new InstructorAbsent(instructor.getInstructorId(), "Instructor not found");
        }
        Optional<Admin> admin = AdminRepository.findById(instructor.getAdminUsername());
        if(admin.isEmpty()){
            throw new AdminAbsent(instructor.getAdminUsername(), "Admin not found");
        }
        if(admin.get().getAdmin_Password().equals(instructor.getPassword())){
            InstructorRepository.delete(inst.get());
        }else{
            throw new AdminAbsent(instructor.getAdminUsername(), "Wrong Password");
        }
    }
}