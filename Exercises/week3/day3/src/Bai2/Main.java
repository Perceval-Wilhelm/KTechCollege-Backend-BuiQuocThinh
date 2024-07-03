package Bai2;

import java.util.Scanner;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number: ");
        int n = sc.nextInt();

        // Method 1
        Function<Integer, String> fun = number -> Integer.toBinaryString(n);
        System.out.println("Binary representation: " + fun.apply(n));

        // Method 2
        Function<Integer, String> number = Integer::toBinaryString;
        System.out.println("Binary representation: " + number.apply(n));

        // Method 3
        Function<Integer, String> fun2 = num -> {
            String str = "";
            int id=0;
            int[] binary = new int[35];

            while (num>0) {
                binary[id++] = num % 2;
                num = num / 2;
            }

            for (int i=binary.length-1; i>0; i--) {
                str = str + binary[i];
            }
            return str;
        };
        System.out.println("Binary representation: " + fun.apply(n));
    }
}
