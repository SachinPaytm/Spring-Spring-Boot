package com.udemy.junit;

import org.junit.jupiter.api.*;

public class DifferentAnotation {
    @BeforeAll
    static  void beforeAll(){
        System.out.println("Before all");
    }
    @BeforeEach
    void beforeEach(){
        System.out.println("Before Each");
    }

    @Test
    void test1(){
        System.out.println("Test 1");
    }
    @Test
    void test2(){
        System.out.println("Test 2");
    }

    @AfterEach
    void afterEach(){
        System.out.println("After Each");
    }
    @AfterAll
    static  void afterAll(){
        System.out.println("After all");
    }
}
