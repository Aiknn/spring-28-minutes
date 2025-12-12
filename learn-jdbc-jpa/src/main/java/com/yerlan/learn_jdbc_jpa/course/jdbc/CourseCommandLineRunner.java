package com.yerlan.learn_jdbc_jpa.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.yerlan.learn_jdbc_jpa.course.Course;
import com.yerlan.learn_jdbc_jpa.course.springjpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{

    // @Autowired
    // private CourseJdbcRepository repository;

    // @Autowired
    // private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Learn AWS now", "in28minutes"));
        repository.save(new Course(2, "Learn Azure now", "in28minutes"));
        repository.save(new Course(3, "Learn Devops now", "in28minutes"));
        repository.deleteById(2l);
        System.out.println(repository.findById(3l));
        System.out.println(repository.findAll());
        System.out.println(repository.count());
        System.out.println(repository.findByAuthor("in28minutes"));
    }
    
}
