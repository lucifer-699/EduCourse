package com.EduCourse.EduCourse.repository;

import com.EduCourse.EduCourse.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,String> {

    @Query(value = "select * from users where ",nativeQuery = true)
    public UserEntity userlogin(@Param("email") String email,
                                @Param("password") String password);
}
}
