package com.in28minutes.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


record Person(String name,int age,Address address){};
record Address(String firstline,String city){};
@Configuration
public class HelloWorldConfiguration {
    @Bean(name = "name")
    public String name(){
        return "Sach";
    }
    @Bean
    public int age(){
        return 20;
    }
    @Bean
    @Primary
    public Person person(){
        return new Person("ravi",21, new Address("Dwarka Sector 16","Delhi"));
    }
    @Bean
    public Person person2MethodCall(){
        return new Person(name(),age(),address());
    }
    @Bean
    public Person person3Parameters(String name,int age,@Qualifier("address2") Address address2){
        return new Person(name,age,address2);
    }
    @Bean
    @Primary
    public Address address(){
        return new Address("Dwarka","Delhi");
    }
    @Bean
    @Qualifier("address2")
    public Address address2(){
        return  new Address("CP","Delhi");
    }
}
