package interviewGroup.xiecheng0329;

import java.util.Scanner;

public class goodNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] res = new int[n];
        int bigIndex = n - k + 1;
        int smallIndex = 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0 && bigIndex <= n) {
                res[i] = bigIndex;
                bigIndex++;
            } else {
                res[i] = smallIndex;
                smallIndex++;
            }
        }
        for (int i = 0; i < res.length - 1; i++) {
            System.out.print(res[i]+" ");
        }
        System.out.println(res[res.length - 1]);

    }
}
