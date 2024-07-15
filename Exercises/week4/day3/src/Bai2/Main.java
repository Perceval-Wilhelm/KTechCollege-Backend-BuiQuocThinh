package Bai2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {19, 17, 15, 12, 16, 18, 4, 11, 13};
        sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] sortArray(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return arr;
        }

        // Calculate the size of each cube
        int cubeSize = (int) Math.cbrt(n);

        // Sort each cube
        for (int i = 0; i < n; i += cubeSize) {
            int end = Math.min(i + cubeSize, n);
            Arrays.sort(arr, i, end);
        }

        // Merge cubes
        mergeCubes(arr, cubeSize);
        return arr;
    }

    private static void mergeCubes(int[] arr, int cubeSize) {
        int n = arr.length;
        if (cubeSize >= n) {
            return;
        }

        int[] temp = new int[n];
        int[] pointers = new int[(n + cubeSize - 1) / cubeSize];

        for (int i = 0; i < pointers.length; i++) {
            pointers[i] = i * cubeSize;
        }

        int index = 0;
        while (index < n) {
            int minIndex = -1;
            int minValue = Integer.MAX_VALUE;

            for (int i = 0; i < pointers.length; i++) {
                if (pointers[i] < Math.min((i + 1) * cubeSize, n) && arr[pointers[i]] < minValue) {
                    minValue = arr[pointers[i]];
                    minIndex = pointers[i];
                }
            }

            temp[index++] = minValue;
            pointers[minIndex / cubeSize]++;
        }

        // Copy sorted elements back to the original array
        System.arraycopy(temp, 0, arr, 0, n);
    }
}
