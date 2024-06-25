package Bai5;

import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String strg1 = input.nextLine();

        Scanner input2 = new Scanner(System.in);
        String strg2 = input2.nextLine();

        strg1 = strg1.concat(strg2);
        strg2 = strg1.substring(0, strg1.length() - strg2.length());
        strg1 = strg1.substring(strg1.length() - strg2.length());

        System.out.println(strg1);
        System.out.println(strg2);
    }
}