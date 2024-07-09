package Bai2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 23, 22, 23, 24, 24, 33, 15, 26, 15);

        System.out.println("After removing duplicates from the said list: " +
                list.stream().distinct().collect(Collectors.toList()));
    }
}
