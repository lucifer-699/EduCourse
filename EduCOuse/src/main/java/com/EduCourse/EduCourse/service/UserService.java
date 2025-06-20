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
        String roles = request.getRoles();

        try {
            UserEntity user = userRepository.user();
            if (user != null ){
                System.out.println("The user with email :" + user.getEmail() + " and role : " +user.getRole() +"has been created");
                return true;
        }else{
                return false;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public UserEntity userlogin(String email, String password){
        try {
            UserEntity user = userRepository.userlogin(email,password);
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
