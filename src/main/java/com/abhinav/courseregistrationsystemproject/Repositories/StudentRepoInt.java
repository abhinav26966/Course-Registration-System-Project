package com.abhinav.courseregistrationsystemproject.Repositories;
import com.abhinav.courseregistrationsystemproject.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepoInt extends JpaRepository<Student, Long> {
    @Override
    Student save(Student student);

    @Override
    Optional<Student> findById(Long Id);

    @Override
    List<Student> findAll();

    @Override
    void delete(Student student);
}