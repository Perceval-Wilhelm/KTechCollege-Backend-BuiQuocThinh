package Bai2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input an integer: ");
        int n = sc.nextInt();

        System.out.println("Check whether every digit of the said integer is odd or not!");

        int countOdd = 0;
        int countNumber = 0;

        do {
            countNumber++;
            n = n / 10;
            int left = n % 10;

            if (left % 2 != 0) {
                countOdd++;
            }
        } while (n>0);

        if (countOdd == countNumber) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }
}
