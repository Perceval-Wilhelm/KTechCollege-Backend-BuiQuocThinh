package Bai1;

import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number: ");
        int n = sc.nextInt();

//        int max = 0;
//        for (int i = 1; i <= n; i++) {
//            if (n % i == 0) {
//                if (primeNumber(i)) {
//                    max = i;
//                }
//            }
//        }

        Predicate<Integer> checkPrime = number -> {
            if (number==2 || number==3) return true;
            for (int i=4; i<number; i++)
                if (number % i == 0) return false;
            return true;
        };

        Function<Integer, Integer> factor = number -> {
            int max = 0;
            for (int i=1; i<=number; i++) {
                if (n % i == 0)
                    if(checkPrime.test(i)) max = i;
            }
            return max;
        };

        System.out.println("Largest prime number: " + factor.apply(n));
    }

//    public static boolean checkPrime(int number) {
//        if (number==2 || number==3) return true;
//        for (int i=2; i<number; i++)
//            if (number % i == 0) return false;
//        return true;
//    }
}
