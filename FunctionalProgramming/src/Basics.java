import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Basics {
    public static void main(String[] args) {
//        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 6, 6, 7, 8);
//        printall(integers);
//        printEven(integers);
//        printEvenSquares(integers);
        List<String> primitves = List.of("String","Integer","Double");
        Predicate<? super String> predicate = primitive -> primitive.startsWith("W");
        Optional<String> result = primitves.stream().filter(predicate).findFirst();
        System.out.println(result);
        System.out.println(result.isEmpty());
        System.out.println(result.isPresent());
        System.out.println(result.get());
    }

    private static void printEvenSquares(List<Integer> integers) {
        integers.stream()
                .filter(num -> num%2==0)
                .map(num -> num*num)
                .forEach(System.out::println);
    }

    private static void printEven(List<Integer> integers) {
        integers.stream()
//                .filter(Basics::isEven)
                .filter(num -> num%2==0)
                .forEach(System.out::println);
    }

    private static boolean isEven(Integer integer) {
        return integer%2==0;
    }

    private static void printall(List<Integer> integers) {
//        integers.stream()
//                .forEach(Basics::print);
        integers.stream()
                .forEach(System.out::println);
    }

    private static void print(Integer integer) {
        System.out.println(integer);
    }
}
