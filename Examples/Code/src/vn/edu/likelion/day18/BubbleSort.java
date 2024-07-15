package vn.edu.likelion.day18;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {7, 2, 9, 6, 4};
        System.out.println("Original: " + Arrays.toString(arr));
        sapXep(arr);
        System.out.println("After sort: " + Arrays.toString(arr));
    }

    public static void sapXep(int[] arr) {
        // Duyệt toàn bộ phần tử trong mảng
        // Không cần duyệt phần tử cuối cùng nên i < arr.length - 1
        for (int i = 0; i < arr.length - 1; i++) {
            // Không cần duyệt phần tử đã được đưa về cuối mảng
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // Trường hợp phần tử phía trước lớn hơn phần tử liền kề
                // Hoán đổi vị trí
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
