package com.udemy.springboot.learnjpaandhibernet.course.springjpa;

import com.udemy.springboot.learnjpaandhibernet.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpringJPARepository extends JpaRepository<Course,Long> {
    List<Course> findByName(String name);
    List<Course> findByAuthor(String author);
}
