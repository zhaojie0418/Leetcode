package interviewGroup.mayi0328;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class sanjiao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        List<int[]> res = new ArrayList<>();
        res.add(new int[]{1});
        res.add(new int[]{3, 7});
        res.add(new int[]{6, 0, 2});
        res.add(new int[]{11, 8, 13, 10});
        if (height <= 4) {
            for (int i = 1; i <= height; i++) {
                arrPrint(res.get(i-1));
            }
        }
    }

    public static void arrPrint(int[] arr) {
        int length = arr.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length-1; i++) {
            sb.append(arr[i]).append(" ");
        }
        sb.append(arr[length - 1]);
        System.out.println(sb);
    }
}
