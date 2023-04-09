package interviewGroup.tengxun0326;

import java.util.Scanner;

public class countOr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] arr = new int[count];
        int[] pre = new int[count];
        int x = 1;
        for (int i = 0; i < count; i++) {
            arr[i] = sc.nextInt();
            x = x * arr[i];
            pre[i] = x;
        }
        long res = 0;
        for (int i = 0; i < count; i++) {
            for (int j = i; j < count; j++) {
                int or = arr[i];
                for (int temp = i + 1; temp < count && temp <= j; temp++) {
                    or = or ^ arr[temp];
                }
                int and;
                if (i == 0) {
                    and = pre[j];
                }else if (i==j){
                    and = arr[j];
                } else {
                    and = pre[j] / pre[i];
                }
                if (and == or) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
