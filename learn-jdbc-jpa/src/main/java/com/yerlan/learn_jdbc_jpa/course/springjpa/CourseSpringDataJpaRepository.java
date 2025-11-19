package com.yerlan.learn_jdbc_jpa.course.springjpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yerlan.learn_jdbc_jpa.course.Course;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {

    List<Course> findByAuthor(String author);
    
}
