package com.udemy.springboot.LearnSpringBoot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {
    @RequestMapping("/courses")
    public List<Course> retriveAllCourse(){
        List<Course> courses = Arrays.asList(
                new Course(1, "Learn Spring", "sach"),
                new Course(2, "Learn Spring Boot", "sach"),
                new Course(3, "Learn Spring MVC", "sachin sharma")
        );
        return courses;
    }
}
