package Bai1_1;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatedCharacter {
    public static void main(String[] args) {
        String str = "gibblegabbler";
        System.out.println("The given string is: " + str);
        char result = findFirstNonRepeatedCharacter(str);
        if (result != 0) {
            System.out.println("The first non-repeated character in String is: " + result);
        } else {
            System.out.println("There is no non-repeated character in the string.");
        }
    }

    public static char findFirstNonRepeatedCharacter(String str) {
        Map<Character, Integer> charCountMap = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (charCountMap.get(ch) == 1) {
                return ch;
            }
        }

        return 0;
    }
}