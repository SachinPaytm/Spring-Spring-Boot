package exercise.exercise1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Configuration
@ComponentScan
public class BusinessCalculationService {
    private DataService dataService;

    public BusinessCalculationService(DataService dataService) {
        this.dataService = dataService;
    }

    public int findMax(){
        return Arrays.stream(dataService.retriveData())
                .max().orElse(0);
    }

    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(BusinessCalculationService.class)){
            Arrays.stream(context.getBeanDefinitionNames())
                            .forEach(System.out::println);
            System.out.println(context.getBean(BusinessCalculationService.class).findMax());
        }
    }
}
