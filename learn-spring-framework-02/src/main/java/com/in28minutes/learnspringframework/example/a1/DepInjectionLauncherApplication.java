package com.in28minutes.learnspringframework.example.a1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class BusinessClass{
    Dependency1 dependency1;
    Dependency2 dependency2;

    public BusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
        System.out.println("Autowiring using Constructor ");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

//    @Autowired
//    public void setDependency1(Dependency1 dependency1) {
//        this.dependency1 = dependency1;
//        System.out.println("Autowiring using setter : "+ this.dependency1);
//    }
//    @Autowired
//    public void setDependency2(Dependency2 dependency2) {
//        this.dependency2 = dependency2;
//        System.out.println("Autowiring using setter : "+ this.dependency2);
//    }
}
@Component
class Dependency1{

}

@Component
class Dependency2{

}
@Configuration
@ComponentScan
public class DepInjectionLauncherApplication {
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);
        }
    }
}

