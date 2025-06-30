package com.EduCourse.EduCourse.repository;

import com.EduCourse.EduCourse.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<UserEntity,String> {
}
