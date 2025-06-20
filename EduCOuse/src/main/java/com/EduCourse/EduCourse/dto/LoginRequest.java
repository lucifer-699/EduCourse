package com.EduCourse.EduCourse.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class LoginRequest {
    @NonNull
    String email;
    @NonNull
    String password;
}
