package com.EduCourse.EduCourse.service;


import com.EduCourse.EduCourse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void userlogin(String email, String password){

    }


}
