package Bai4;

import java.util.*;

public class Bai4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String word = input.nextLine();

        System.out.println(print1(word));
    }

    static String print1 (String word) {
        Set<Character> set = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (set.add(c)) {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}