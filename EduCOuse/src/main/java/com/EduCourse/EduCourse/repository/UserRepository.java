package com.EduCourse.EduCourse.repository;

import com.EduCourse.EduCourse.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,String> {

    @Query(value = "select userid,firstname,lastname ,email,password,role from users where email = :email and password = :password and role = :role ;",nativeQuery = true)
    public UserEntity login(@Param("email") String email,
                            @Param("password") String password,
                            @Param("role") String role);

    @Query (value = "select * from public.insert_user(:firstName, :lastName,:email,:password,:role);",nativeQuery = true)
    Boolean insertuser(@Param("firstName") String firstName,
                       @Param("lastName") String lastName,
                       @Param("email") String email,
                       @Param("password") String password,
                       @Param("role") String role);
}

