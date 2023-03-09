package com.in28minutes.learnspringframework.example.g1;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Named
class Business{
    private Dependency dependency;

//    @Autowired
    @Inject
    public void setDependency(Dependency dependency) {
        System.out.println("Setter Injection");
        this.dependency = dependency;
    }

    public Dependency getDependency() {
        return dependency;
    }
}

@Named
class Dependency{

}

@Configuration
@ComponentScan
public class CdiContextLauncherApplication {
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(CdiContextLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);
        }
    }
}

