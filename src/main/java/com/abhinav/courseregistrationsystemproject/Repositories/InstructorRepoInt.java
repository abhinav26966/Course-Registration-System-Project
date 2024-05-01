package com.abhinav.courseregistrationsystemproject.Repositories;
import com.abhinav.courseregistrationsystemproject.Models.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstructorRepoInt extends JpaRepository<Instructor, Long> {
    @Override
    Instructor save(Instructor instructor);

    @Override
    Optional<Instructor> findById(Long Id);

    @Override
    List<Instructor> findAll();

    @Override
    void delete(Instructor instructor);
}