package Bai2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Bai2 {
    public static void main(String[] args) {
        String[] arr = {"Red", "Green", "Orange", "White", "Black"};

        Bai2 b2 = new Bai2();
        b2.sort_1(arr);
        System.out.println();

        String[] arr_2 = b2.sort_2(arr);
        for (String s : arr_2) {
            System.out.println(s);
        }
    }

    // Method 1
    ArrayList<String> sort_1 (String[] arr) {
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(arr));
        Collections.sort(arrayList);
        for (String s : arrayList) {
            System.out.println(s);
        }
        return arrayList;
    }

    // Method 2
    String[] sort_2 (String[] arr) {
        for (int i=0; i<arr.length-1; i++) {
            boolean swapped = false;
            for (int j=0; j<arr.length-i-1; j++){
                if ((arr[j].compareTo(arr[j+1])>0)) {
                    String temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return arr;
    }
}