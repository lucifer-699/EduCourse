package com.EduCourse.EduCourse.controller;

import com.EduCourse.EduCourse.Entity.UserEntity;
import com.EduCourse.EduCourse.dto.LoginRequest;
import com.EduCourse.EduCourse.dto.LoginResponse;
import com.EduCourse.EduCourse.dto.SignupRequest;
import com.EduCourse.EduCourse.service.UserService;
import com.EduCourse.EduCourse.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;



    @PostMapping("/insertuser")
    public boolean insertuser(@RequestBody SignupRequest signupRequest) {
        boolean response = userService.insertuser(signupRequest);
        if (response) {
            System.out.println("The user with email : " + signupRequest.getEmail() + "has been created ");
        } else {
            System.out.println("Error creating user with email : " + signupRequest.getEmail());
        }
        return response;
    }


    @PostMapping("/login")
   public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
       String email = loginRequest.getEmail();
       String password = loginRequest.getPassword();
       System.out.println("Login Request from "+ email +"and pass :" +password);

       try {
           UserEntity data = userService.login(email,password);
           System.out.println(data);

           if(data != null){
               String role = data.getRole();
               String token = JwtTokenUtil.generateToken(email);
               System.out.println("Login Sucessfull with token :" + token);
               return ResponseEntity.ok(new LoginResponse(token,role));
           }else {
               System.out.println("User Doesnt Exists");
               return ResponseEntity.status(401).body("Failed");
           }
       } catch (Exception e) {
           System.out.println("Error occur !!");
           return ResponseEntity.status(404).body("Error");
       }
   }

}
