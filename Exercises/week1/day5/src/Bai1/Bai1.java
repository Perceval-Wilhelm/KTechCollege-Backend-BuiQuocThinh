package Bai1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Bai1 {
    public static void main(String[] args) {
        int[] arr = {5, 1, 8, 4, 9, 1, 5};

        System.out.println(sum1(arr));
//        System.out.println(sum2(arr));
    }

    static int sum1 (int[] arr){
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        for (int i : set) {
            sum += i;
        }
        return sum;
    }

//    static int sum2 (int[] arr){
//        ArrayList<Integer> list = new ArrayList<>();
//        int sum = 0;
//        for (int i : arr) {
//            int count = 0;
//            for (int j : arr) {
//                if (i == j) {
//                    count++;
//                }
//            }
//            if (count == 1) {
//                list.add(i);
//                System.out.println(i);
//                sum+=i;
//            }
//        }
//        return sum;
//    }
}
