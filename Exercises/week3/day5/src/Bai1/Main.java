package Bai1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14);
        int[] arr = list.stream().mapToInt(i -> i).toArray();

        // Method 1
        System.out.println("Sum of even numbers: " +
                list.stream().filter(x -> x % 2 == 0).reduce(Integer::sum).orElse(0));
        System.out.println("Sum of odd numbers: " +
                list.stream().filter(x -> x % 2 != 0).reduce(Integer::sum).orElse(0));

        // Method 2
        System.out.println("Sum of even numbers: " +
                Arrays.stream(arr).filter(x -> x % 2 == 0).sum());
        System.out.println("Sum of odd numbers: " +
                Arrays.stream(arr).filter(x -> x % 2 != 0).sum());

        // Method 3
        System.out.println("Sum of even and odd numbers: " +
                list.stream().collect(Collectors.groupingBy(x -> x % 2 == 0, Collectors.summingInt(x -> x))).values());

        // Method 4
        System.out.println("Sum of even numbers: " +
                list.stream().filter(x -> x % 2 == 0).mapToInt(x -> x).sum());
        System.out.println("Sum of odd numbers: " +
                list.stream().filter(x -> x % 2 != 0).mapToInt(x -> x).sum());
    }
}
