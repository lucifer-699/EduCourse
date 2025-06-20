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
@RequestMapping("/user")
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

   @PostMapping("/userlogin")
   public ResponseEntity<?> userlogin(@RequestBody LoginRequest loginRequest){
       String email = loginRequest.getEmail();
       String password = loginRequest.getPassword();
       String role = "user";
       try {
           UserEntity data = userService.login(email,password,role);
           if(data != null ){
               String token = JwtTokenUtil.generateToken(email);
               return ResponseEntity.ok(new LoginResponse(token));
           }
           return ResponseEntity.status(404).body("Error: User Doesn't Exists");
       } catch (Exception e) {
           return ResponseEntity.status(404).body("Error: Login failed due to Expection ");
       }
   }

    @PostMapping("/adminlogin")
    public ResponseEntity<?> adminlogin(@RequestBody LoginRequest loginRequest){
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        String role = "admin";
        try {
            UserEntity data = userService.login(email,password,role);
            if(data != null ){
                String token = JwtTokenUtil.generateToken(email);
                return ResponseEntity.ok(new LoginResponse(token));
            }
            return ResponseEntity.status(404).body("Error: User Doesn't Exists Or Invalid credentials for admin");
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Error: Login failed due to Expection ");
        }
    }
}
