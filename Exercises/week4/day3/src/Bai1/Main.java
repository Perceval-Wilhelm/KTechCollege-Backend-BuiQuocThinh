package Bai1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {6, 10, 3, 5, 9, 22, 30, 0, 1, 7, 8};
        int[] arr2 = Arrays.copyOf(arr, arr.length);

        System.out.println("Array before sorting: " + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("Bubble Sorted array: " + Arrays.toString(arr));

        quickSort(arr2, 0, arr.length-1);
        System.out.println("Quick Sorted array: " + Arrays.toString(arr2));
    }

    public static void bubbleSort(int[] arr) {
        for (int i=0; i<arr.length-1; i++) {
            boolean swapped = false;
            for (int j=0; j<arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex-1);
            quickSort(arr, pivotIndex+1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j=low; j<high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[high];
        arr[high] = arr[i+1];
        arr[i+1] = temp;
        return i+1;
    }
}