package com.abhinav.courseregistrationsystemproject.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Admin {
    @Id
    private String admin_UserName;
    private String admin_Password;
    private String admin_Email;
    private String admin_FirstName;
    private String admin_LastName;
}