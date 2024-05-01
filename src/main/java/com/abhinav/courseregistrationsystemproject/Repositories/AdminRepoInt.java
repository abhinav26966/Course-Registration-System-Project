package com.abhinav.courseregistrationsystemproject.Repositories;

import com.abhinav.courseregistrationsystemproject.Models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdminRepoInt extends JpaRepository<Admin, String> {
    @Override
    Admin save(Admin admin);

    @Override
    Optional<Admin> findById(String Id);

    @Override
    List<Admin> findAll();

    @Override
    void delete(Admin admin);
}