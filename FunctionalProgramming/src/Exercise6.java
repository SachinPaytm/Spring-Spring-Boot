import java.util.List;

public class Exercise6 {
    public static void main(String[] args) {
        List<String> courses = List.of("Spring","Spring Boot","API","Microservices","AWS","PCF","Docker","Azure","Kubernetes");
        courses.stream()
                .map(word -> word.length())
                .forEach(System.out::println);
    }
}
