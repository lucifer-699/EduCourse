package com.EduCourse.EduCourse.controller;

import com.EduCourse.EduCourse.dto.LoginRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

   @PostMapping("/userlogin")
   public void userlogin(@RequestBody LoginRequest loginRequest){
       String email = loginRequest.getEmail();
       if(email == null ){
           System.out.println("Error : Email is missing ");
       }
       String password = loginRequest.getPassword();
       if(password == null ){
           System.out.println("Error : Password is missing ");
       }



   }
}
