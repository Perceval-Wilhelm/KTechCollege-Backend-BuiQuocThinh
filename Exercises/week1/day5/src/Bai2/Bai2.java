package Bai2;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String temp = input.nextLine();

        print1(temp);
    }

    static void print1 (String temp) {
        for (char c : temp.toCharArray()) {
            System.out.print(c);
            System.out.print(c);
        }
    }
}