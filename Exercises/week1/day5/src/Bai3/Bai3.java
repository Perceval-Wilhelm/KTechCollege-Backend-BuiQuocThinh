package Bai3;

public class Bai3 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        count1(arr);
    }

    static void count1(int[] arr) {
        int count_even = 0;
        int count_odd = 0;
        for (int i : arr) {
            if (i % 2 == 0) {
                count_even++;
            } else {
                count_odd++;
            }
        }
        System.out.println("Number of even elements: " + count_even);
        System.out.println("Number of odd elements: " + count_odd);
    }
}