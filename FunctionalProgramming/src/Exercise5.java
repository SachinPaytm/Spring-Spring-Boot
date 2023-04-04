import java.util.List;

public class Exercise5 {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 6, 6, 7, 8);
        //cubes of odd
        integers.stream()
                .filter(num -> num%2==1)
                .map(num -> num*num*num)
                .forEach(System.out::println);
    }
}
