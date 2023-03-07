package com.in28minutes.learnspringframework.helloworld;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App02GamingBasicJava {
    public static void main(String[] args) {
        //context
        try(var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {

            //configure
            System.out.println(context.getBean("name"));

            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("person"));
            System.out.println(context.getBean("address"));

            System.out.println(context.getBean("person2MethodCall"));

            System.out.println(context.getBean("person3Parameters"));

            System.out.println(context.getBean(Address.class));
            System.out.println(context.getBean(Person.class));

            Arrays.stream(context.getBeanDefinitionNames())
                    .map(System.out::printf);

        }

    }
}
