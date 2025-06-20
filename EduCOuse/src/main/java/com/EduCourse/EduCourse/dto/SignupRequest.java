package com.EduCourse.EduCourse.dto;

import lombok.Data;

@Data
public class SignupRequest {

    String firstName;
    String lastName;
    String email;
    String password;
    String role;
}
