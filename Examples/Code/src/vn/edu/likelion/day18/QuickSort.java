package vn.edu.likelion.day18;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {19, 17, 15, 12, 16, 18, 4, 11, 13};

        // left và right là phạm vi duyệt từ trái qua phải
        int left = 0;
        int right = arr.length - 1;
        quickSort(arr, left, right);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);

            // Đệ quy
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        // Lấy phần tử cuối cùng làm chốt (pivot)
        int pivot = arr[right];
        int pv = left - 1; // Initialize pivot index

        for (int i = left; i < right; i++) {
            // Kiểm tra xem nếu phần tử thứ i < chốt
            if (arr[i] < pivot) {
                pv++; // Increment pivot index
                // Hoán vị arr[i] cho arr[pv]
                int temp = arr[pv];
                arr[pv] = arr[i];
                arr[i] = temp;
            }
        }
        // Hoán vị phần tử pivot với phần tử tiếp theo sau pv
        int temp = arr[pv + 1];
        arr[pv + 1] = arr[right];
        arr[right] = temp;

        return pv + 1; // Return the pivot index
    }
}