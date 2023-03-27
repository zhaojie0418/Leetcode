package xiaohongshu0326;

import java.util.Arrays;
import java.util.Scanner;

public class Ksort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int groupCount = sc.nextInt();
        for (int i = 0; i < groupCount; i++) {
            int numberCount = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[numberCount];
            for (int j = 0; j < numberCount; j++) {
                arr[j] = sc.nextInt();
            }
            int res = count(arr, k);
            System.out.println(res);
        }

    }

    public static int count(int[] arr, int k) {
        int length = arr.length;
        int index = 1;
        for (int temp : arr) {
            if (temp == index) {
                index++;
            }
        }
        int res = (length - index + 1) / k;
        if ((length - index + 1) % k != 0) {
            res++;
        }
        return res ;
    }

}
