package Bai2;

import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        // Method 1
//        StringBuilder str = new StringBuilder(s);
//        String newStr = str.reverse().toString();
//        if(newStr.equals(s)) {
//            System.out.println(s + " is a palindrome? true");
//        }
//        else {
//            System.out.println(s + " is a palindrome? false");
//        }

        // Method 1.1
        Function<String, String> strAfter = newStr -> new StringBuilder(newStr).reverse().toString();
        Predicate<String> checkPalindrome = strCheck -> strAfter.apply(strCheck).equals(strCheck);
        System.out.println(s + " is a palindrome? " + checkPalindrome.test(s));

        // Method 1.2
        Function<String, String> strAfter2 = newStr2 -> String.valueOf(new StringBuilder(newStr2).reverse().toString().equals(newStr2));
        System.out.println(s + " is a palindrome? " + strAfter2.apply(s));

        // Method 1.3
        Predicate<String> checkPalindrome2 = strCheck2 -> new StringBuilder(strCheck2).reverse().toString().equals(strCheck2);
        System.out.println(s + " is a palindrome? " + checkPalindrome2.test(s));

        // Method 2
//        int left = 0, right = s.length() - 1;
//        while (left < right) {
//            if (s.charAt(left) != s.charAt(right)) {
//                System.out.println(s + " is a palindrome? false");
//                break;
//            }
//            left++;
//            right--;
//            if (left < right) {
//                System.out.println(s + " is a palindrome? true");
//                break;
//            }
//        }

        // Method 2.1
        Predicate<String> checkPalindrome3 = strCheck -> {
            int left = 0, right = strCheck.length() - 1;
            while (left < right) {
                if (strCheck.charAt(left) != strCheck.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        };

        System.out.println(s + " is a palindrome? " + checkPalindrome3.test(s));

        // Method 3

    }
}
