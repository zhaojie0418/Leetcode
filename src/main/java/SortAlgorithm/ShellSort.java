package SortAlgorithm;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {1, 5, 6, 1, 2, 3};
        Arrays.sort(arr);
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void shellSort(int[] arr) {
        int length = arr.length;
        int temp;
        for (int step = length / 2; step >= 1; step /= 2) {
            for (int i = step; i < length; i++) {
                int j = i - step;
                temp = arr[i];
                while (j >= 0 && arr[j] > temp) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = temp;
            }
        }
    }
}
