package Bai1;

import java.util.Arrays;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        double[] arr = {1, 3, 5, 7, 9};
        avg1(arr);
        avg2(arr);
        avg3(arr);
        avg4(arr);
        avg5(arr);
    }

    // Method 1
    public static void avg1(double[] arr) {
        System.out.println(Arrays.stream(arr).average().orElse(Double.NaN));
    }

    // Method 2
    public static void avg2(double[] arr) {
        Arrays.stream(arr).average().ifPresent(System.out::println);
    }

    // Method 3
    public static void avg3(double[] arr) {
        Function<double[], Double> cal = (arr1) -> Arrays.stream(arr1).sum() / arr1.length;
        System.out.println(cal.apply(arr));
    }

    // Method 4
    public static void avg4(double[] arr) {
        Function<double[], Double> cal = (arr1) -> Arrays.stream(arr1).reduce(0, Double::sum) / arr1.length;
        System.out.println(cal.apply(arr));
    }

    // Method 5
    public static void avg5(double[] arr) {
        Function<double[], Double> cal = (arr1) -> Arrays.stream(arr1).reduce(0, (a, b) -> a + b) / arr1.length;
        System.out.println(cal.apply(arr));
    }
}
