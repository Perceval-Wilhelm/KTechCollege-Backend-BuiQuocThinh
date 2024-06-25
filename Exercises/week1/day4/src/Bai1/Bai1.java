package Bai1;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String temp = input.nextLine();

        Bai1 b1 = new Bai1();
        char character = b1.firstNonRepeatedWord(temp);
        if (character == '0') {
            System.out.println("There is no non-repeated word.");
        } else {
            System.out.println("The first non repeated character in String is " + character);
        }
    }

    char firstNonRepeatedWord(String word) {
        char firstNonRepeatedWord = '0';
        for (int i=0; i<word.length(); i++){
            int count = 0;
            for (int j=0; j< word.length(); j++){
                if (word.charAt(i) == word.charAt(j)){
                    count++;
                }
            }
            if (count == 1) {
                firstNonRepeatedWord = word.charAt(i);
                break;
            }
        }
        return firstNonRepeatedWord;
    }
}