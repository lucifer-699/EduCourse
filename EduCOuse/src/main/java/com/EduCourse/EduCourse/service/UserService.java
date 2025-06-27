package com.EduCourse.EduCourse.service;


import com.EduCourse.EduCourse.Entity.UserEntity;
import com.EduCourse.EduCourse.dto.SignupRequest;
import com.EduCourse.EduCourse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean insertuser(SignupRequest request){
        String firstName = request.getFirstName();
        String lastName = request.getLastName();
        String email = request.getEmail();
        String password = request.getPassword();
        String role = request.getRole();
        try {
            Boolean user = userRepository.insertuser(firstName,lastName,email,password,role);
            System.out.println("response : " +user);
            if (user){
                System.out.println("The user with email :" + email + " and role : " + role +"has been created");
                return true;
        }else{
                return false;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public UserEntity login(String email, String password){
        try {
            UserEntity user = userRepository.login(email,password);
            if(user!= null){
                System.out.println("User with email : " +email +"has logged in ");
                return user;
            }else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
