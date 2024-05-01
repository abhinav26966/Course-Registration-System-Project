package com.abhinav.courseregistrationsystemproject.Controllers;
import com.abhinav.courseregistrationsystemproject.DTOS.CourseRequestDTO;
import com.abhinav.courseregistrationsystemproject.DTOS.CourseResponseDTO;
import com.abhinav.courseregistrationsystemproject.Models.Course;
import com.abhinav.courseregistrationsystemproject.Services.CourseServInt;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/courses/")
public class CourseCon {

    private final  CourseServInt courseService;
    public CourseCon(CourseServInt courseService){
        this.courseService = courseService;
    }


    @GetMapping("/{id}")
    public CourseResponseDTO getCourseById(@PathVariable("id") Long id) {
        Course course = courseService.getCourseById(id);
        return new CourseResponseDTO(course);
    }

    @GetMapping
    public List<CourseResponseDTO> getAllCourses() {
        List<CourseResponseDTO> courseResponseDtos = new ArrayList<>();
        List<Course> courses = courseService.getAllCourses();
        for(Course course : courses){
            courseResponseDtos.add(new CourseResponseDTO(course));
        }
        return courseResponseDtos;
    }

    @GetMapping("/department/{id}")
    public List<CourseResponseDTO> getCourseByDepartmentId(@PathVariable Long id) {
        List<CourseResponseDTO> courseResponseDtos = new ArrayList<>();
        List<Course> courses = courseService.getCourseByDepartmentId(id);
        for(Course course : courses){
            courseResponseDtos.add(new CourseResponseDTO(course));
        }
        return courseResponseDtos;
    }

    @GetMapping("/student/{id}")
    public List<CourseResponseDTO> getCourseByStudentId(@PathVariable Long id) {
        List<CourseResponseDTO> courseResponseDtos = new ArrayList<>();
        List<Course> courses = courseService.getCourseByStudentId(id);
        for(Course course : courses){
            courseResponseDtos.add(new CourseResponseDTO(course));
        }
        return courseResponseDtos;
    }

    @PostMapping
    public CourseResponseDTO addCourse(@RequestBody CourseRequestDTO requestDto) {
        return new CourseResponseDTO(courseService.addCourse(requestDto));
    }

    @PutMapping
    public CourseResponseDTO updateCourse(@RequestBody CourseRequestDTO requestDto) {
        return new CourseResponseDTO(courseService.updateCourse(requestDto));
    }
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable("id") Long id) {
        courseService.deleteCourse(id);
    }
}