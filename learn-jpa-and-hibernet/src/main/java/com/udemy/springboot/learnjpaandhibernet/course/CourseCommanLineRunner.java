package com.udemy.springboot.learnjpaandhibernet.course;

import com.udemy.springboot.learnjpaandhibernet.course.jpa.JPARepository;
import com.udemy.springboot.learnjpaandhibernet.course.springjpa.SpringJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommanLineRunner implements CommandLineRunner {
//    @Autowired
//    private JDBCRespository respository;

//    @Autowired
//    private JPARepository respository;
    @Autowired
    private SpringJPARepository repository;
    @Override
    public void run(String... args) throws Exception {

//        repository.insert(new Course(1,"learn springboot","sach"));
//        repository.insert(new Course(2,"learn hibernet","sach"));
//        repository.insert(new Course(3,"learn jdbc","sach"));
//
//        repository.deleteById(3);
//
//        System.out.println(repository.findById(1));
//        System.out.println(repository.findById(2));
        repository.save(new Course(1,"learn springboot","sach"));
        repository.save(new Course(2,"learn hibernet","sachin"));
        repository.save(new Course(3,"learn jdbc","sach"));

        repository.deleteById(3l);

        System.out.println(repository.findById(1l));
        System.out.println(repository.findById(2l));

        System.out.println(repository.findByName("learn springboot"));


        System.out.println(repository.findByName("learn springboot"));
        System.out.println(repository.findByName("learn hibernet"));
        System.out.println(repository.findByName("learn jdbc"));

        System.out.println(repository.findByAuthor("sach"));
        System.out.println(repository.findByAuthor("sachin"));

    }
}
