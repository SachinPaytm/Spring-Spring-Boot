import java.util.List;

public class Exercise1 {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 6, 6, 7, 8);
        integers.stream()
                .filter(num -> num%2==1)
                .forEach(System.out::println);
    }
}
