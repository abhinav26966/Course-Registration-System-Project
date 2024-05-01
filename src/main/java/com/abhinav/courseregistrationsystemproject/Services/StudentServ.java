 package com.abhinav.courseregistrationsystemproject.Services;

import com.abhinav.courseregistrationsystemproject.DTOS.StudentRequestDTO;
import com.abhinav.courseregistrationsystemproject.DTOS.StudentResponseDTO;
import com.abhinav.courseregistrationsystemproject.Exceptions.StudentAbsent;
import com.abhinav.courseregistrationsystemproject.Models.Course;
import com.abhinav.courseregistrationsystemproject.Models.Student;
import com.abhinav.courseregistrationsystemproject.Repositories.CourseRepoInt;
import com.abhinav.courseregistrationsystemproject.Repositories.StudentRepoInt;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Getter
@Setter
@Service
public class StudentServ implements StudentServInt {
    private StudentRepoInt studentRepository;
    private CourseRepoInt courseRepository;
    public StudentServ(StudentRepoInt studentRepository, CourseRepoInt courseRepository){
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }
    @Override
    public StudentResponseDTO AddStudent(StudentRequestDTO studentRequestDto) {
        Student student = new Student();
        student.setName(studentRequestDto.getName());
        student.setEmail(studentRequestDto.getEmail());
        student.setStudentId(studentRequestDto.getStudentId());

        Student student1 = studentRepository.save(student);
        return new StudentResponseDTO(student1);
    }

    @Override
    public StudentResponseDTO GetStudentById(Long id) {
        Optional<Student> student1 = studentRepository.findById(id);
        if(student1.isEmpty()){
            throw new StudentAbsent(id,"Invalid student id");
        }

        return new StudentResponseDTO(student1.get());
    }

    @Override
    public List<StudentResponseDTO> getStudentsByCourseId(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        List<StudentResponseDTO> studentResponseDtoList = new ArrayList<>();
        if(course.isEmpty()){
            //throw exception
            throw new StudentAbsent(id,"Invalid Student id");

        }
        for(Student student : course.get().getStudents()){
            studentResponseDtoList.add(new StudentResponseDTO(student));
        }
        return studentResponseDtoList;
    }

    @Override
    public StudentResponseDTO UpdateStudent(StudentRequestDTO studentRequestDto) {
        Optional<Student> student = studentRepository.findById(studentRequestDto.getStudentId());
        if(student.isEmpty()){
            throw new StudentAbsent(studentRequestDto.getStudentId(),"Invalid Student id");
        }
        Student student1 = studentRepository.save(student.get());
        return new StudentResponseDTO(student1);
    }

    @Override
    public void DeleteStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isEmpty()){
            throw new StudentAbsent(id,"Invalid Student id");
        }
        studentRepository.delete(student.get());
    }
}