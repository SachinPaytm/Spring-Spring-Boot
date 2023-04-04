import java.util.List;

public class Exercise3 {
    public static void main(String[] args) {
        List<String> courses = List.of("Spring","Spring Boot","API","Microservices","AWS","PCF","Docker","Azure","Kubernetes");
        courses.stream()
                .filter(word -> word.contains("Spring"))
                .forEach(System.out::println);
    }
}
