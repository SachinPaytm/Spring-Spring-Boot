package com.in28minutes.learnspringframework.example.h1;

import com.in28minutes.learnspringframework.game.GameRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class XMLConfigurationContextLauncherApplication {
    public static void main(String[] args) {
        try(var context = new ClassPathXmlApplicationContext("contextConfiguration.xml")){
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("game"));

            var gameRunner = context.getBean("gameRunner");
            System.out.println(gameRunner);
//            (GameRunner)gameRunner.run();
        }
    }
}

