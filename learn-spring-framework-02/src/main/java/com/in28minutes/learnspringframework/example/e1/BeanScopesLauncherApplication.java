package com.in28minutes.learnspringframework.example.e1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class NormalClass{

}

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PrototypeClass{

}
@Configuration
@ComponentScan
public class BeanScopesLauncherApplication {
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(BeanScopesLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);
            for (int i = 0; i <5; i++) {
                System.out.println(context.getBean(NormalClass.class));
            }
            for (int i = 0; i <5; i++) {
                System.out.println(context.getBean(PrototypeClass.class));
            }
        }
    }
}

