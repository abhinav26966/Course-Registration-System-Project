package com.abhinav.courseregistrationsystemproject.Services;

import com.abhinav.courseregistrationsystemproject.DTOS.CourseRequestDTO;
import com.abhinav.courseregistrationsystemproject.Exceptions.*;
import com.abhinav.courseregistrationsystemproject.Models.Admin;
import com.abhinav.courseregistrationsystemproject.Models.Course;
import com.abhinav.courseregistrationsystemproject.Models.Department;
import com.abhinav.courseregistrationsystemproject.Models.Student;
import com.abhinav.courseregistrationsystemproject.Repositories.AdminRepoInt;
import com.abhinav.courseregistrationsystemproject.Repositories.CourseRepoInt;
import com.abhinav.courseregistrationsystemproject.Repositories.DepartmentRepoInt;
import com.abhinav.courseregistrationsystemproject.Repositories.StudentRepoInt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CourseServ implements CourseServInt{
    private final CourseRepoInt courseRepository;
    private final DepartmentRepoInt departmentRepository;
    private final StudentRepoInt studentRepository;
    private final AdminRepoInt adminRepository;
    public CourseServ(CourseRepoInt courseRepository, AdminRepoInt adminRepository,
                             DepartmentRepoInt departmentRepository ,StudentRepoInt studentRepository){
        this.courseRepository = courseRepository;
        this.departmentRepository = departmentRepository;
        this.studentRepository = studentRepository;
        this.adminRepository = adminRepository;
    }

    @Override
    public Course getCourseById(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        if(course.isEmpty()){

//            throw exception
            throw new CourseAbsent(id,"Invalid Course Id");
        }
        return course.get();
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public List<Course> getCourseByDepartmentId(Long id) {
        Optional<Department> department = departmentRepository.findById(id);
        if(department.isEmpty()){
            //throw exception
            throw new DepartmentAbsent(id,"Invalid Department id");
        }
        return department.get().getCourses();
    }

    @Override
    public List<Course> getCourseByStudentId(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isEmpty()){
            //throw exception
            throw new StudentAbsent(id,"Invalid Student id");

        }
        return student.get().getCourses();
    }

    public Course convertDto(CourseRequestDTO courseRequestDto){
        if (!courseRequestDto.check()){
            throw new InvalidRequest("Send all course details");
        }

        Course course = new Course();
        course.setName(courseRequestDto.getName());
        course.setCredits(courseRequestDto.getCredits());
        course.setDepartment(new Department());
        course.getDepartment().setDepartmentId(courseRequestDto.getDepartmentId());
        course.setDescription(courseRequestDto.getDescription());
        return course;
    }
    public boolean AdminCheck(String UserName, String password){
        Optional<Admin> admin = adminRepository.findById(UserName);
        if(admin.isEmpty()){
            throw new AdminAbsent(admin.get().getAdmin_UserName(),"Invalid User Admin");
        }
        return !password.equals(admin.get().getAdmin_Password());
    }
    @Override
    public Course addCourse(CourseRequestDTO requestDto) {
        if (!requestDto.check()){
            throw new InvalidRequest("Send all course details");
        }
        if(AdminCheck(requestDto.getAdminUsername(), requestDto.getPassword())){
            throw new AdminAbsent(requestDto.getAdminUsername(), "Invalid User Password");
        }
        return courseRepository.save(convertDto(requestDto));
    }

    @Override
    public Course updateCourse(CourseRequestDTO requestDto) {
        if (!requestDto.check()){
            throw new InvalidRequest("Send all course details");
        }
        Optional<Course> course1 = courseRepository.findById(requestDto.getCourseId());
        if (course1.isEmpty()){
            //throw exception
            throw new CourseAbsent(requestDto.getCourseId(),"Invalid Course Id");
        }
        if(AdminCheck(requestDto.getAdminUsername(), requestDto.getPassword())){
            throw new AdminAbsent(requestDto.getAdminUsername(), "Invalid User Password");
        }
        Course course2 = convertDto(requestDto);
        course2.setCourseId(requestDto.getCourseId());

        return courseRepository.save(course2);
    }

    @Override
    public void deleteCourse(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        if(course.isEmpty()){
            //throw exception
            throw new CourseAbsent(id,"Invalid Course Id");
        }
        courseRepository.delete(course.get());
    }
}