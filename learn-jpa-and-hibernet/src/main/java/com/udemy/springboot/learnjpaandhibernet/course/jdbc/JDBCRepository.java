package com.udemy.springboot.learnjpaandhibernet.course.jdbc;

import com.udemy.springboot.learnjpaandhibernet.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JDBCRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    final static String INSERT_QUERY =
            """
                    insert into course(id,name,author)
                    values(?,?,?);
                    """;
//            """
//            insert into course(id,name,author)
//            values (1,'learn spring','sach');
//            """;
private static String DELETE_QUERY =

        """
            delete from course
            where id = ?

        """;

    private static String SELECT_QUERY =

            """
                select * from course
                where id = ?
    
            """;
    public void insert(Course course){
        jdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }
    public void deleteById(long id) {
        jdbcTemplate.update(DELETE_QUERY,id);
    }

    public Course findById(long id) {
        return jdbcTemplate.queryForObject(SELECT_QUERY,
                new BeanPropertyRowMapper<>(Course.class), id);

    }

}
