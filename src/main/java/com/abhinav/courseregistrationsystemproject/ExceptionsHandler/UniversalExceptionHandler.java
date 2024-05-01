package com.abhinav.courseregistrationsystemproject.ExceptionsHandler;

import com.abhinav.courseregistrationsystemproject.DTOS.ExceptionsDTO;
import com.abhinav.courseregistrationsystemproject.Exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UniversalExceptionHandler {
    @ExceptionHandler(CourseAbsent.class)
    public ResponseEntity<ExceptionsDTO> handleCourseNotFoundException(CourseAbsent courseNotFoundExeption){
        ExceptionsDTO exceptionDto = new ExceptionsDTO();
        exceptionDto.setMessage("Course Id" + courseNotFoundExeption.getId()+"is Invalid");
        exceptionDto.setResolution("Provide valid Course id");
        ResponseEntity<ExceptionsDTO> responseEntity = new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
        return responseEntity;
    }
    @ExceptionHandler(DepartmentAbsent.class)
    public ResponseEntity<ExceptionsDTO> handleDepartmentAbsent(DepartmentAbsent departmentNotFoundException){
        ExceptionsDTO exceptionDto = new ExceptionsDTO();
        exceptionDto.setMessage("Department Id" + departmentNotFoundException.getId()+"is Invalid");
        exceptionDto.setResolution("Provide valid Course ic");
        ResponseEntity<ExceptionsDTO> responseEntity = new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
        return responseEntity;
    }
    @ExceptionHandler(StudentAbsent.class)
    public ResponseEntity<ExceptionsDTO> handleStudentNotFoundException(StudentAbsent studentNotFoundException){
        ExceptionsDTO exceptionDto = new ExceptionsDTO();
        exceptionDto.setMessage("Student Id" + studentNotFoundException.getId()+"is Invalid");
        exceptionDto.setResolution("Provide valid Course ic");
        ResponseEntity<ExceptionsDTO> responseEntity = new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
        return responseEntity;
    }
    @ExceptionHandler(AdminAbsent.class)
    public ResponseEntity<ExceptionsDTO> handleAdminNotFound(AdminAbsent AdminNotFound){
        ExceptionsDTO exceptionDto = new ExceptionsDTO();
        exceptionDto.setMessage("Admin username " + AdminNotFound.getId()+" or Password is Invalid");
        exceptionDto.setResolution("Provide valid admin username or Password");
        ResponseEntity<ExceptionsDTO> responseEntity = new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
        return responseEntity;
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionsDTO> handleGeneralException(){
        ExceptionsDTO exceptionDto = new ExceptionsDTO();
        exceptionDto.setMessage(" Exception is found");
        exceptionDto.setResolution("solve exception");
        ResponseEntity<ExceptionsDTO> response = new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
        return response;
    }
    @ExceptionHandler(InvalidRequest.class)
    public ResponseEntity<ExceptionsDTO> BadRequest(){
        ExceptionsDTO exceptionDto = new ExceptionsDTO();
        exceptionDto.setMessage(" Bad Request Exception");
        exceptionDto.setResolution("Send all the data properly.");
        ResponseEntity<ExceptionsDTO> response = new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
        return response;
    }
}