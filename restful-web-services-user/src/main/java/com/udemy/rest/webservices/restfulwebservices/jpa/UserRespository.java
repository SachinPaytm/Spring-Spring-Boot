package com.udemy.rest.webservices.restfulwebservices.jpa;

import com.udemy.rest.webservices.restfulwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository extends JpaRepository<User,Integer> {

}
