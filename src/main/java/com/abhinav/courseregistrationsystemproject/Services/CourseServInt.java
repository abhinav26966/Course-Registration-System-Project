package com.abhinav.courseregistrationsystemproject.Services;

import com.abhinav.courseregistrationsystemproject.DTOS.CourseRequestDTO;
import com.abhinav.courseregistrationsystemproject.Models.Course;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CourseServInt {
    Course getCourseById(@PathVariable("id") Long id);
    List<Course> getAllCourses();
    List<Course> getCourseByDepartmentId(@PathVariable Long id);
    List<Course> getCourseByStudentId(@PathVariable Long id);
    Course addCourse(@RequestBody CourseRequestDTO requestDto);
    Course updateCourse(@RequestBody CourseRequestDTO requestDto);
    void deleteCourse(@PathVariable("id") Long id);
}