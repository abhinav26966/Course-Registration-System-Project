package com.abhinav.courseregistrationsystemproject.Repositories;

import com.abhinav.courseregistrationsystemproject.Models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepoInt extends JpaRepository<Department, Long> {
    @Override
    Department save(Department department);

    @Override
    Optional<Department> findById(Long Id);

    @Override
    List<Department> findAll();

    @Override
    void delete(Department department);

}