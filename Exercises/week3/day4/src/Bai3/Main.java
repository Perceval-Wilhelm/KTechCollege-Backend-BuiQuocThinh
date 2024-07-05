package Bai3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 7, 18, 25, 77, 300, 101);

        // Method 1
        method1(list);

        // Method 2
        method2(list);
    }

    public static void method1(List<Integer> list) {
        int secondLargest = list.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(-1);
        int secondSmallest = list.stream().sorted().skip(1).findFirst().orElse(-1);
        System.out.println("Second largest element: " + secondLargest);
        System.out.println("Second smallest element: " + secondSmallest);
    }

    public static void method2(List<Integer> list) {
        Function<List<Integer>, String> method2 = (numbers) -> {
            List<Integer> sortedList = numbers.stream()
                    .distinct()
                    .sorted()
                    .collect(Collectors.toList());

            int secondSmallest = sortedList.get(1);

            List<Integer> reverseSortedList = numbers.stream()
                    .distinct()
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList());

            int secondLargest = reverseSortedList.get(1);

            return "Second largest element: " + secondLargest + ", Second smallest element: " + secondSmallest;
        };

        String result = method2.apply(list);
        System.out.println(result);
    }
}
